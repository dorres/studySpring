package dorres.spring.store.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dorres.spring.store.vo.Item;

public class ItemRowMapper implements RowMapper<Item>{
	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setId(rs.getInt("ITEM_ID"));
		item.setPrice(rs.getInt("PRICE"));
		System.out.println(rs.getInt("PRICE"));
		return item;	
	}

}
