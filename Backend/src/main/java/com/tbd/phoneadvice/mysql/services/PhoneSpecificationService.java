package com.tbd.phoneadvice.mysql.services;

import com.tbd.phoneadvice.mysql.models.PhoneSpecification;
import com.tbd.phoneadvice.mysql.repositories.PhoneSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/phones_specifications")
@CrossOrigin(origins = "*")
public class PhoneSpecificationService {
    @Autowired
    private PhoneSpecificationRepository phoneSpecificationRepository;

    @RequestMapping(value = "/{specification_id}/specification", method = RequestMethod.GET)
    @ResponseBody
    public List<PhoneSpecification> gePhoneSpecificationbyId(@PathVariable Long specification_id)
    {
        return phoneSpecificationRepository.findByPsId_SpecificationIdOrderByAssessmentAsc(specification_id);

    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<PhoneSpecification> getAll()
    {
        return phoneSpecificationRepository.findAll();

    }


}
