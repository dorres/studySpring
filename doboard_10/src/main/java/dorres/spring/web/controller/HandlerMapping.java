package dorres.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import dorres.spring.web.board.DeleteBoardController;
import dorres.spring.web.board.GetBoardController;
import dorres.spring.web.board.GetBoardListController;
import dorres.spring.web.board.InsertBoardController;
import dorres.spring.web.board.UpdateBoardController;
import dorres.spring.web.user.LoginController;
import dorres.spring.web.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
		// 나중에 이 부분에 명령어(path)와 Controller 객체가 추가됨.
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}
}
