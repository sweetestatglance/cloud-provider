package com.cnct.comsys;

import com.cnct.entity.StaticValue;
import com.cnct.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComsysApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("账号 :" + MD5Util.MD5("admin" + StaticValue.USER));
		System.out.println("密码 :" + MD5Util.MD5("123456" + StaticValue.PASSWORD));
	}

}
