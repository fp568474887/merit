package com.merit.attendance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.merit.attendance.entity.Attendance;
import com.merit.attendance.mapper.AttendanceMapper;
import com.merit.attendance.service.AttendanceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: fanpeng
 * @DateTime: 2021-07-02 18:48
 * @Description: impl
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {

    //早上九点上班
    private static final Integer UP_WORK = 900;

    //中午吃饭时间
    private static final Integer DOWN_EAT = 1200;

    //中午上班时间
    private static final Integer UP_EAT = 1400;

    //晚上五点半下班
    private static final Integer DOWN_WORK = 1530;


    @Override
    public List<Attendance> getByJobNumber(String jobNumber) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(new Date());
        QueryWrapper<Attendance> wrapper = new QueryWrapper<Attendance>();
        wrapper.eq("JOB_NUMBER", jobNumber).eq("ATTENDANCE_DATE", nowDate);
        List<Attendance> list = this.list(wrapper);
        //今日未打卡
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        for (Attendance attendance : list) {
            Integer status = attendance.getStatus();
            int time = Integer.parseInt(attendance.getAttendanceTime().replaceAll(":", ""));
            switch (status) {
                case 1:
                    if (time <= UP_WORK) {
                        attendance.setType("上班");
                    } else {
                        attendance.setType("迟到");
                    }
                    break;
                case 2:
                    if (time < DOWN_EAT) {
                        attendance.setType("早退");
                    } else {
                        attendance.setType("下班");
                    }
                    break;
                case 3:
                    if (time <= UP_EAT) {
                        attendance.setType("上班");
                    } else {
                        attendance.setType("迟到");
                    }
                    break;
                case 4:
                    if (time < DOWN_WORK) {
                        attendance.setType("早退");
                    } else {
                        attendance.setType("下班");
                    }
                    break;
                default:

            }
        }
        return list;
    }
}
