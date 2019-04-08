package com.tbd.phoneadvice.postgre.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.tbd.phoneadvice.postgre.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.tbd.phoneadvice.postgre.repositories.UserRepository;

import java.util.List;


@RestController
@RequestMapping(value = "/test2")
public class UserService {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable int id)
    {
        System.out.println(id);
        return this.repository.findUserById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByName(@PathVariable String name)
    {
        System.out.println(name);
        return this.repository.findUserByName(name);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return this.repository.findAll();
    }
}
