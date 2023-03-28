package com.example.API.Interceptor.Middleware2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("/months")
public class MonthController {

    /*
    Date date = // the date instance
    Calendar calendar = Calendar.getInstance();
    calendar.get(Calendar.MONTH);

     */


    LocalDate localDate;

    @GetMapping("")
    public int getMonth(){
        return localDate.now().getMonthValue();
    }


}
