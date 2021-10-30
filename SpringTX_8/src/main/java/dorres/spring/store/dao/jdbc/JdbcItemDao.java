package dorres.spring.store.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import dorres.spring.store.dao.ItemDao;
import dorres.spring.store.vo.Item;

// ItemDao 인터페이스를 구현한 JdbcItemDao 클래스
public class JdbcItemDao implements ItemDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcItemDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Item findById(Integer itemId) {
		return jdbcTemplate.queryForObject("select * from ITEM where ITEM_ID = ?",new ItemRowMapper(), new Object[] { itemId } );
	}

}
