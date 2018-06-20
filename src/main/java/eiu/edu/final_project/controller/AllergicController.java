package eiu.edu.final_project.controller;

import eiu.edu.final_project.domain.Allergic;
import eiu.edu.final_project.repository.IAllergicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/allergic")
public class AllergicController {

    @Autowired
    IAllergicRepository iAllergicRepository;

    @RequestMapping
    public List<Allergic> getAllAllergic(){
        return iAllergicRepository.findAll();
    }

    
}
