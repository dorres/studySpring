package dogba.spring.member.service;

import dogba.spring.member.vo.MemberVO;
import dogba.spring.member.vo.UpdateInfo;

public interface MemberService {
	void regist(MemberVO member);
	boolean update(String memberId, UpdateInfo info);
}
