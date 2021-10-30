package dorres.spring.store.service;

import dorres.spring.store.vo.ItemNotFoundException;
import dorres.spring.store.vo.PurchaseOrderRequest;
import dorres.spring.store.vo.PurchaseOrderResult;

public interface PlaceOrderService {
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException;
}
