package com.marondal.springtest.mybatis;

import com.marondal.springtest.mybatis.domain.RealEstate;
import com.marondal.springtest.mybatis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/mybatis/real-estate")
@Controller
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping("/select/1")
    public RealEstate realEstate(@RequestParam("id") int id) {

        // 전달받은 id와 일치하는 매물 정보 얻어오기
        RealEstate realEstate = realEstateService.getRealEstate(id);

        return realEstate;
    }

    @ResponseBody
    @RequestMapping("/select/2")
    public List<RealEstate> realEstateListByRentPrice(@RequestParam("rent") int rentPrice) {

        // 전달받은 월세보다 낮은 매물 리스트 얻어오기
        List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);

        return realEstateList;
    }

    @ResponseBody
    @RequestMapping("/select/3")
    public List<RealEstate> realEstateListByAreaAndPrice(
            @RequestParam("area") int area
            , @RequestParam("price") int price) {


        // 면적과 가격에 대한 조건에 대응 되는 매물 리스트 얻어 오기
        List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);

        return realEstateList;
    }

    @ResponseBody
    @RequestMapping("/add/1")
    public String addRealEstate() {
//        realtorId : 3
//        address : 푸르지용 리버 303동 1104호
//        area : 89
//        type : 매매
//        price : 100000

        RealEstate realEstate = new RealEstate();
        realEstate.setRealtorId(3);
        realEstate.setAddress("푸르지용 리버 303동 1104호");
        realEstate.setArea(89);
        realEstate.setType("매매");
        realEstate.setPrice(100000);

        int count = realEstateService.createRealEstateByObject(realEstate);

        return "실행 결과 : " + count;
    }

    @RequestMapping("/add/2")
    public addRealEstateByRealtorId(@RequestParam("realtorId") int realtorId) {

//        address : 썅떼빌리버 오피스텔 814호
//        area : 45
//        type : 월세
//        price : 100000
//        rentPrice : 120

    }

}
