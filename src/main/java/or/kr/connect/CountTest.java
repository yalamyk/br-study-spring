package or.kr.connect;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountTest {
	private int count = 0;

	// 실행 순서 -> @@Before @test, @@Before @test
	@Before
	public void setUp(){
		System.out.print("setup before code : "+count++);
	}
	@Test
	public void testPlus() {
		System.out.print("testplus test code : "+count++);
	}
	@Test
	public void increase(){
		System.out.print("increase test code : "+count++);
	}

}
