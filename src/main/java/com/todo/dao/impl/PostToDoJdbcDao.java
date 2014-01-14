package com.todo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.todo.dao.PostToDoDao;
import com.todo.dto.Post;

@Repository
public class PostToDoJdbcDao implements PostToDoDao {

	private JdbcTemplate jdbcTemplate;
	
	private static String POST_TO_DO_SQL = "insert into post_to_do (post_title,post_desc,date_created,post_due_date) values (?,?,?,?)";
	private static String GET_ALL_POSTS_SQL = "select * from post_to_do p, user_post_info u where p.post_id = u.post_id and u.user_id = ?";
	private static String GET_POST_ID_SQL = "select post_id from post_to_do where post_title = ?";
	private static String INSERT_USER_POST_INFO_SQL = "insert into user_post_info values (?,?)";
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createPost(String post_title,
			String post_desc, Date date_created, Date post_due_date, Integer user_id) throws ParseException {

		jdbcTemplate.update(POST_TO_DO_SQL, new Object[]{post_title,post_desc,date_created,post_due_date});
		/*SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date date = (Date)formatter.parse(date_created.toString());
		formatter.applyPattern("YYYY-MM-DD");
		Date createdDate = formatter.parse(formatter.format(date));*/
		
		Integer post_id = jdbcTemplate.queryForObject(GET_POST_ID_SQL,  new Object[]{post_title},Integer.class);
		jdbcTemplate.update(INSERT_USER_POST_INFO_SQL, new Object[]{user_id,post_id});
	}

	@Override
	public List<Post> getAllPosts(Integer user_id) {
		
		List<Post> todoPosts = jdbcTemplate.query(GET_ALL_POSTS_SQL, new Object[]{user_id}, new TodoPostMapper());
		return (todoPosts.isEmpty()) ? null : todoPosts;
	}
	
	private static final class TodoPostMapper implements RowMapper<Post>{

		@Override
		public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Post todoPost = new Post();
			todoPost.setPost_id(rs.getInt("post_id"));
			todoPost.setPost_title(rs.getString("post_title"));
			todoPost.setPost_desc(rs.getString("post_desc"));
			todoPost.setDate_created(rs.getDate("date_created"));
			todoPost.setPost_due_date(rs.getDate("post_due_date"));
			return todoPost;
		}
		
	}

}
