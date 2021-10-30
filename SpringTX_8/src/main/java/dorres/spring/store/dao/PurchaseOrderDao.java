package dorres.spring.store.dao;

import dorres.spring.store.vo.PurchaseOrder;

//구매 주문 결과를 저장해 줄 PurchaseOrderDao 인터페이스
public interface PurchaseOrderDao {
	void insert(PurchaseOrder order);
}
