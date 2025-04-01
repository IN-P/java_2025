package spring005_ex_board;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")
public class Test1_Board {
	@Autowired BoardDao dao;
	
	@Ignore public void insert() throws UnknownHostException {
		BoardDto dto = new BoardDto();
		dto.setBname("second");
		dto.setBpass("22");
		dto.setBtitle("titletitle");
		dto.setBcontent("texttext");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		System.out.println(dao.insert(dto));
	}
	
	@Test public void selectAll() {
		System.out.println(dao.selectAll());
	}
	
	@Ignore public void update() {
		BoardDto dto = new BoardDto();
		dto.setBtitle("twotwo");
		dto.setBcontent("text22");
		dto.setBno(2);
		System.out.println(dao.update(dto));
		System.out.println(dao.selectOne(dto.getBno()));
	}
	
}
