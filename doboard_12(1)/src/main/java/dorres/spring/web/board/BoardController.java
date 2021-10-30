package dorres.spring.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dorres.spring.web.board.impl.BoardDAO;

//������̼��� �̿��ϸ� ��κ��� Controller Ŭ������ 4~5�� ���ܷ� �����ϰ� ������ �� �ִ�. 
//�����ϰ� �����Ǵ� Controller�� ��� �ϳ��� Ŭ������ ��� ó���ϸ� ������ ���� ���̴�. 
//�� ������ ������ ��õ�ϴ� ���� �ƴϰ� ����� �� ���� ��� �� ����ó���� �Ͽ��� ���⼺�� �������� �ʴ� ��쿡 ������ ��õ�Ѵ�.
@Controller
public class BoardController {
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		//DAO ��ü ���� Command ��ü�� ���������� �Ű������� �����ϸ� ������ �����̳ʰ� �ش� ��ü�� �����Ͽ� ������ �ش�
		//Controller �޼��尡 ����ǰ� View ��θ� �����ϸ� �⺻������ ������ ������� ó���Ѵ�. 
		//���� �����̷�Ʈ ����� ���� ���� "redirect:"��� ���ξ �ٿ��� �Ѵ�.
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ��� ó��");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� �� ���� ó��");
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ��� �˻� ó��");
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ��������
		mav.setViewName("getBoardList.jsp"); // View ��������
		return mav;
	}
}
