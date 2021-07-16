package com.merit.attendance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.merit.attendance.entity.Attendance;
import com.merit.attendance.service.AttendanceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Author: fanpeng
 * @DateTime: 2021-07-02 18:00
 * @Description: 首页
 */
@Controller
@RequestMapping("/attendance")
public class IndexController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping(value = "/index")
    public ModelAndView test(@Param("jobNumber") String jobNumber) {
        ModelAndView mv = new ModelAndView();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        mv.addObject("nowDate", sdf.format(new Date()));
        mv.addObject("jobNumber", jobNumber);
        mv.setViewName("/attendance");
        return mv;
    }

    @GetMapping(value = "/getAttendance")
    @ResponseBody
    public List<Attendance> getAttendance(@Param("jobNumber") String jobNumber) {
        return attendanceService.getByJobNumber(jobNumber);
    }
}
