package dogba.spring.board.dao;

import dogba.spring.board.vo.ArticleVO;

public interface ArticleDAO {
	void insert(ArticleVO article);
	void updateReadCount(int id);
}
