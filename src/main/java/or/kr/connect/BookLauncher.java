package or.kr.connect;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.domain.Book;
import or.kr.connect.persistence.BookDao;

public class BookLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// BookLaunch에서 AppConfig 활용하여 삭제
//		//DriaverManager를 BasicDataSource로 교체
//		BasicDataSource dataSource = new BasicDataSource();
//		////DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//DataSource dataSource = context.getBean(DataSource.class);
		// --> DataSource dataSource = new AppConfig().dataSource();
		
		
// BookDao를 생성하고 호출하여 삭제 수정
//        NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource);
//        String sql = "SELECT COUNT(*) FROM book";
//        Map<String, Object> params = Collections.emptyMap();
//        Integer count = jdbc.queryForObject(sql, params, Integer.class);
       // BookDao dao = new BookDao(dataSource);
       
		
		//BookLauncher에서 BookDao를 직접 ApplicationContext에서 얻어온다.
		BookDao dao = context.getBean(BookDao.class);
		
		int count = dao.countBooks();
        System.out.print(count); //return 1
        
        
        Book book = dao.selectById(1);
        System.out.println(book);
        context.close();
	}
	

}
