package or.kr.connect.persistence;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource; //DriverManagerDataSource�� BasicDataSource�� ������ �������̽��̴�.

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	private NamedParameterJdbcTemplate jdbc;
	
	//DriverManagerDataSource
	public BookDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	//BookLauncher
	private static final String COUNT_BOOK = "SELECT COUNT(*) FROM book";
	public int countBooks(){
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(COUNT_BOOK, params, Integer.class);
	}
}
