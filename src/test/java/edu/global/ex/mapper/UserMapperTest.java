package edu.global.ex.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.global.ex.vo.UserVO;

@SpringBootTest
class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;

	@Disabled
	@Test
	void testGetUser() {
		
		UserVO user = userMapper.getUser("user");
		
		System.out.println(user);
		
		UserVO admin = userMapper.getUser("admin");
		
		System.out.println(admin);
		
	}
	
	@Disabled
	@Test
	void testInsertUser() {
		
		UserVO user = new UserVO();
		user.setUsername("john");
		user.setPassword("john");
		user.setEnabled(1);
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
	}
	
	@Disabled
	@Test //암호화 했을 때
	void testInsertUser2() {
		
		UserVO user = new UserVO();
		user.setUsername("john2");
		user.setPassword(new BCryptPasswordEncoder().encode("john2"));
		user.setEnabled(1);
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
	}
	
	@Test //암호화 했을 때
	void testCheckUser2() {
		
		UserVO user = userMapper.getUser("john2");

		System.out.println(user);
		
		boolean isPass = new BCryptPasswordEncoder().matches("john2", user.getPassword());
		
		System.out.println(isPass);
	}
}
