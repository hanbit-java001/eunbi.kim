package com.hanbit.eunbi.kim.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.hanbit.eunbi.kim.core.service.SchedulerService;
import com.hanbit.eunbi.kim.core.vo.ScheduleVO;

public class SpringApplication {

	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");

			ApplicationContext applicationContext =
					new ClassPathXmlApplicationContext("spring/applicationContext-core.xml",
							"spring/applicationContext-dao.xml");

			SchedulerService schedulerService = applicationContext.getBean(SchedulerService.class);

			ScheduleVO schedule = new ScheduleVO();
			schedule.setScheduleId(String.valueOf(System.currentTimeMillis()));
			schedule.setTitle("안뇽");
			schedule.setMemo("집에가고싶다");
			schedule.setStartDt("201609151830");
			schedule.setEndDt("201609201930");

			int result = schedulerService.addSchedule(schedule);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
