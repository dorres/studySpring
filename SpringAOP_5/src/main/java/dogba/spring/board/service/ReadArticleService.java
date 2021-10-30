package dogba.spring.board.service;

import dogba.spring.board.vo.ArticleNotFoundException;
import dogba.spring.board.vo.ArticleVO;

public interface ReadArticleService {
	ArticleVO getArticleAndIncreaseReadCount(int id)throws ArticleNotFoundException;
}
