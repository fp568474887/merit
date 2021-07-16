package com.merit.attendance.controller;

import com.merit.attendance.service.AttendanceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * @Author: fanpeng
 * @DateTime: 2021-07-02 18:00
 * @Description: 首页
 */
@Controller
@RequestMapping("/job")
public class DemoController {


    @GetMapping(value = "/add")
    public ModelAndView test(@Param("jobNumber") String jobNumber) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/demo");
        return mv;
    }
}
