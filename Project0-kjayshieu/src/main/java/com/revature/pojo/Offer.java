package com.revature.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Offer implements Serializable {
	
	public HashMap<String, List<Integer>> offer = new HashMap<String, List<Integer>>();
	public List<Integer> custOffer = new ArrayList<Integer>();
	public int amount;
	public String iD;
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getID() {
		return iD;
	}
	
	public void setID(String iD) {
		this.iD = iD;
	}
	
	public HashMap<String, List<Integer>> createOffer() {
		custOffer.add(amount);
		offer.put(iD, custOffer);
		return offer;
	}

	
}
