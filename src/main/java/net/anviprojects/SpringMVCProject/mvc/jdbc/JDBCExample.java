package net.anviprojects.SpringMVCProject.mvc.jdbc;

import net.anviprojects.SpringMVCProject.mvc.bean.DBLog;
import net.anviprojects.SpringMVCProject.mvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

    /*
        @Repository- аннотация показывает, что класс функционирует как репозиторий и требует прозрачной трансляции исключений
        @PostConstruct - аннотация для метода, который будет вызван после конструктора бина
        @Autowired - аннотация позволяет автоматически получить значение поля
     */

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

	//JDBC Templete INSERT example
	public boolean insertLog(DBLog log){
		System.out.println("JDBCExample: log(final String log) is called");
		final String INSERT_SQL = "INSERT INTO LOG (LOGSTRING) VALUES (?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
                preparedStatement.setString(1,log.getLOGSTRING());
                return preparedStatement;
            }
        });
		return true;
	}

	// JDBC Template SELECT example
    public List<DBLog> queryAllLogs(){
        System.out.println("JDBCExample: queryAllLogs() is called");
        final String SELECT_QUERY = "SELECT * FROM LOG ORDER BY IDLOG";
        List<DBLog> dbLogList = this.jdbcTemplate.query(SELECT_QUERY, new RowMapper<DBLog>() {
            @Override
            public DBLog mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                System.out.println("Getting log: " + rowNum + " content: " + resultSet.getString("LOGSTRING"));
                DBLog dbLog = new DBLog();
                dbLog.setIDLOG(resultSet.getInt("IDLOG"));
                dbLog.setLOGSTRING(resultSet.getString("LOGSTRING"));
                return dbLog;
            }
        });
        return dbLogList;
    }


    public List<User> queryAllUsers(){
        System.out.println("JDBCExample: queryAllUsers() is called");
        final String SELECT_QUERY = "SELECT * FROM USER ORDER BY IDUSER";
        List<User> userList = this.jdbcTemplate.query(SELECT_QUERY, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setIdUser(resultSet.getInt("IDUSER"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setEnabled(resultSet.getBoolean("ENABLED"));
                return user;
            }
        });
        return userList;
    }

    // JDBC Template DELETE example
    public boolean deleteUser(int iduser){
        System.out.println("JDBCExample: deleteUser() is called");
        final String DELETE_QUERY = "DELETE FROM USER WHERE IDUSER LIKE ?";
        int result = jdbcTemplate.update(DELETE_QUERY, new Object[]{iduser});
        System.out.println("r" + result);
        if (result > 0){
            System.out.println("User is deleted");
            return true;
        } else {
            return false;
        }
    }

    // JDBC Template UPDATE example
    public boolean updateUserEnable(User u, boolean enable){
        System.out.println("JDBCExample: updateUserEnable() is called");
        final String UPDATE_QUERY = "UPDATE USER SET ENABLED=? WHERE USERNAME=?";
        int result = jdbcTemplate.update(UPDATE_QUERY, new Object[]{enable, u.getUsername()});
        System.out.println("r" + result);
        if (result > 0){
            System.out.println("User is updated");
            return true;
        } else {
            return false;
        }
    }
}
