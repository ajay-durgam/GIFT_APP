package com.edubridge.giftapp.service;

import java.util.List;

import com.edubridge.giftapp.model.Gift;

public interface GiftService {
	int addGift(Gift g);
	List<Gift> findGifts();
	Gift findGiftByName(String name);
	int updateGift(Gift c);
	int deleteGiftByName(String name);
	void deleteAllGifts();

}
