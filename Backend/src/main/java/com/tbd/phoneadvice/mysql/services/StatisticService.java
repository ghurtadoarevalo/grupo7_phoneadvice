package com.tbd.phoneadvice.mysql.services;


import com.tbd.phoneadvice.elasticsearch.repositories.DataTweetRepository;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.mysql.models.*;
import com.tbd.phoneadvice.mysql.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/statistic")
@CrossOrigin(origins = "*")
public class StatisticService {

    @Autowired
    private Word_phoneRepository word_phoneRepository;

    @Autowired
    private Word_brandRepository word_brandRepository;

    @Autowired
    private Word_specificationRepository word_specificationRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private SpecificationRepository specificationRepository;

    @Autowired
    private PhoneSpecificationRepository phoneSpecificationRepository;

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private DataTweetRepository dataTweetRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public void almacenarStatCelulares()
    {
        List<Phone> listPhones = phoneRepository.findAll();
        for(int i = 0 ; i < listPhones.size();i++)
        {
            Phone phone = listPhones.get(i);
            List<WordPhone> wordPhoneList = word_phoneRepository.findByPhone_phoneId(phone.getPhoneId());
            List<String> bagWords = new ArrayList<>();

            for(int j = 0 ; j < wordPhoneList.size();j++)
            {
               String contenido = wordPhoneList.get(j).getContent();
               bagWords.add(contenido.replace("_"," "));
            }
            List<Tweet> listTweets = new ArrayList<>();
            for(int j = 0 ; j < bagWords.size(); j++)
            {
                String text = bagWords.get(j);
                List<Tweet> aux= dataTweetRepository.findByText(text);
                for(int k = 0 ; k < aux.size();k++) { listTweets.add(aux.get(k)); }
            }

            int c_positivos = 0;
            int c_neutros = 0;
            int c_negativos = 0;

            for(int j = 0 ; j < listTweets.size();j++)
            {
                Tweet tweet = listTweets.get(j);
                if(tweet.getSentiment().equals("positivo")) {
                    c_positivos++;
                }
                else if(tweet.getSentiment().equals("neutro")) {
                    c_neutros++;
                }
                else if(tweet.getSentiment().equals("negativo")) {
                    c_negativos++;
                }
            }
            Statistic stat = statisticRepository.findByStatisticId(phone.getStatistic().getStatisticId());
            stat.setPositive_density(c_positivos);
            stat.setNeutral_density(c_neutros);
            stat.setNegative_density(c_negativos);

            int nota = 2;
            phone.setAssessment(nota);

            statisticRepository.saveAndFlush(stat);
            phoneRepository.saveAndFlush(phone);
        }
    }
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public void almacenarStatMarcas() {
        List<Brand> listBrand = brandRepository.findAll();
        for(int i = 0 ; i < listBrand.size();i++)
        {
            Brand brand = listBrand.get(i);
            List<WordBrand> listBrandWords = word_brandRepository.findByBrand_BrandId(brand.getBrandId());
            List<String> bagWords = new ArrayList<>();

            for(int j = 0 ; j < listBrandWords.size() ; j++)
            {
                String word = listBrandWords.get(j).getContent();
                bagWords.add(word.replace("_"," "));
            }
            List<Tweet> listTweets = new ArrayList<>();

            for(int j = 0 ; j < bagWords.size(); j++)
            {
                String text = bagWords.get(j);
                List<Tweet> aux= dataTweetRepository.findByText(text);
                for(int k = 0 ; k < aux.size();k++) { listTweets.add(aux.get(k)); }
            }
            int c_positivos = 0;
            int c_neutros = 0;
            int c_negativos = 0;
            for(int j = 0 ; j < listTweets.size();j++)
            {
                Tweet tweet = listTweets.get(j);
                if(tweet.getSentiment().equals("positivo")) {
                    c_positivos++;
                }
                else if(tweet.getSentiment().equals("neutro")) {
                    c_neutros++;
                }
                else if(tweet.getSentiment().equals("negativo")) {
                    c_negativos++;
                }
            }
            Statistic stat = statisticRepository.findByStatisticId(brand.getStatistic().getStatisticId());
            stat.setPositive_density(c_positivos);
            stat.setNeutral_density(c_neutros);
            stat.setNegative_density(c_negativos);
            int nota = 2;
            brand.setAssessment(nota);
            statisticRepository.saveAndFlush(stat);
            brandRepository.saveAndFlush(brand);

        }
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    @ResponseBody
    public void almacenarStatPhoneSpec() {
        List<PhoneSpecification> listPS = phoneSpecificationRepository.findAll();
        for(int i = 0 ; i < listPS.size(); i++)
        {
            PhoneSpecification phoneSpecification = listPS.get(i);
            Phone phone = phoneRepository.getOne(listPS.get(i).getPhone().getPhoneId());
            Specification specification = specificationRepository.getOne(listPS.get(i).getSpecification().getSpecificationId());

            List<WordPhone> wordPhoneList = word_phoneRepository.findByPhone_phoneId(phone.getPhoneId());
            List<WordSpecification> wordSpecificationList = word_specificationRepository.findBySpecification_SpecificationId(specification.getSpecificationId());

            List<String> bagWordsPhone = new ArrayList<>();
            List<String> bagWordsSpec = new ArrayList<>();

            for(int j = 0 ; j < wordPhoneList.size();j++)
            {
                String word = wordPhoneList.get(j).getContent();
                bagWordsPhone.add(word);
            }

            for(int j = 0 ; j < wordSpecificationList.size();j++)
            {
                String word = wordSpecificationList.get(j).getContent();
                bagWordsSpec.add(word);
            }

            List<Tweet> listTweetsA = new ArrayList<>();
            for(int j = 0 ; j < bagWordsPhone.size();j++)
            {
                String text = bagWordsPhone.get(j);
                List<Tweet> aux= dataTweetRepository.findByText(text);
                for(int k = 0 ; k < aux.size();k++) { listTweetsA.add(aux.get(k)); }
            }

            List<Tweet> listTweetsB = new ArrayList<>();
            for(int j = 0 ; j < bagWordsSpec.size();j++)
            {
                String text = bagWordsSpec.get(j);
                List<Tweet> aux= dataTweetRepository.findByText(text);
                for(int k = 0 ; k < aux.size();k++) { listTweetsB.add(aux.get(k)); }
            }

            List<Tweet> listTweetsC = new ArrayList<>();
            for(int j = 0 ; j < listTweetsA.size();j++)
            {
                Long tweetId = listTweetsA.get(j).getId();
                for(int k = 0 ; k < listTweetsB.size();k++)
                {
                    Long tweetAuxId = listTweetsB.get(k).getId();
                    if(tweetId == tweetAuxId) {
                        listTweetsC.add(listTweetsB.get(k));
                        break;
                    }
                }
            }

            int c_positivos = 0;
            int c_neutros = 0;
            int c_negativos = 0;
            for(int j = 0 ; j < listTweetsC.size();j++)
            {
                Tweet tweet = listTweetsC.get(j);
                if(tweet.getSentiment().equals("positivo")) {
                    c_positivos++;
                }
                else if(tweet.getSentiment().equals("neutro")) {
                    c_neutros++;
                }
                else if(tweet.getSentiment().equals("negativo")) {
                    c_negativos++;
                }
            }

            Statistic stat = phoneSpecification.getStatistic();
            stat.setPositive_density(c_positivos);
            stat.setNeutral_density(c_neutros);
            stat.setNegative_density(c_negativos);
            statisticRepository.saveAndFlush(stat);

            //De la lista tweetsA y tweetsB
            //Filtrar por ambas en elastic search
            //Resultantes, obtener positivos, negativos y neutros.



        }
    }
}
