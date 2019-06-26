package com.tbd.phoneadvice.neo4j.services;


import com.tbd.phoneadvice.elasticsearch.repositories.DataTweetRepository;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.mongo.models.User;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;
import com.tbd.phoneadvice.mongo.repositories.UserRepository;

import com.tbd.phoneadvice.mysql.models.*;
import com.tbd.phoneadvice.mysql.repositories.*;
import com.tbd.phoneadvice.neo4j.models.*;
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

    private String uri = "bolt://178.128.227.134";
    private String user = "neo4j";
    private String password = "lolis123";
    //private String uri = "bolt://localhost";
    //private String user = "neo4j";
    //private String password = "canito123";

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
    //D3 links nodes
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

    @RequestMapping(value = "/fullNodos", method = RequestMethod.GET)
    @ResponseBody
    public List<nodo> grafoCompleto() {
        Driver driver = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user,this.password ) );
        Session session = driver.session();
        List<nodo> list = new ArrayList<>();
        StatementResult result = session.run("MATCH (u:NodeUser) RETURN id(u) as id, u.name as name, u.size as size");
        while(result.hasNext())
        {
            Record record = result.next();
            nodo nuevoNodo = new nodo();
            nuevoNodo.setId(record.get("id").asLong());
            nuevoNodo.setNombre(record.get("name").asString());
            nuevoNodo.setPeso(record.get("size").asDouble());
            list.add(nuevoNodo);
        }
        StatementResult result2 = session.run("MATCH (p:NodePhone) RETURN id(p) as id, p.model as name, p.size as size");
        while(result2.hasNext())
        {
            Record record = result2.next();
            nodo nuevoNodo = new nodo();
            nuevoNodo.setId(record.get("id").asLong());
            nuevoNodo.setNombre(record.get("name").asString());
            nuevoNodo.setPeso(record.get("size").asDouble());
            list.add(nuevoNodo);
        }
        StatementResult result3 = session.run("MATCH (b:NodeBrand) RETURN id(b) as id, b.brandName as name, b.size as size");
        while(result3.hasNext())
        {
            Record record = result3.next();
            nodo nuevoNodo = new nodo();
            nuevoNodo.setId(record.get("id").asLong());
            nuevoNodo.setNombre(record.get("name").asString());
            nuevoNodo.setPeso(record.get("size").asDouble());
            list.add(nuevoNodo);
        }
        StatementResult result4 = session.run("MATCH (g:NodeGamma) RETURN id(g) as id, g.gammaName as name, g.size as size");
        while(result4.hasNext())
        {
            Record record = result4.next();
            nodo nuevoNodo = new nodo();
            nuevoNodo.setId(record.get("id").asLong());
            nuevoNodo.setNombre(record.get("name").asString());
            nuevoNodo.setPeso(record.get("size").asDouble());
            list.add(nuevoNodo);
        }

        return list;
    }

    @RequestMapping(value = "/fullAristas", method = RequestMethod.GET)
    @ResponseBody
    public List<Arista> aristasCompletas() {
        Driver driver = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user,this.password ) );
        Session session = driver.session();
        List<Arista> list = new ArrayList<>();
        StatementResult result = session.run("MATCH (a)-[r]->(b) RETURN id(a) as source, id(b) as target, type(r) as caption");
        while(result.hasNext()){
            Record record = result.next();
            Arista nuevaArista = new Arista();
            nuevaArista.setSource(record.get("source").asLong());
            nuevaArista.setTarget(record.get("target").asLong());
            nuevaArista.setType(record.get("caption").asString());
            list.add(nuevaArista);
        }
        return list;
    }




    @RequestMapping(value = "/cargarPesos", method = RequestMethod.GET)
    @ResponseBody
    public void cargarPesos() {
        Driver driver = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user,this.password ) );
        Session session = driver.session();


        //Pesos de los usuarios
        //Por cantidad de seguidores
        //Por pesos de los temas que habla -> Promedio de todos los temas
        StatementResult resultUser = session.run("MATCH (u:NodeUser) RETURN u.userID as userID, u.followersCount as followersCount");
        while(resultUser.hasNext())
        {
            Record record = resultUser.next();
            int followersCount = record.get("followersCount").asInt();
            Double relevancia = (double)followersCount;
            NodeUser nodeUser = nodeUserRepository.findByUserID(record.get("userID").asLong());
            nodeUser.setSize(relevancia);
            nodeUserRepository.save(nodeUser);
        }


        //Pesos de los celulares
        //Por cantidad de usuarios que hablan de ella

        StatementResult resultPhone = session.run( "MATCH (p:NodePhone) RETURN p.phoneID as phoneID");
        while(resultPhone.hasNext())
        {
            Record record = resultPhone.next();
            StatementResult resultAux = session.run( "MATCH (p:NodePhone) WHERE p.phoneID="+record.get("phoneID").asLong()+" MATCH (p)<-[TWEET_ABOUT]-(u:NodeUser) RETURN u.followersCount as followersCount, u.phoneID as phoneID");
            Double relevancia = 0.0;
            while(resultAux.hasNext())
            {
                Record recordAux = resultAux.next();
                int followersCount = recordAux.get("followersCount").asInt();
                relevancia = relevancia + (long)followersCount*0.3;
            }
            NodePhone nodePhone = nodePhoneRepository.findByPhoneID(record.get("phoneID").asLong());
            nodePhone.setSize(relevancia);
            nodePhoneRepository.save(nodePhone);
        }



        //Pesos de la marca
        //Por cantidad de usuarios que hablan de ella, y de sus celulares
        StatementResult resultBrand = session.run( "MATCH (b:NodeBrand) RETURN b.brandID as brandID");
        while(resultBrand.hasNext())
        {
            Record record = resultBrand.next();
            StatementResult resultAuxA = session.run("MATCH (b:NodeBrand) WHERE b.brandID="+record.get("brandID").asLong()+" MATCH (b)-[HAS]->(p:NodePhone) RETURN p.size as size");
            Double sizesPhones = 0.0;
            while(resultAuxA.hasNext())
            {
                Record recordAux = resultAuxA.next();
                Double size = recordAux.get("size").asDouble();
                sizesPhones = sizesPhones + size;
            }

            StatementResult resultAuxB = session.run("MATCH (b:NodeBrand) WHERE b.brandID="+record.get("brandID").asLong()+" MATCH (b)<-[TWEET_ABOUT]-(u:NodeUser) RETURN u.followersCount as followersCount");
            Double usersCount = 0.0;
            while(resultAuxB.hasNext())
            {
                Record recordAux = resultAuxB.next();
                int followersCount = recordAux.get("followersCount").asInt();
                usersCount = followersCount*0.3 + usersCount;
            }
            Double relevancia = sizesPhones*0.75 + usersCount*0.25;
            NodeBrand nodeBrand = nodeBrandRepository.findByBrandID(record.get("brandID").asLong());
            nodeBrand.setSize(relevancia);
            nodeBrandRepository.save(nodeBrand);
        }
        session.close();
        driver.close();
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

    //--------------------------------------SERVICIOS--------------------------------------//

    //Funcion: Funcion que retorna los top 5 de usuarios mas relevantes que hablan de una gamma, adjunto con los celulares
    //         que hablaron de esa gamma.
    //Entrada: id de una gamma

    @RequestMapping(value = "/getRelevantGamma/{gammaID}", method = RequestMethod.GET)
    @ResponseBody
    public List<NodeUser> relevantUserGamma(@PathVariable Long gammaID)
    {
        Gamma gammaA = gammaRepository.findByGammaId(gammaID);
        if(gammaA == null) {
            return null;
        }
        else {
            Driver driver = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user,this.password ) );
            Session session = driver.session();
            List<NodeUser> list = new ArrayList<>();
            StatementResult result = session.run("MATCH (g:NodeGamma) WHERE g.gammaID="+gammaA.getGammaId()+" MATCH (g) -[RELATED]-> (n:NodePhone) RETURN n.phoneID as phoneID");
            while(result.hasNext())
            {
                Record record = result.next();
                StatementResult resultAux = session.run("MATCH (p:NodePhone) WHERE p.phoneID="+record.get("phoneID").asLong()+" MATCH (p) <-[TWEET_ABOUT]- (u:NodeUser) RETURN u.userID as userID,u.size as size");
                while(resultAux.hasNext())
                {
                    Record recordAux = resultAux.next();
                    NodeUser nodeUser = nodeUserRepository.findByUserID(recordAux.get("userID").asLong());
                    StatementResult resultAuxAux = session.run("MATCH (p:NodePhone) <-[TWEET_ABOUT]- (u:NodeUser) WHERE u.userID= "+recordAux.get("userID").asLong()+" MATCH (p) <-[RELATED]- (g:NodeGamma) WHERE g.gammaID="+gammaA.getGammaId()+" RETURN p.phoneID as phoneID");
                    List<NodePhone> listPhones = new ArrayList<>();
                    while(resultAuxAux.hasNext())
                    {
                        resultAuxAux.next();
                        listPhones.add(nodePhoneRepository.findByPhoneID(record.get("phoneID").asLong()));
                    }
                    nodeUser.setPhones(listPhones);
                    nodeUser.setBrands(null);
                    nodeUser.setFromUser(userRepository.findUserById(nodeUser.getUserID()));
                    list.add(nodeUser);
                }
            }

            Comparator<NodeUser> compareBySize = new Comparator<NodeUser>() {
                @Override
                public int compare(NodeUser o1, NodeUser o2) {
                    return Double.compare(o2.getSize(),o1.getSize());
                }
            };

            Collections.sort(list,compareBySize);

            List<NodeUser> listFinal = new ArrayList<>();
            int max= list.size();
            if(max > 5) { max = 5; }
            for(int i = 0 ; i < max; i++) {
                listFinal.add(list.get(i));
            }
            session.close();
            driver.close();
            return listFinal;
        }
    }

    /*
    //Funcion: Funcion que retorna los celulares que hablo un usuario en relacion a una gamma.
    //Entrada: id de una gamma, id de un usuario.
    @RequestMapping(value = "/getGammaUser/{gammaID}/{userID}", method = RequestMethod.GET)
    @ResponseBody
    public List<NodePhone> userGammaPhones(@PathVariable Long gammaID,@PathVariable Long userID)
    {
        Gamma gammaA = gammaRepository.findByGammaId(gammaID);
        NodeUser userA = nodeUserRepository.findByUserID(userID);
        if(gammaA == null) {
            return null;
        }
        if(userA == null) {
            return null;
        }
        else
        {
            Driver driver = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user,this.password ) );
            Session session = driver.session();
            List<NodePhone> list = new ArrayList<>();
            StatementResult result = session.run("MATCH (g:NodeGamma) WHERE g.gammaID="+gammaA.getGammaId()+" MATCH (g) -[RELATED]-> (p:NodePhone) MATCH (p) <-[TWEET_ABOUT]- (u:NodeUser) WHERE u.userID="+userID+" RETURN p.phoneID as phoneID");
            while(result.hasNext())
            {
                Record record = result.next();
                list.add(nodePhoneRepository.findByPhoneID(record.get("phoneID").asLong()));
            }
            session.close();
            driver.close();
            return list;
        }
    }
    */

    /*
    //Funcion: Funcion que retorna las marcas ordenadas por peso, con los 5 usuarios mas relevantes que hablan por marca.
    //Entrada: id de una marca.
    @RequestMapping(value = "/getUserBrand", method = RequestMethod.GET)
    @ResponseBody
    public List<NodeUser> userBrand(@PathVariable Long brandID) {
        NodeBrand brandAux = nodeBrandRepository.findByBrandID(brandID);
        if(brandAux == null) {
            return null;
        }
        else {
            Driver driver = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user,this.password ) );
            Session session = driver.session();
            List<Brand> list = new ArrayList<>();
            StatementResult result = session.run("MATCH (b:NodeBrand) WHERE b.brandID="+brandAux.getBrandID()+" MATCH (b) <-[TWEET_ABOUT]- (u:NodeUser) RETURN u.userID as userID");
            while(result.hasNext()) {
                Record record = result.next();
                list.add(nodeUserRepository.findByUserID(record.get("userID").asLong()));
            }

            Comparator<Brand> compareBySize = new Comparator<Brand>() {
                @Override
                public int compare(Brand o1, Brand o2) {
                    return Double.compare(o2.getSize(),o1.getSize());
                }
            };

            Collections.sort(list,compareBySize);
            List<Brand> listFinal = new ArrayList<>();
            int max= list.size();
            if(max > 5) { max = 5; }
            for(int i = 0 ; i < max; i++) {
                listFinal.add(list.get(i));
            }
            session.close();
            driver.close();
            return listFinal;
        }
    }
    */


    //Funcion: Funcion que retorna las marcas ordenadas por peso, con los 5 usuarios mas relevantes que hablan por marca.
    //Entrada: N/A
    @RequestMapping(value = "/getBrands", method = RequestMethod.GET)
    @ResponseBody
    public List<NodeBrand> getBrands() {
        List<NodeBrand> listBrand = new ArrayList<>();
        Driver driver = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user,this.password ) );
        Session session = driver.session();
        StatementResult result = session.run("MATCH (b:NodeBrand) RETURN b.brandID as brandID, b.size as size,b.brandName as brandName");
        while(result.hasNext())
        {
            Record record = result.next();
            StatementResult resultAux = session.run("MATCH (b:NodeBrand) WHERE b.brandID="+record.get("brandID").asLong()+" MATCH (b) <-[TWEET_ABOUT]- (u:NodeUser) RETURN u.userID as userID");
            List<User> userList = new ArrayList<>();

            while(resultAux.hasNext()) {
                Record recordAux = resultAux.next();
                userList.add(userRepository.findUserById(recordAux.get("userID").asLong()));
            }

            Comparator<User> compareByFollowers = new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return Integer.compare(o2.getFollowersCount(),o1.getFollowersCount());
                }
            };

            Collections.sort(userList,compareByFollowers);
            List<User> userListFinal = new ArrayList<>();
            int max= userList.size();
            if(max > 5) { max = 5; }
            for(int i = 0 ; i < max; i++) {
                userListFinal.add(userList.get(i));
            }
            NodeBrand nodeBrand = nodeBrandRepository.findByBrandID(record.get("brandID").asLong());
            nodeBrand.setUsers(userListFinal);
            nodeBrand.setPhones(null);
            listBrand.add(nodeBrand);
        }

        Comparator<NodeBrand> compareBySize = new Comparator<NodeBrand>() {
            @Override
            public int compare(NodeBrand o1, NodeBrand o2) {
                return Double.compare(o2.getSize(),o1.getSize());
            }
        };

        Collections.sort(listBrand,compareBySize);
        session.close();
        driver.close();
        return listBrand;
    }




    //Funcion: Funcion que retorna los celulares ordenados por relevancia
    //Entrada: N/A
    @RequestMapping(value = "/getPhones", method = RequestMethod.GET)
    @ResponseBody
    public List<NodePhone> getPhones() {
        List<NodePhone> list = new ArrayList<>();
        Driver driver = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user,this.password ) );
        Session session = driver.session();
        StatementResult result = session.run("MATCH (b:NodePhone) RETURN b.phoneID as phoneID");
        while(result.hasNext())
        {
            Record record = result.next();
            list.add(nodePhoneRepository.findByPhoneID(record.get("phoneID").asLong()));
        }

        Comparator<NodePhone> compareBySize = new Comparator<NodePhone>() {
            @Override
            public int compare(NodePhone o1, NodePhone o2) {
                return o2.getSize().compareTo(o1.getSize());
            }
        };
        Collections.sort(list,compareBySize);
        session.close();
        driver.close();
        return list;
    }



}
