package dorres.spring.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dorres.spring.board.service.WriteArticleService;
import dorres.spring.board.vo.ArticleVO;
import dorres.spring.member.service.MemberService;
import dorres.spring.member.vo.MemberVO;

public class MainOne {
	public static void main(String[] ar) {
		String[] configLocations = new String[] {"applicationContextOne.xml"};
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		
		WriteArticleService articleService = (WriteArticleService) context.getBean("writeArticleService");
		articleService.write(new ArticleVO());
		
		MemberService memberService = context.getBean("memberService", MemberService.class);
		memberService.regist(new MemberVO());
		
		context.close();
	}
}
