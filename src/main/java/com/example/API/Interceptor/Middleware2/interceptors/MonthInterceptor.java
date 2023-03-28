package com.example.API.Interceptor.Middleware2.interceptors;

import com.example.API.Interceptor.Middleware2.entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    List<Month> months;
     public MonthInterceptor() {
         months = new ArrayList<>();
         months.add(new Month(1, "January", "Gennaio", "Januar"));
         months.add(new Month(2, "February", "Febbraio", "Februar"));
         months.add(new Month(3, "March", "Marzo", "März"));
         months.add(new Month(4, "April", "Aprile", "April"));
         months.add(new Month(5, "May", "Maggio", "Mai"));
         months.add(new Month(6, "June", "Giugno", "Juni"));
     }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

         String monthNumber = request.getHeader("monthNumber");
         if(monthNumber == null){
             response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Month number is required");
             return false;
         }
        Optional<Month> month = months.stream()
                .filter(m -> m.getMonthNumber() == Integer.parseInt(monthNumber))
                .findFirst();
         if(month.isPresent()){
             request.setAttribute("month", month.get());
         }else{
             Month emptyMonth = new Month();
             emptyMonth.setEnglishName("nope");
             emptyMonth.setItalianName("nope");
             emptyMonth.setGermanName("nope");
             request.setAttribute("month", emptyMonth);
         }
         return true;
     }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
