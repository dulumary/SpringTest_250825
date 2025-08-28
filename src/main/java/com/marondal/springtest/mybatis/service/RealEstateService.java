package com.marondal.springtest.mybatis.service;

import com.marondal.springtest.mybatis.domain.RealEstate;
import com.marondal.springtest.mybatis.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public getRealEstateListByRentPrice(int rentPrice) {

        // real_estate 테이블에서 전달받은 월세 보다 낮은 행 조회
    }
}
