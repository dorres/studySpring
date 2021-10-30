package dorres.spring.member.service;

import dorres.spring.member.vo.MemberVO;
import dorres.spring.member.vo.UpdateInfo;

public interface MemberService {
	void regist(MemberVO member);
	boolean update(String memberId, UpdateInfo info);
}
