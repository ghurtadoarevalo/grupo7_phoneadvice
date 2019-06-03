package com.tbd.phoneadvice.mysql.services;

import com.tbd.phoneadvice.mysql.models.Phone;
import com.tbd.phoneadvice.mysql.models.PhoneSpecification;
import com.tbd.phoneadvice.mysql.repositories.PhoneSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/phones_specifications")
@CrossOrigin(origins = "*")
public class PhoneSpecificationService {
    @Autowired
    private PhoneSpecificationRepository phoneSpecificationRepository;

    @RequestMapping(value = "/{specification_id}/specification", method = RequestMethod.GET)
    @ResponseBody
    public List<PhoneSpecification> gePhoneSpecificationById(@PathVariable Long specification_id)
    {
        /*
        List<PhoneSpecification> phoneSpecifications = phoneSpecificationRepository.findByPsId_SpecificationIdOrderByAssessmentDesc(specification_id);
        List<Phone> phones = new ArrayList<>();
        for (PhoneSpecification phoneSpecification: phoneSpecifications)
        {
            phones.add(phoneSpecification.getPhone());
        }*/

        return phoneSpecificationRepository.findByPsId_SpecificationIdOrderByAssessmentDesc(specification_id);

    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<PhoneSpecification> getAll()
    {
        return phoneSpecificationRepository.findAll();

    }


}
