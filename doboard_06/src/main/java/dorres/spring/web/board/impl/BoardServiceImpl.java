package dorres.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dorres.spring.web.board.BoardService;
import dorres.spring.web.board.BoardVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOSpring boardDAO;
	public BoardServiceImpl() {}

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo); // 1000번 글 등록 성공
//		boardDAO.insertBoard(vo); // Exception 발생
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {

		return boardDAO.getBoardList(vo);
	}

}
