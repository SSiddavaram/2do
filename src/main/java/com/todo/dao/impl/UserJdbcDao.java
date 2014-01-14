package com.todo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;
import com.todo.dao.UserDao;
import com.todo.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserJdbcDao implements UserDao{
	
	private JdbcTemplate jdbcTemplate;
	 
	private static String USER_PROFILE_SQL = "select user_id, username, user_display_name from user_table where username = ? and password = ?";
	private static String CREATE_USER_PROFILE_SQL = "insert into user_table values (?,?,?,?,?)";
	private static String GET_USER_ID = "select user_id from user_table";
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public User getUser(String username, String password) {
		List<User> list = jdbcTemplate.query(USER_PROFILE_SQL, new Object[]{username,password}, new UserObjectMapper());
		return (list.isEmpty()) ? null : list.get(0);
	}
	
	@Override
	public User createUser(String username, String password, Date date, String name) {
		List<Integer> userIdList = jdbcTemplate.query(GET_USER_ID, new UserIdListMapper());
		Integer userId;
		while(true){
			Random ran = new Random();
			userId = ran.nextInt();
			if(!userIdList.contains(userId)){
				break;
			}
		}
		
		jdbcTemplate.update(CREATE_USER_PROFILE_SQL, new Object[]{userId,username,password,date,name});
		User userObj = getUser(username, password);
		return userObj;
	}
	
	private static final class UserObjectMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User userObj = new User();
			userObj.setUser_id(rs.getInt("user_id"));
			userObj.setUsername(rs.getString("username"));
			userObj.setUser_display_name(rs.getString("user_display_name"));
			return userObj;
		}
	}
	
	private static final class UserIdListMapper implements RowMapper<Integer>{

		@Override
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer userId;
			userId = rs.getInt("user_id");
			return userId;
		}
		
	}

}
