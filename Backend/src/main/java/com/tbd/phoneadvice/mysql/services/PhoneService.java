package com.tbd.phoneadvice.mysql.services;

import com.tbd.phoneadvice.mysql.models.Phone;
import com.tbd.phoneadvice.mysql.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/phones")
@CrossOrigin(origins = "*")
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<Phone> getAll()
    {
        return phoneRepository.findAll();
    }

    /*
    @RequestMapping(value = "/{specification_id}/specification", method = RequestMethod.GET)
    @ResponseBody
    public List<Phone> getPhonesBySpecificationId(@PathVariable Long specification_id)
    {
        //return phoneRepository.findBySpecifications_Specification_id(specification_id);
    }
*/

}
