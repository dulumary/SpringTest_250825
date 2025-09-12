package com.marondal.springtest.ajax;

import com.marondal.springtest.ajax.domain.Booking;
import com.marondal.springtest.ajax.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/main")
    public String main() {
        return "ajax/booking/main";
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<Booking> bookingList = bookingService.getBookingList();

        model.addAttribute("bookingList", bookingList);

        return "ajax/booking/list";
    }

    @GetMapping("/form")
    public String form() {
        return "ajax/booking/form";
    }

    // 예약 삭제 API
    @ResponseBody
    @GetMapping("/remove")
    public Map<String, String> removeBooking(@RequestParam("id") int id) {

        int count = bookingService.deleteBooking(id);

        // 성공 : {"result":"success"}
        // 실패 : {"result":"fail"}
        Map<String, String> resultMap = new HashMap<>();
        if(count == 1) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;

    }

    // 예약 추가 API
    @ResponseBody
    @GetMapping("/add")
    public Map<String, String> addBooking(
            @RequestParam("name") String name
            , @RequestParam("headcount") int headcount
            , @RequestParam("day") int day
            , @DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date  // 2025년 9월 12일
            , @RequestParam("phoneNumber") String phoneNumber) {


        int count = bookingService.createBooking(name, headcount, day, date, phoneNumber);

        // 성공 : {"result":"success"}
        // 실패 :  {"result":"fail"}
        Map<String, String> resultMap = new HashMap<>();
        if(count == 1) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }



}
