package com.marondal.springtest.jpa;

import com.marondal.springtest.jpa.domain.Recruit;
import com.marondal.springtest.jpa.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RequestMapping("/jpa/recruit")
@Controller
public class RecruitController {
    @Autowired
    private RecruitRepository recruitRepository;

    @ResponseBody
    @GetMapping("/1")
    public Recruit findRecruit1() {

        Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
        if(optionalRecruit.isPresent()) {
            Recruit recruit = optionalRecruit.get();
            return recruit;
        } else {
            return null;
        }

    }

    
}
