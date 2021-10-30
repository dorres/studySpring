package dorres.spring.store.dao;

import dorres.spring.store.vo.PaymentInfo;

// 결제정보를 저장해줄 PaymentInfoDao 인터페이스
public interface PaymentInfoDao {
	void insert(PaymentInfo paymentInfo);
}
