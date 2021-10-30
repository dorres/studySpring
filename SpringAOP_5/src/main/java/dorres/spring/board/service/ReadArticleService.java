package dorres.spring.board.service;

import dorres.spring.board.vo.ArticleNotFoundException;
import dorres.spring.board.vo.ArticleVO;

public interface ReadArticleService {
	ArticleVO getArticleAndIncreaseReadCount(int id)throws ArticleNotFoundException;
}
