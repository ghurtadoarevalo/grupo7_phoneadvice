package com.tbd.phoneadvice.mysql.services;

import com.tbd.phoneadvice.mysql.models.Brand;
import com.tbd.phoneadvice.mysql.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brands")
@CrossOrigin(origins = "*")

public class BrandService {
    @Autowired
    private BrandRepository brandRepository;


    @GetMapping(value = "/")
    @ResponseBody
    public List<Brand> getAllOrderedByAssesmentDesc() {return brandRepository.findAllByOrderByAssessmentDesc();}

}
