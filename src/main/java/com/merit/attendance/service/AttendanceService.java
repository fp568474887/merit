package com.merit.attendance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.merit.attendance.entity.Attendance;

import java.util.List;

/**
 * @Author: fanpeng
 * @DateTime: 2021-07-02 18:47
 * @Description: service
 */

public interface AttendanceService extends IService<Attendance> {

    List<Attendance> getByJobNumber(String jobNumber);
}
