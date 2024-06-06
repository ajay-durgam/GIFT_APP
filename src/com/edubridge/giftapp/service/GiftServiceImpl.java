package com.edubridge.giftapp.service;

import java.util.List;

import com.edubridge.giftapp.dao.GiftDao;
import com.edubridge.giftapp.dao.GiftDaoImpl;
import com.edubridge.giftapp.model.Gift;

public class GiftServiceImpl implements GiftService {

	private GiftDao gd = new GiftDaoImpl();
	@Override
	public int addGift(Gift g) {
		
		return gd.addGift(g);
	}

	@Override
	public List<Gift> findGifts() {
		
		return gd.findGifts();
	}

	@Override
	public Gift findGiftByName(String name) {
		
		return gd.findGiftByName(name);
	}

	@Override
	public int updateGift(Gift c) {
		
		return gd.updateGift(c);
	}

	@Override
	public int deleteGiftByName(String name) {
		
		return gd.deleteGiftByName(name);
	}

	@Override
	public void deleteAllGifts() {
		
	      gd.deleteAllGifts();
		
		
	}

}
