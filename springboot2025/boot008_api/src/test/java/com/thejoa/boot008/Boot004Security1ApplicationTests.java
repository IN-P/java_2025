package com.thejoa.boot008;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot008.util7_iddouble.MyUser;
import com.thejoa.boot008.util7_iddouble.MyUserService;

@SpringBootTest
class Boot004Security1ApplicationTests {

	   @Autowired MyUserService myUserService;
	   
	   @Test
	   void userInsert() {
	      MyUser user = new MyUser();
	      user.setUsername("first");
	      user.setEmail("first@gmail.com");
	      System.out.println(myUserService.insertUser(user));
	   }
}
