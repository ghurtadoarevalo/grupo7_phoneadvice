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

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
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

            int nota = calculcarNota(c_positivos,c_neutros,c_negativos);
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
            int nota = calculcarNota(c_positivos,c_neutros,c_negativos);
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

            for(int j = 0 ; j < wordPhoneList.size();j++)
            {
                String word = wordPhoneList.get(j).getContent();
                for(int k = 0 ; k < wordSpecificationList.size();k++)
                {
                    String wordB = wordSpecificationList.get(k).getContent();
                    String wordC = word.replace("_"," ") + " " + wordB;
                    bagWordsPhone.add(wordC);
                }
            }

            List<Tweet> listTweets = new ArrayList<>();

            for(int j = 0 ; j < bagWordsPhone.size(); j++)
            {
                String text = bagWordsPhone.get(j);
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

            Statistic stat = statisticRepository.findByStatisticId(phoneSpecification.getStatistic().getStatisticId());
            stat.setPositive_density(c_positivos);
            stat.setNeutral_density(c_neutros);
            stat.setNegative_density(c_negativos);
            int nota = calculcarNota(c_positivos,c_neutros,c_negativos);
            phoneSpecification.setAssessment(nota);

            statisticRepository.saveAndFlush(stat);
            phoneSpecificationRepository.saveAndFlush(phoneSpecification);


        }
    }

    public int calculcarNota(int pos,int neutro,int neg)
    {
        int nota = 0;
        int auxB = pos+neutro+neg;
        if(auxB != 0) {
            double auxA = (pos - 0.2 * neg) / auxB;
            if (auxA <= 0) {
                nota = 1;
            }
            else {
                double auxC = auxA*7;
                return (int)Math.ceil(auxC);
            }
        }
        return nota;
    }

}
