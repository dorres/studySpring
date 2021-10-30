package dorres.spring.web.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dorres.spring.web.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		return board;
	}
}
//RowMapper ��ü�� queryForObject() �޼����� �Ű������� �Ѱ��ָ� ������ �����̳ʴ� SQL ������ 
//������ �� �ڵ����� RowMapper ��ü�� mapRow() �޼��带 ȣ���Ѵ�.
