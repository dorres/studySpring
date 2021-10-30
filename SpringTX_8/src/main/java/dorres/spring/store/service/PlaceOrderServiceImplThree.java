package dorres.spring.store.service;

import org.springframework.transaction.annotation.Transactional;

import dorres.spring.store.dao.ItemDao;
import dorres.spring.store.dao.PaymentInfoDao;
import dorres.spring.store.dao.PurchaseOrderDao;
import dorres.spring.store.vo.Item;
import dorres.spring.store.vo.ItemNotFoundException;
import dorres.spring.store.vo.PaymentInfo;
import dorres.spring.store.vo.PurchaseOrder;
import dorres.spring.store.vo.PurchaseOrderRequest;
import dorres.spring.store.vo.PurchaseOrderResult;

public class PlaceOrderServiceImplThree implements PlaceOrderService {
	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setPaymentInfoDao(PaymentInfoDao paymentInformationDao) {
		this.paymentInfoDao = paymentInformationDao;
	}

	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	@Override
	@Transactional
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException {
		Item item = itemDao.findById(orderRequest.getItemId());
		if (item == null)
			throw new ItemNotFoundException(orderRequest.getItemId());
		
		PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
		paymentInfoDao.insert(paymentInfo);
		
		PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest.getAddress(), paymentInfo.getId());
		purchaseOrderDao.insert(order);
		return new PurchaseOrderResult(item, paymentInfo, order);
	}
}
