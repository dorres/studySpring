package dorres.spring.board.service;

import dorres.spring.board.vo.ArticleNotFoundException;
import dorres.spring.board.vo.ArticleVO;

public class ReadArticleServiceImpl implements ReadArticleService{
	@Override
	public ArticleVO getArticleAndIncreaseReadCount(int id) throws ArticleNotFoundException {
		if (id == 0) throw new ArticleNotFoundException();
		return new ArticleVO();
	}

}
