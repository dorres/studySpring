package dorres.spring.guestbook.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dorres.spring.guestbook.dao.JdbcTemplateGuestMessageDao;
import dorres.spring.guestbook.vo.GuestMessage;

public class JdbcTemplateMain {
	private GuestMessage makeGuestMessage(String guestName, String message) {
		GuestMessage msg = new GuestMessage();
		msg.setGuestName(guestName);
		msg.setMessage(message);
		msg.setRegistryDate(new Date());
		return msg;
	}
	public static void main(String[] ar) {
		String[] configLocations = new String[] {"applicationContext.xml"};
		AbstractApplicationContext context = new GenericXmlApplicationContext(configLocations);
		
		JdbcTemplateGuestMessageDao dao =(JdbcTemplateGuestMessageDao) context.getBean("jdbcTemplateGuestMessageDao");
		
		JdbcTemplateMain myTest = new  JdbcTemplateMain();
		dao.insert(myTest.makeGuestMessage("도경석", "안녕하세요"));
		dao.insert(myTest.makeGuestMessage("도승준", "안녕"));
		dao.insert(myTest.makeGuestMessage("신효린", "안녕하십니까"));
		
		int count = dao.count();
		System.out.println("전체글수 : " +count);
		
		List<GuestMessage> lists = dao.select(1, count);
		for(GuestMessage msg : lists) {
			System.out.println(msg.getId() + " :" + msg.getGuestName() + " : " +
					msg.getMessage() + " : " + msg.getRegistryDate());
		}
		context.close();
		
		
		
	}
	
}
