package com.poy.J6_Huyntpc00617.Service;

import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Color;

public interface colorservice {

	List<Color> getAll();
	List<Color> getNameColor(Integer productid);
	Color save(Color c);
	Color findByProductColordetails(Integer productid, String tim);
	void deleteByProductIdAndColorDetailsID(Integer productid, String colordetailsid);
	List<Color> getProductID(Integer id);
	void deleteByID(Integer colorid);

}
