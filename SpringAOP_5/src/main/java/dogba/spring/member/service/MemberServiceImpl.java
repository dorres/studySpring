package dogba.spring.member.service;

import dogba.spring.member.vo.MemberVO;
import dogba.spring.member.vo.UpdateInfo;

public class MemberServiceImpl implements MemberService {

	@Override
	public void regist(MemberVO member) {
		System.out.println("MemberServiceImpl.regist()메서드실행");
	}
	
	@Override
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("MemberServiceImpl.update()메서드 실행");
		return true;
	}

}
