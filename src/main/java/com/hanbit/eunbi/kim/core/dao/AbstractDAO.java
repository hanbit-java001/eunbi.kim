package com.hanbit.eunbi.kim.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {
	// abstract 클래스는 abstract 메소드를 가질 수 있다
	// abstract 메소드는 구현하지 않은 메소드

	@Autowired
	private DataSource dataSource;

	protected Connection getConnection() {

		Connection connection = null;

		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {

		}

		return connection;
	}

	protected void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected int executeSql(Connection connection, String sql, List params) {
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

}