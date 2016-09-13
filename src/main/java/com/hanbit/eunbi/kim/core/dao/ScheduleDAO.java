package com.hanbit.eunbi.kim.core.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.eunbi.kim.core.vo.ScheduleVO;

public class ScheduleDAO {
	private Connection getConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1/xe";
		String user = "hanbit";
		String password = "hanbit";

		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {

		}

		return connection;
	}

	private void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int executeSql(Connection connection, String sql, List params) {
		int result = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			for (int i = 0; i < params.size(); i++) {
				statement.setObject(i + 1, params.get(i));
			}

			result = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int insertSchedule(ScheduleVO schedule) {
		Connection connection = getConnection();

		String sql = "INSERT INTO SCHEDULE (SCHEDULE_ID,TITLE,MEMO,START_DT,END_DT)" + "VALUES(?,?,?,?,?)";

		List params = new ArrayList();
		params.add(schedule.getScheduleId());
		params.add(schedule.getTitle());
		params.add(schedule.getMemo());
		params.add(schedule.getStartDt());
		params.add(schedule.getEndDt());

		int result = executeSql(connection, sql, params);

		closeConnection(connection);

		return result;
	}

	public int updateSchedule(ScheduleVO schedule) {
		Connection connection = getConnection();

		String sql = "UPDATE SCHEDULE SET TITLE = ?, MEMO = ?, START_DT = ?, END_DT = ? WHERE SCHEDULE_ID = ?";

		List params = new ArrayList();
		params.add(schedule.getTitle());
		params.add(schedule.getMemo());
		params.add(schedule.getStartDt());
		params.add(schedule.getEndDt());
		params.add(schedule.getScheduleId());
		int result = executeSql(connection, sql, params);

		closeConnection(connection);

		return result;
	}

	public int deleteSchedule(String scheduleId) {
		Connection connection = getConnection();

		String sql = "DELETE FROM SCHEDULE WHERE SCHEDULE_ID = ?";

		List params = new ArrayList();
		params.add(scheduleId);

		int result = executeSql(connection, sql, params);

		closeConnection(connection);

		return result;
	}

	public List<ScheduleVO> selectSchedules(String startDt, String endDt) {
		Connection connection = getConnection();

		String sql = "SELECT SHCEDULE_ID, TITLE, MEMO, START_DT, END_DT FROM SCHEDULE "
				+ "WHERE START_DT <= ? AND END_DT >= ?";

		List params = new ArrayList();
		params.add(endDt);
		params.add(startDt);

		List<ScheduleVO> result = new ArrayList<ScheduleVO>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			for (int i = 0; i < params.size(); i++) {
				statement.setObject(i + 1, params.get(i));
			}

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				ScheduleVO schedule = new ScheduleVO();

				schedule.setScheduleId(resultSet.getString("SCHEDULE_ID"));
				schedule.setTitle(resultSet.getString("TITLE"));
				schedule.setMemo(resultSet.getString("MEMO"));
				schedule.setStartDt(resultSet.getString("START_DT"));
				schedule.setEndDt(resultSet.getString("END_DT"));

				result.add(schedule);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		closeConnection(connection);

		return result;
	}

	public ScheduleVO selectSchedule(String scheduleId) {
		return null;
	}

}