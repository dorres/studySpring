package dorres.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dorres.spring.web.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
//		Command ��ü�� �̸��� Ŭ�����̸��� ù ���ڸ� �ҹ��ڷ� ������ �̸��� �ڵ����� �����ȴ�. 
//		�� �̸��� �����ϰ��� �� �� @ModelAttribute�� ����� �� �ִ�.
//		login.jsp���� userVO.id�� user�� �ٲܼ��ִ�.
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("�α��� ���� ó��");
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}
