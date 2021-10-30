package dorres.spring.board.dao;

import dorres.spring.board.vo.ArticleVO;

public class OracleArticleDAO implements ArticleDAO{
	@Override
	public void insert(ArticleVO article) {
		System.out.println("MyOracleArticleDAO.insert()실행");
	}
	@Override
	public void updateReadCount(int id) {
		System.out.println("MyOracleArticleDAO.updateReadCount()실행");
	}

}
