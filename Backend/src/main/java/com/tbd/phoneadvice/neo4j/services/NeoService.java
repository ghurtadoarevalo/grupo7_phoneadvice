package com.tbd.phoneadvice.neo4j.services;


import com.tbd.phoneadvice.elasticsearch.repositories.DataTweetRepository;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.mongo.models.User;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;
import com.tbd.phoneadvice.mongo.repositories.UserRepository;

import com.tbd.phoneadvice.mysql.models.*;
import com.tbd.phoneadvice.mysql.repositories.*;
import com.tbd.phoneadvice.neo4j.models.NodeBrand;
import com.tbd.phoneadvice.neo4j.models.NodeGamma;
import com.tbd.phoneadvice.neo4j.models.NodePhone;
import com.tbd.phoneadvice.neo4j.models.NodeUser;
import com.tbd.phoneadvice.neo4j.repositories.NodeBrandRepository;
import com.tbd.phoneadvice.neo4j.repositories.NodeGammaRepository;
import com.tbd.phoneadvice.neo4j.repositories.NodePhoneRepository;
import com.tbd.phoneadvice.neo4j.repositories.NodeUserRepository;

import org.neo4j.driver.v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/neo")
public class NeoService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NodeBrandRepository nodeBrandRepository;

    @Autowired
    private NodeGammaRepository nodeGammaRepository;

    @Autowired
    private NodePhoneRepository nodePhoneRepository;

    @Autowired
    private NodeUserRepository nodeUserRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private GammaRepository gammaRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private Word_phoneRepository word_phoneRepository;

    @Autowired
    private Word_brandRepository word_brandRepository;

    @Autowired
    private DataTweetRepository dataTweetRepository;

    //--------------------------------------------------------------------------------------------------------//
    //-------------------------TAREA: Retornar todos los nodos y relaciones para front -----------------------//
    //--------------------------------------No existe forma nativa para hacerlo-------------------------------//
    //-------------------------https://neo4j-contrib.github.io/neo4j-apoc-procedures/-------------------------//
    //-----------------------------------------Plugin para traspasar------------------------------------------//
    //--------------------------------------------------------------------------------------------------------//
    /*
    @RequestMapping(value = "/cargarGrafo", method = RequestMethod.GET)
    @ResponseBody
    public StatementResult cargarGrafo() {
        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "canito123" ) );
        Session session = driver.session();
        StatementResult result = session.run( "MATCH (a) return a LIMIT 300");
        session.close();
        driver.close();
        return result;
    }
    //Retorna lista vacia de 250 elementos -> Ver como trasparar resultado de QUERY de Cypher a JSON.
    */


    @RequestMapping(value = "/cargarPesos", method = RequestMethod.GET)
    @ResponseBody
    public void cargarPesos() {
        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "canito123" ) );
        Session session = driver.session();

        //Pesos de los celulares
        //Por cantidad de usuarios que hablan de ella
        StatementResult resultPhone = session.run( "MATCH (p:NodePhone) return p.phoneID as phoneID");
        while(resultPhone.hasNext())
        {
            Record record = resultPhone.next();
            StatementResult resultAux = session.run( "MATCH (p:NodePhone) WHERE p.phoneID="+record.get("phoneID").asLong()+" MATCH (p)<-[TWEET_ABOUT]-(u:NodeUser) return u.userID as userID");
            Double relevancia = 0.0;
            while(resultAux.hasNext())
            {
                Record recordAux = resultAux.next();
                relevancia++;
            }
            NodePhone nodePhone = nodePhoneRepository.findByPhoneID(record.get("phoneID").asLong());
            nodePhone.setSize(relevancia);
            nodePhoneRepository.save(nodePhone);
        }

        //Pesos de la marca
        //Por cantidad de usuarios que hablan de ella, y de sus celulares
        StatementResult resultBrand = session.run( "MATCH (b:NodeBrand) return b.brandID as brandID");
        while(resultBrand.hasNext())
        {
            Record record = resultBrand.next();
            StatementResult resultAuxA = session.run("MATCH (b:NodeBrand) WHERE b.brandID="+record.get("brandID").asLong()+" MATCH (b)-[HAS]->(p:NodePhone) return p.size as size");
            Double sizesPhones = 0.0;
            while(resultAuxA.hasNext())
            {
                Record recordAux = resultAuxA.next();
                Double size = recordAux.get("size").asDouble();
                sizesPhones = sizesPhones + size;
            }
            //Agregar mas valor si habla un usuario de mas peso (?)
            StatementResult resultAuxB = session.run("MATCH (b:NodeBrand) WHERE b.brandID="+record.get("brandID").asLong()+" MATCH (b)<-[TWEET_ABOUT]-(u:NodeUser) return u");
            Double usersCount = 0.0;
            while(resultAuxB.hasNext())
            {
                Record recordAux = resultAuxB.next();
                usersCount++;
            }
            Double relevancia = sizesPhones*0.5 + usersCount*0.5;
            NodeBrand nodeBrand = nodeBrandRepository.findByBrandID(record.get("brandID").asLong());
            nodeBrand.setSize(relevancia);
            nodeBrandRepository.save(nodeBrand);
        }

        //Pesos de los usuarios
            //Por cantidad de seguidores
            //Por pesos de los temas que habla -> Promedio de todos los temas
        StatementResult resultUser = session.run("MATCH (u:NodeUser) RETURN u.userID as userID, u.followersCount as followersCount");
        while(resultUser.hasNext())
        {
            Record record = resultUser.next();
            StatementResult resultBrandAux = session.run("MATCH (u:NodeUser) WHERE u.userID="+record.get("userID").asLong()+" MATCH (u) -[TWEET_ABOUT]-> (b:NodeBrand) RETURN b.size as size");
            Double sizeBrands = 0.0;
            while(resultBrandAux.hasNext())
            {
                Record recordAux = resultBrandAux.next();
                sizeBrands = recordAux.get("size").asDouble() + sizeBrands;
            }
            System.out.println("\nSIZE BRANDS = "+sizeBrands);

            StatementResult resultPhoneAux = session.run("MATCH (u:NodeUser) WHERE u.userID="+record.get("userID").asLong()+" MATCH (u) -[TWEET_ABOUT]-> (b:NodePhone) RETURN b.size as size");
            Double sizePhone = 0.0;
            while(resultPhoneAux.hasNext())
            {
                Record recordAux = resultPhoneAux.next();
                sizePhone = recordAux.get("size").asDouble() + sizePhone;
            }
            int followersCount = record.get("followersCount").asInt();
            Double relevancia = (double)followersCount*0.6+sizeBrands*0.2+sizePhone*0.2;
            NodeUser nodeUser = nodeUserRepository.findByUserID(record.get("userID").asLong());
            nodeUser.setSize(relevancia);
            nodeUserRepository.save(nodeUser);
        }
    }







    @RequestMapping(value = "/loadUsers", method = RequestMethod.GET)
    @ResponseBody
    public void loadUser() {
        List<User> userList = userRepository.findAll();
        for(int i = 0 ; i < userList.size();i++)
        {
            User user = userList.get(i);
            NodeUser nodeUser = new NodeUser(user.getName(),user.getFollowersCount(),user.getId());
            nodeUserRepository.save(nodeUser);
        }
/*
    }

    @RequestMapping(value = "/loadTopics", method = RequestMethod.GET)
    @ResponseBody
    public void loadTopics() {
*/
        List<Brand> brandListA = brandRepository.findAll();
        for(int i = 0 ; i < brandListA.size();i++) {
            Brand brand = brandListA.get(i);
            NodeBrand nodeBrand = new NodeBrand(brand.getName(),brand.getBrandId());
            nodeBrandRepository.save(nodeBrand);
        }
        List<Gamma> gammaList = gammaRepository.findAll();
        for(int i = 0 ; i < gammaList.size();i++) {
            Gamma gamma = gammaList.get(i);
            NodeGamma nodeGamma = new NodeGamma(gamma.getName(),gamma.getGammaId());
            nodeGammaRepository.save(nodeGamma);
        }
        List<Phone> phoneListA = phoneRepository.findAll();
        for(int i = 0 ; i < phoneListA.size();i++) {
            Phone phone = phoneListA.get(i);
            NodePhone nodePhone = new NodePhone(phone.getModel(),phone.getPhoneId());
            nodePhoneRepository.save(nodePhone);
        }
/*
    }

    @RequestMapping(value = "/loadRelationsA", method = RequestMethod.GET)
    @ResponseBody
    public void loadStaticRelations()
    {
*/
        //Cargar relaciones de gamma
        Iterator<NodeGamma> gammaNodeList = nodeGammaRepository.findAll().iterator();
        while(gammaNodeList.hasNext())
        {
            NodeGamma nodeGamma = gammaNodeList.next();
            List<NodePhone> nodePhoneList = nodeGamma.getPhones();

            List<Phone> phoneList = phoneRepository.findAllByGammaGammaId(nodeGamma.getGammaID());

            for(int i = 0 ; i < phoneList.size();i++) {
                Phone phone = phoneList.get(i);
                NodePhone nodePhone = nodePhoneRepository.findByPhoneID(phone.getPhoneId());
                nodePhoneList.add(nodePhone);
            }
            nodeGammaRepository.save(nodeGamma);
        }

        //Cargar relaciones de marca
        Iterator<NodeBrand> gammaBrandList = nodeBrandRepository.findAll().iterator();
        while(gammaBrandList.hasNext())
        {
            NodeBrand nodeBrand = gammaBrandList.next();
            List<NodePhone> nodePhoneList = nodeBrand.getPhones();

            List<Phone> phoneList = phoneRepository.findAllByBrandBrandId(nodeBrand.getBrandID());

            for(int i = 0 ; i < phoneList.size();i++) {
                Phone phone = phoneList.get(i);
                NodePhone nodePhone = nodePhoneRepository.findByPhoneID(phone.getPhoneId());
                nodePhoneList.add(nodePhone);
            }
            nodeBrandRepository.save(nodeBrand);
        }
/*
    }

    @RequestMapping(value = "/loadRelationsB", method = RequestMethod.GET)
    @ResponseBody
    public void loadTweetsRelations()
    {
*/
        List<Phone> phoneList = phoneRepository.findAll();
        for(int i = 0 ; i < phoneList.size();i++)
        {
            Phone phone = phoneList.get(i);
            List<WordPhone> wordPhoneList = word_phoneRepository.findByPhone_phoneId(phone.getPhoneId());

            List<String> bagWords = new ArrayList<>();
            for(int j = 0 ; j < wordPhoneList.size();j++)
            {
                String contenido = wordPhoneList.get(j).getContent();
                bagWords.add(contenido.replace("_"," "));
            }

            List<Tweet> listTweets = new ArrayList<>();
            obtenerTweets(bagWords,listTweets);

            for(int j = 0 ; j < listTweets.size();j++)
            {
                Tweet tweet = listTweets.get(j);
                Long userID = tweet.getUser().getId();
                NodeUser nodeUser = nodeUserRepository.findByUserID(userID);

                System.out.println(tweet.getUser().getId()+"\n");

                NodePhone nodePhone = nodePhoneRepository.findByPhoneID(phone.getPhoneId());
                List<NodePhone> list = nodeUser.getPhones();
                list.add(nodePhone);
                nodeUserRepository.save(nodeUser);


            }
        }

        List<Brand> brandList = brandRepository.findAll();
        for(int i = 0 ; i < brandList.size();i++)
        {
            Brand brand = brandList.get(i);
            List<WordBrand> wordBrandList = word_brandRepository.findByBrand_BrandId(brand.getBrandId());

            List<String> bagWords = new ArrayList<>();
            for(int j = 0 ; j < wordBrandList.size();j++)
            {
                String contenido = wordBrandList.get(j).getContent();
                bagWords.add(contenido.replace("_"," "));
            }

            List<Tweet> listTweets = new ArrayList<>();
            obtenerTweets(bagWords,listTweets);

            for(int j = 0 ; j < listTweets.size();j++)
            {
                Tweet tweet = listTweets.get(j);
                NodeUser nodeUser = nodeUserRepository.findByUserID(tweet.getUser().getId());
                NodeBrand nodeBrand = nodeBrandRepository.findByBrandID(brand.getBrandId());
                List<NodeBrand> list = nodeUser.getBrands();
                list.add(nodeBrand);
                nodeUserRepository.save(nodeUser);
            }
        }
    }


    public void obtenerTweets(List<String> bagWords,List<Tweet> listTweets)
    {
        for(int j = 0 ; j < bagWords.size(); j++)
        {
            String text = bagWords.get(j);
            List<Tweet> aux= dataTweetRepository.findByText(text);
            for(int k = 0 ; k < aux.size();k++) { listTweets.add(aux.get(k)); }
        }
    }

}
