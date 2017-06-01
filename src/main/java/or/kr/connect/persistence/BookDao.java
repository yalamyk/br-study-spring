package or.kr.connect.persistence;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource; //DriverManagerDataSource�� BasicDataSource�� ������ �������̽��̴�.

import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import javax.swing.tree.RowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.domain.Book;

@Repository
public class BookDao {
	private NamedParameterJdbcTemplate jdbc;
	public SimpleJdbcInsert insertAction;
	
	//DriverManagerDataSource
	public BookDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("book")
				.usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(Book book){
		SqlParameterSource params = new BeanPropertySqlParameterSource(book);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	
	//BookLauncher
	private static final String COUNT_BOOK = "SELECT COUNT(*) FROM book";
	public int countBooks(){
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(COUNT_BOOK, params, Integer.class);
	}
	
	//book 테이블을 id로 조회하는 쿼리
	private static final String SELECT_BY_ID=
			"SELECT id, title, author, pages FROM book where id = :id;";
	
//	public Book selectById(Integer id){
//		RowMapper<Book> rowMapper = (rs,i)->{
//			Book book = new Book();
//			book.setId(rs.getInt("id"));
//			book.setTitle(rs.getString("title"));
//			book.setAuthor(rs.getString("author"));
//			book.setPages((Integer) rs.getObject("pages"));
//			return book;
//		};
//		
//		Map<String,Object> params = new HashMap<>();
//		params.put("id", id);
//		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
//	}
	private RowMapper<Book> rowMapper = BeanPropertyRowMapper.newInstance(Book.class);
	
	public Book selectById(Integer id){
		//RowMapper<Book> rowMapper = BeanPropertyRowMapper.newInstance(Book.class);
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
	}
	
	
	//위의 람다 표현식은 익명클래스로 표현한다면 아래와 같다.
//	RowMapper<Book> rowMapper = new RowMapper<Book>() {
//		@Override
//		public Book mapRow(ResultSet rs, int i) throws SQLException {
//			book.setId(rs.getInt("id"));
//			book.setTitle(rs.getString("title"));
//			book.setAuthor(rs.getString("author"));
//			book.setPages((Integer) rs.getObject("pages"));
//			return book;
//		}
//	};
}

