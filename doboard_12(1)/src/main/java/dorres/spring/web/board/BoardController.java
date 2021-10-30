package dorres.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dorres.spring.web.board.impl.BoardDAO;

//어노테이션을 이용하면 대부분의 Controller 클래스를 4~5줄 내외로 간단하게 구현할 수 있다. 
//간단하게 구현되는 Controller의 경우 하나의 클래스로 묶어서 처리하면 관리가 편리할 것이다. 
//단 무조건 통합을 추천하는 것은 아니고 기능의 이 같은 경우 또 통합처리를 하여도 복잡성이 증가하지 않는 경우에 통합을 추천한다.
@Controller
public class BoardController {
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		//DAO 객체 역시 Command 객체와 마찬가지로 매개변수로 선언하면 스프링 컨테이너가 해당 객체를 생성하여 전달해 준다
		//Controller 메서드가 실행되고 View 경로를 리턴하면 기본적으로 포워딩 방식으로 처리한다. 
		//만약 리다이렉트 방식을 원할 때는 "redirect:"라는 접두어를 붙여야 한다.
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 기능 처리");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 보기 처리");
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보저장
		mav.setViewName("getBoardList.jsp"); // View 정보저장
		return mav;
	}
}
