package com.revature.dao;

import com.revature.pojo.Lot;

public interface LotDAO {
	
	void createLot(Lot lot);
	
	Lot readLot();

}
