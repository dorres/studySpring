package dorres.spring.store.dao.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import dorres.spring.store.dao.PurchaseOrderDao;
import dorres.spring.store.vo.PurchaseOrder;

public class JdbcPurchaseOrderDao implements PurchaseOrderDao {
	private SimpleJdbcInsert simpleinsert;
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public JdbcPurchaseOrderDao(SimpleJdbcInsert simpleinsert) {
		this.simpleinsert = simpleinsert;
		simpleinsert.withTableName("PURCHASE_ORDER").usingColumns("PURCHASE_ORDER_ID", "ITEM_ID", "PAYMENT_INFO_ID", "ADDRESS");
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	public int nextVal() {
		Map<String, Object> emptyMap = new HashMap<String, Object>();
		return namedJdbcTemplate.queryForObject("select purchase_seq.nextval from dual", emptyMap, Integer.class);
	}

	@Override
	public void insert(PurchaseOrder order) {
		Map<String, Object> args = new HashMap<String, Object>();
		order.setId(nextVal());
		args.put("PURCHASE_ORDER_ID", order.getId());
		args.put("ITEM_ID", order.getItemId());
		args.put("PAYMENT_INFO_ID", order.getPaymentInfoId());
		args.put("ADDRESS", order.getAddress());
		simpleinsert.execute(args);
	}
}
