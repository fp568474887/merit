package com.merit.attendance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.merit.attendance.entity.Attendance;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: fanpeng
 * @DateTime: 2021-07-02 18:46
 * @Description: dao
 */

@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {
}
