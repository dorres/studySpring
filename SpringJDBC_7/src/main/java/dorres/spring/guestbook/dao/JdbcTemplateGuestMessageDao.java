package dorres.spring.guestbook.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import dorres.spring.guestbook.vo.GuestMessage;
// GuestMessageDAO를 상속받아 실제적인 데이터베이스 처리를 담당할 구현 클래스 작
public class JdbcTemplateGuestMessageDao  implements GuestMessageDao{
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplateGuestMessageDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int count() {
		// 쿼리 실행 결과 행의 개수가 한 개인 경우에는 
		//queryForObject() 메서드를 이용해서 실행결과를 가져올 수 있다
		return jdbcTemplate.queryForObject("select count(*) from GUESTBOOK", Integer.class);
	}
	@Override
	public int delete(int id) {
		// insert, update, delete를 수행할 때 update() 메서드를 이용하면 된다
		return jdbcTemplate.update("delete from GUESTBOOK where MESSAGE_ID = ?",id);
	}
	@Override
	public int insert(GuestMessage message) {
		//이건 왜 위에 delete랑 다를까????????????????????????????????????
		int insertedCount = jdbcTemplate.update("insert into GUESTBOOK(MESSAGE_ID, GUEST_NAME, "
				+ "MESSAGE, REGISTRY_DATE) values (guest_seq.nextval, ?,?,?)",
				message.getGuestName(),message.getMessage(), message.getRegistryDate());
		return insertedCount;
	}
	@Override
	public List<GuestMessage> select(int begin, int end) {
		return jdbcTemplate.query("select * from (select ROWNUM rnum, MESSAGE_ID, GUEST_NAME, "
				+ "MESSAGE, REGISTRY_DATE from (select * from GUESTBOOK order by MESSAGE_ID desc)) "
				+ "where rnum >=? and rnum <=?",new GuestMessageRowMapper(), new Object[] {begin,end});
	}
	@Override
	public int update(GuestMessage message) {
		// types 문법 신기하네
		return jdbcTemplate.update("update GUESTBOOK set MESSAGE = ? where MESSAGE_ID = ?",
				new Object[] { message.getMessage(), message.getId()},
				new int[] {Types.VARCHAR, Types.INTEGER});
				
	}

}
