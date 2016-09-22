package com.hanbit.eunbi.kim.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.eunbi.kim.core.service.SchedulerService;
import com.hanbit.eunbi.kim.core.vo.ScheduleVO;

@Controller
public class ScheduleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private SchedulerService schedulerService;

	@RequestMapping("/schedule/list")
	public String list() {

		return "schedule/list";
	}

	@RequestMapping("/api/schedule/list")
	@ResponseBody
	public List<ScheduleVO> listSchedules(@RequestParam("startDt") String startDt,
			@RequestParam("endDt") String endDt) {

		List<ScheduleVO> result = schedulerService.listSchedules(startDt, endDt);

		return result;
	}

	@RequestMapping("/api/schedule/add")
	@ResponseBody
	public ScheduleVO addSchedule(@RequestBody ScheduleVO schedule) {

		LOGGER.debug(schedule.getTitle());

		return schedule;
	}

}