package dorres.spring.board.dao;

import dorres.spring.board.vo.ArticleVO;

public interface ArticleDAO {
	void insert(ArticleVO article);
	void updateReadCount(int id);
}
