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

    private int max_p_pos = 0;
    private int max_p_neutro = 0;
    private int max_p_neg = 0;

    private int max_b_pos = 0;
    private int max_b_neutro = 0;
    private int max_b_neg = 0;

    private int max_ps_pos = 0;
    private int max_ps_neutro = 0;
    private int max_ps_neg = 0;


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
            if(max_p_pos < c_positivos) {max_p_pos = c_positivos; }
            if(max_p_neutro < c_neutros){max_p_neutro = c_neutros;}
            if(max_p_neg < c_negativos){max_p_neg = c_negativos;}
            //int nota = calculcarNota(c_positivos,c_neutros,c_negativos);
            //phone.setAssessment(nota);

            statisticRepository.saveAndFlush(stat);
            //phoneRepository.saveAndFlush(phone);
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
            if(max_b_pos < c_positivos) {max_b_pos = c_positivos; }
            if(max_b_neutro < c_neutros){max_b_neutro = c_neutros;}
            if(max_b_neg < c_negativos){max_b_neg = c_negativos;}
            statisticRepository.saveAndFlush(stat);

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
            if(max_ps_pos < c_positivos) {max_ps_pos = c_positivos; }
            if(max_ps_neutro < c_neutros){max_ps_neutro = c_neutros;}
            if(max_ps_neg < c_negativos){max_ps_neg = c_negativos;}

            statisticRepository.saveAndFlush(stat);


        }
    }


    @RequestMapping(value = "/test4", method = RequestMethod.GET)
    @ResponseBody
    public void almacenarNotas() {
        //Celulares
        List<Phone> listA = phoneRepository.findAll();
        List<Brand> listB = brandRepository.findAll();
        List<PhoneSpecification> listC = phoneSpecificationRepository.findAll();

        for(int i = 0 ; i < listA.size();i++)
        {
            Phone phone = listA.get(i);
            Statistic statistic = phone.getStatistic();
            int pos = statistic.getPositive_density();
            if(pos >= max_p_pos)
            {
                max_p_pos = pos;
            }
        }
        for(int i = 0 ; i < listB.size();i++)
        {
            Brand brand = listB.get(i);
            Statistic statistic = brand.getStatistic();
            int pos = statistic.getPositive_density();
            if(pos >= max_b_pos)
            {
                max_b_pos = pos;
            }
        }
        for(int i = 0 ; i < listC.size();i++)
        {
            PhoneSpecification phoneSpecification = listC.get(i);
            Statistic statistic = phoneSpecification.getStatistic();
            int pos = statistic.getPositive_density();
            if(pos >= max_ps_pos)
            {
                max_ps_pos = pos;
            }
        }


        for(int i = 0 ; i < listA.size();i++)
        {
            Phone phone = listA.get(i);
            Statistic statistic = phone.getStatistic();
            int pos = statistic.getPositive_density();
            int neu = statistic.getNeutral_density();
            int neg = statistic.getNegative_density();
            System.out.println("\nStats"+pos+" "+neg+" "+max_p_pos);
            int nota = calcularNota(pos,neu,neg,max_p_pos);
            phone.setAssessment(nota);
            phoneRepository.saveAndFlush(phone);
        }

        for(int i = 0 ; i < listB.size();i++)
        {
            Brand brand = listB.get(i);
            Statistic statistic = brand.getStatistic();
            int pos = statistic.getPositive_density();
            int neu = statistic.getNeutral_density();
            int neg = statistic.getNegative_density();
            System.out.println("\nStats"+pos+" "+neg+" "+max_b_pos);
            int nota = calcularNota(pos,neu,neg,max_b_pos);
            brand.setAssessment(nota);
            brandRepository.saveAndFlush(brand);
        }


        for(int i = 0 ; i < listC.size();i++)
        {
            PhoneSpecification phoneSpecification = listC.get(i);
            Statistic statistic = phoneSpecification.getStatistic();
            int pos = statistic.getPositive_density();
            int neu = statistic.getNeutral_density();
            int neg = statistic.getNegative_density();
            System.out.println("\nStats"+pos+" "+neg+" "+max_ps_pos);
            int nota = calcularNota(pos,neu,neg,max_ps_pos);
            phoneSpecification.setAssessment(nota);
            phoneSpecificationRepository.saveAndFlush(phoneSpecification);
        }



    }

    public int calcularNota(int pos,int neutro,int neg,int max_pos)
    {
        double total = pos + neg;
        if(total == 0)
        {
            return 0;
        }
        else {
            double auxA = pos * 100 /total;
            double auxB = pos * 100/(double)max_pos;
            double auxC = auxA*0.5 + auxB*0.5;
            System.out.println("\n"+auxA+" "+auxB+" "+auxC);
            return (int) auxC;
        }
    }
}
