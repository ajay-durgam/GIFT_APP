package com.edubridge.giftapp.dao;

import java.util.List;

import com.edubridge.giftapp.model.Gift;



public interface GiftDao {
	int addGift(Gift g);
	List<Gift> findGifts();
	Gift findGiftByName(String name);
	int updateGift(Gift c);
	int deleteGiftByName(String name);
	void deleteAllGifts();

}
