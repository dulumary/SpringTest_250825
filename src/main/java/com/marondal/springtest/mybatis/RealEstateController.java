package com.marondal.springtest.mybatis;

import com.marondal.springtest.mybatis.domain.RealEstate;
import com.marondal.springtest.mybatis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mybatis/real-estate/select")
@Controller
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping("/1")
    public RealEstate realEstate(@RequestParam("id") int id) {

        // 전달받은 id와 일치하는 매물 정보 얻어오기
        RealEstate realEstate = realEstateService.getRealEstate(id);

        return realEstate;
    }

    @RequestMapping("/2")
    public realEstateListByRentPrice(@RequestParam("rent") int rentPrice) {

        // 전달받은 월세보다 낮은 매물 리스트 얻어오기
    }

}
