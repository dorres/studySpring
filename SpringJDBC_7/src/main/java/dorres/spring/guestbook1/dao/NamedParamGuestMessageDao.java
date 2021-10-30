package dorres.spring.guestbook1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import dorres.spring.guestbook.vo.GuestMessage;
// GuestMessageDAO를 상속받아 실제적인 데이터베이스 처리를 담당할 구현 클래스 작
public class NamedParamGuestMessageDao  implements GuestMessageDao{
	private NamedParameterJdbcTemplate template;
	
	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public int count() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return template.queryForObject("select count(*) from GUESTBOOK", paramMap, Integer.class);
	}
	@Override
	public int delete(int id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		return template.update("delete from GUESTBOOK where MESSAGE_ID = ?",paramMap);
	}
	@Override
	public int insert(GuestMessage message) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(message);
		
		int insertedCount = template.update("insert into GUESTBOOK(MESSAGE_ID, GUEST_NAME, "
				+ "MESSAGE, REGISTRY_DATE) values (guest_seq.nextval, :guestName, :message, :registtyDate)",
				paramSource);
		
		if (insertedCount > 0) {
			int id = template.queryForObject("select count(*) from GUESTBOOK", Collections.<String, Object>emptyMap(), Integer.class);
			message.setId(id);
		}//만약 이름 기반의 파라미터를 갖지 않는 쿼리를 실행할 경우에는 아무 값도 갖지 않는 map 객체를 사용하면된다. ex) Collection.<String, Object>emptyMap()
		return insertedCount;
	}
	@Override
	public List<GuestMessage> select(int begin, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRowNum", begin);
		paramMap.put("count", end - begin + 1);
		
		return template.query("select * from (select ROWNUM rnum, MESSAGE_ID, GUEST_NAME, "
				+ "MESSAGE, REGISTRY_DATE from (select * from GUESTBOOK order by MESSAGE_ID desc)) "
				+ "where rnum >=startRowNum and rnum <=count",paramMap, new RowMapper<GuestMessage>() {
					@Override
					public GuestMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
						GuestMessage message = new GuestMessage();
						message.setId(rs.getInt("MESSAGE_ID"));
						message.setGuestName(rs.getString("GUEST_NAME"));
						message.setMessage(rs.getString("MESSAGE"));
						message.setRegistryDate(rs.getDate("REGISTRY_DATE"));
						return message;
					}
		});
	}
	
	@Override
	public int update(GuestMessage message) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("message", message.getMessage());
		paramSource.addValue("id", message.getId(), Types.INTEGER);
		
		return template.update("update GUESTBOOK set MESSAGE = :message"
				+ " where MESSAGE_ID = :id", paramSource);			
	}

}
