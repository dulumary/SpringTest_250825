package com.marondal.springtest.database;

import com.marondal.springtest.database.domain.Store;
import com.marondal.springtest.database.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/db/store/list")
    @ResponseBody
    public List<Store> storeList() {

        // 가게 정보 리스트 얻어오기
        List<Store> storeList = storeService.getStoreList();

        return storeList;
    }
}
