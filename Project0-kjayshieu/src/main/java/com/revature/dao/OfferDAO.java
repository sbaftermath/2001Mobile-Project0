package com.revature.dao;

import java.util.List;

import com.revature.pojo.Offer;

public interface OfferDAO {
	
	public void addOffer(String car, int offer);
	
	public void acceptOffer(String car, int offer);
	
	public void rejectOffer(String car, int offer);
	
	public List<Offer> viewOffers();

}
