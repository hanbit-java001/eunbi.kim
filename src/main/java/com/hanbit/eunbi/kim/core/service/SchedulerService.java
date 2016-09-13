package com.hanbit.eunbi.kim.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hanbit.eunbi.kim.core.dao.ScheduleDAO;
import com.hanbit.eunbi.kim.core.vo.ScheduleVO;


public class SchedulerService {
	public int addSchedule(ScheduleVO schedule){
		ScheduleDAO scheduleDAO = new ScheduleDAO();

		return scheduleDAO.insertSchedule(schedule);
	}

	public int modifySchedule(ScheduleVO schedule){
		return 0;
	}

	public int removeSchedule(String scheduleID){
		return 0;
	}

	public List<ScheduleVO> listSchedules(String startDt, String endDt){
		return null;
	}

	public ScheduleVO getSchedule(String scheduleID){
		return null;
	}


}
