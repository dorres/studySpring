package dorres.spring.store.dao;

import dorres.spring.store.vo.Item;

//아이템을 검색해 줄 ItemDao 인터페이스
public interface ItemDao {
	Item findById(Integer itemId);
}
