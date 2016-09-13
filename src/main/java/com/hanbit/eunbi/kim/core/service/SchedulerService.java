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
	private ScheduleDAO scheduleDAO = new ScheduleDAO();

	public int addSchedule(ScheduleVO schedule) {
		return scheduleDAO.insertSchedule(schedule);
	}

	public int modifySchedule(ScheduleVO schedule) {
		return scheduleDAO.updateSchedule(schedule);
	}

	public int removeSchedule(String scheduleId) {
		return scheduleDAO.deleteSchedule(scheduleId);
	}

	public List<ScheduleVO> listSchedules(String startDt, String endDt){
		return scheduleDAO.selectSchedules(startDt, endDt);
	}

	public ScheduleVO getSchedule(String scheduleId) {
		return scheduleDAO.selectSchedule(scheduleId);
	}

}
