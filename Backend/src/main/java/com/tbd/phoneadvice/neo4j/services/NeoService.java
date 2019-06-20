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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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



    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    @ResponseBody
    public void deleteAll()
    {
        //Remover relaciones
        //Remover nodos
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
                System.out.println("user "+ tweet.getUser().getName() + "\n");
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
