package com.marondal.springtest.mybatis.service;

import com.marondal.springtest.mybatis.domain.RealEstate;
import com.marondal.springtest.mybatis.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {

    @Autowired
    private RealEstateRepository realEstateRepository;

    // 전달받은 id와 일치하는 매물 정보 얻어오기
    public RealEstate getRealEstate(int id) {

        // real_estate 테이블에 전달받은 id와 일치하는 행 조회
        RealEstate realEstate = realEstateRepository.selectRealEstate(id);

        return realEstate;
    }

    // 전달받은 월세보다 낮은 매물 리스트 얻어오기
    public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {

        // real_estate 테이블에서 전달받은 월세 보다 낮은 행 조회
        List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);

        return realEstateList;
    }

    // 면적과 가격에 대한 조건에 대응 되는 매물 리스트 얻어 오기 
    public List<RealEstate>  getRealEstateListByAreaAndPrice(int area, int price) {

        // real_estate 테이블에서 전달받은 면적과 가격에 대한 조건에 대응되는 행 조회
        List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);
        return realEstateList;
    }

    public int createRealEstateByObject(RealEstate realEstate) {

        // real_estate 테이블에 한 행을 저장
        int count = realEstateRepository.insertRealEstateByObject(realEstate);
        return count;
    }

    public createRealEstate(
            int realtorId
            , String address
            , int area
            , String type
            , int price
            , int rentPrice) {

    }
    
    
}
