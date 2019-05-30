package com.tbd.phoneadvice.mysql.services;

import com.tbd.phoneadvice.mysql.repositories.PhoneSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/phones_specifications")
@CrossOrigin(origins = "*")
public class PhoneSpecificationService {
    @Autowired
    private PhoneSpecificationRepository phoneSpecificationRepository;


}
