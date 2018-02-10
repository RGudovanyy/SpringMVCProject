package net.anviprojects.SpringMVCProject.mvc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class JDBCExample {

	@Autowired
	DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init(){
		System.out.println(String.format("JDBCExample postConstruct is called. datasource=%s", dataSource.toString()));
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean insertLog(DBLog log){
		System.out.println("JDBCExample: log(final String log) is called");
	}

}
