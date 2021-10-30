package dorres.spring.store.vo;

//결제 정보를 기억할 PaymentInfo 클래스
public class PaymentInfo {
	private Integer id;
	private int price;
	
	public PaymentInfo(Integer id) {
		this.id = id;
	}
	public PaymentInfo(int price) {
		this.price = price;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


}
