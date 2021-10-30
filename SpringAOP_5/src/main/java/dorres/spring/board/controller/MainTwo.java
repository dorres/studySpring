package dorres.spring.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dorres.spring.board.service.ReadArticleService;
import dorres.spring.board.vo.ArticleNotFoundException;
import dorres.spring.board.vo.ArticleVO;
import dorres.spring.member.service.MemberService;
import dorres.spring.member.vo.UpdateInfo;

public class MainTwo {
	public static void main(String[] args) {
		String[] configLocations = new String[] { "applicationContextTwo.xml" };
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		ReadArticleService readArticleService = context.getBean("readArticleService", ReadArticleService.class);
		try {
			ArticleVO article1 = readArticleService.getArticleAndIncreaseReadCount(1);
			ArticleVO article2 = readArticleService.getArticleAndIncreaseReadCount(1);
			System.out.println("article1 == article2 : " + (article1 == article2));
			readArticleService.getArticleAndIncreaseReadCount(0);
		} catch (ArticleNotFoundException e) {
		}
		MemberService memberService = context.getBean("memberService", MemberService.class);
		memberService.update("javaline", new UpdateInfo());
		context.close();
	}
}
