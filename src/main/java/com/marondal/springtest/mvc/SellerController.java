package com.marondal.springtest.mvc;

import com.marondal.springtest.mvc.domain.Seller;
import com.marondal.springtest.mvc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @ResponseBody
    @PostMapping("/add")
    public String addSeller(
            @RequestParam("nickname") String nickname
            , @RequestParam("temperature") double temperature
            , @RequestParam("profileImage") String profileImage) {

        int count = sellerService.createSeller(nickname, temperature, profileImage);

        return "실행결과 : " + count;

    }

    @GetMapping("/form")
    public String sellerForm() {

        return "mvc/sellerForm";

    }

    @GetMapping("/info")
    public String sellerInfo(Model model) {

        Seller seller = sellerService.getLastSeller();
        model.addAttribute("seller", seller);

        return "mvc/sellerInfo";
    }
}
