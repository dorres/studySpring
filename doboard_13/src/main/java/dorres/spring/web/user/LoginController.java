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
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
//		Command 객체의 이름은 클래스이름의 첫 글자를 소문자로 변경한 이름이 자동으로 설정된다. 
//		이 이름을 변경하고자 할 때 @ModelAttribute를 사용할 수 있다.
//		login.jsp에서 userVO.id를 user로 바꿀수있다.
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 인증 처리");
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalAccessError("아이디는 반드시 입력해야 합니다.");
		}
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}
