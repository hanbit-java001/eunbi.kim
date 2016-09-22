package com.hanbit.eunbi.kim.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.hanbit.eunbi.kim.core.dao.MybatisExampleDAO;
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
			schedule.setTitle("저녁식사");
			schedule.setMemo("반찬 뭘까");
			schedule.setStartDt("201609191830");
			schedule.setEndDt("201609191930");

			int result = schedulerService.addSchedule(schedule);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
