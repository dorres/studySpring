package dorres.spring.web.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dorres.spring.web.board.impl.BoardDAO;

//어노테이션을 이용하면 대부분의 Controller 클래스를 4~5줄 내외로 간단하게 구현할 수 있다. 
//간단하게 구현되는 Controller의 경우 하나의 클래스로 묶어서 처리하면 관리가 편리할 것이다. 
//단 무조건 통합을 추천하는 것은 아니고 기능의 이 같은 경우 또 통합처리를 하여도 복잡성이 증가하지 않는 경우에 통합을 추천한다.
@Controller
@SessionAttributes("board")
public class BoardController {
	//ModelAttribute가 설정된 메서드는 @RequestMapping 어노테이션이 적용된 메서드보다 먼저 호출된다. 
	//또한 @ModelAttribute 메서드 실행결과로 리턴된 객체는 자동으로 Model에 저장된다.
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
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
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 기능 처리");
		
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());

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
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 보기 처리");
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(
//			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, 
			BoardVO vo, BoardDAO boardDAO, Model model) {
//		만약 @RequestParam을 사용하기 싫다면 BoardVO 클래스에 searchCondition, searchKeyword 변수를 
//		추가하고 getter/setter 메서드만 추가하면 간단하게 처리할 수 있다
		System.out.println("글 목록 검색 처리");
//		System.out.println("검색 조건 : " + condition);
//		System.out.println("검색 단어 : " + keyword);
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		model.addAttribute("boardList", boardDAO.getBoardList(vo)); // Model 정보저장
		return "getBoardList.jsp";
	}
}
