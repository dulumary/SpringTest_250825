package com.marondal.springtest.ajax;

import com.marondal.springtest.ajax.domain.Favorite;
import com.marondal.springtest.ajax.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/form")
    public String favoriteForm() {
        return "ajax/favorite/form";
    }

    @GetMapping("/list")
    public String favoriteList(Model model) {

        // 즐겨찾기 목록 얻어오기
        List<Favorite> favoriteList = favoriteService.getFavoriteList();

        model.addAttribute("favoriteList", favoriteList);

        return "ajax/favorite/list";
    }


    // 즐겨찾기 추가 API
    @ResponseBody
    @PostMapping("/add")
    public Map<String, String> addFavorite(
            @RequestParam("name") String name
            , @RequestParam("url") String url) {

        int count = favoriteService.createFavorite(name, url);

        Map<String, String> resultMap = new HashMap<>();
        // 성공 : {"result":"success"}
        // 실패 : {"result":"fail"}
        if(count == 1) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }
        
        return resultMap;
    }

    // url 중복 여부 확인 API
    @ResponseBody
    @PostMapping("/duplicate-url")
    public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {

        Map<String, Boolean> resultMap = new HashMap<>();
        // 중복 됨   {"isDuplicate":true}
        // 중복 안됨 {"isDuplicate":false}
        resultMap.put("isDuplicate", favoriteService.isDuplicateUrl(url));

        return resultMap;
    }

}
