package dorres.spring.board.service;

import dorres.spring.board.dao.ArticleDAO;
import dorres.spring.board.vo.ArticleVO;

public class WriteArticleServiceImpl implements WriteArticleService{
	private ArticleDAO articleDao;
	
	public WriteArticleServiceImpl() {
	}
	
	public WriteArticleServiceImpl(ArticleDAO articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	public void write(ArticleVO article) {
		System.out.println("WriteArticleServiceImpl.write() 메서드 실행");
		articleDao.insert(article);
	}

}
