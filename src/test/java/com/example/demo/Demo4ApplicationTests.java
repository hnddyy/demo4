package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Coupon;
import com.example.demo.mapper.CouponMapper;

@SpringBootTest
class Demo4ApplicationTests {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private CouponMapper mapper;
	
	@Test
	public void testCouponMapper() {
		Coupon coupon = mapper.select("N", "N");
		System.out.println("coupon >>" + coupon);
		assertEquals("testcode1", coupon.getCouponCode());
		
		String giveYn = "Y";
		String exprieYn = "N";
		List<Coupon> coponList = mapper.selectList(giveYn, null, exprieYn);
		assertEquals(1, coponList.size());
	}
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println("DS=" + ds);
		
		try (Connection conn = ds.getConnection()){
			System.out.println("Coooooooonn=" + conn);
			assertThat(conn).isInstanceOf(Connection.class);
			
			assertEquals(100, getLong(conn, "select 100"));
			assertTrue(0 < getLong(conn, "select count(*) from USER"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private long getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getLong(1);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Test
	void contextLoads() {
	}

}
