package com.marondal.springtest.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/lifecycle/test01")
@Controller
public class Test01Controller {

    @ResponseBody
    @RequestMapping("/1")
    public String htmlResponse() {

        return "" +
                "<html>\n" +
                "   <head><title>테스트 프로젝트</title></head>\n" +
                "   <body>\n" +
                "       <h2>테스트 프로젝트 완성</h2>\n" +
                "       <h4>해당 프로젝트를 통해 문제 풀이를 진행합니다.</h4>\n" +
                "   </body>\n" +
                "</html>";
    }

    @ResponseBody
    @RequestMapping("/2")
    public Map<String, Integer> mapResponse() {

        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("국어", 90);
        scoreMap.put("수학", 95);
        scoreMap.put("영어", 100);

        return scoreMap;
    }

}
