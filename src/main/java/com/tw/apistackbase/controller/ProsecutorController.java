package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Prosecutor;
import com.tw.apistackbase.repository.ProsecutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProsecutorController {

    @Autowired
    ProsecutorRepo prosecutorRepository;

    @GetMapping(value = "/prosecutors")
    public List<Prosecutor> getAll(){
        return prosecutorRepository.findAll();
    }


}
