package dogba.spring.board.service;

import dogba.spring.board.vo.ArticleNotFoundException;
import dogba.spring.board.vo.ArticleVO;

public class ReadArticleServiceImpl implements ReadArticleService{
	@Override
	public ArticleVO getArticleAndIncreaseReadCount(int id) throws ArticleNotFoundException {
		if (id == 0) throw new ArticleNotFoundException();
		return new ArticleVO();
	}

}
