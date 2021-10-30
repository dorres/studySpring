package dorres.spring.guestbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import dorres.spring.guestbook.vo.GuestMessage;

//목록 조회 시 사용할 RowMapper
public class GuestMessageRowMapper  implements RowMapper<GuestMessage>{
	@Override
	public GuestMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
		GuestMessage message = new GuestMessage();
		message.setId(rs.getInt("MESSAGE_ID"));
		message.setGuestName(rs.getString("GUEST_NAME"));
		message.setMessage(rs.getString("MESSAGE"));
		message.setRegistryDate(rs.getDate("REGISTRY_DATE"));
		return message;
	}

}
