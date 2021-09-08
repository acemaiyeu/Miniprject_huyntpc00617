package com.poy.J6_Huyntpc00617.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.Color;
import com.poy.J6_Huyntpc00617.Bean.ColorsDetails;
import com.poy.J6_Huyntpc00617.Bean.Product;
import com.poy.J6_Huyntpc00617.Service.*;

@RestController
public class ColorRestController{
	@Autowired colorservice colorservice;
	@Autowired ColorDetailsSerivce cdservice;
	@Autowired ProductService proservice;
	@GetMapping("/rest/colors")
	public List<Color> getALl(){
		return colorservice.getAll();
	}
	@GetMapping("/rest/colorsname/{productid}")
	public List<Color> getColorName(@PathVariable("productid") Integer productid){
		return colorservice.getNameColor(productid);
	}
	@PostMapping("/rest/color/{productid}")
	public Color createList(@RequestBody List<String> list,@PathVariable("productid") Integer productid) {
		System.out.println("added: "+list.size());
		String tim = "";
		
		for(String s : list) {
					ColorsDetails cd = cdservice.findById(s);
					Product pro = proservice.findById(productid);
					Color c = new Color(); 
					c.setColorsdetails(cd);
					c.setProduct(pro);
					colorservice.save(c);
			tim = s;
			Color co = colorservice.findByProductColordetails(productid, tim);
			System.out.println(co.getColorid()+ " | "+co.getColorsdetails().getColorid());
		}
		return colorservice.findByProductColordetails(productid, tim);
	}
	@DeleteMapping("/rest/color/delete/{productid}/{colordetailsid}")
	public void deletecolor(@PathVariable("productid") Integer productid, @PathVariable("colordetailsid") String colordetailsid) {
		List<Color> list = colorservice.getAll();
		list.forEach(k -> {
			System.out.println("deletecolor: "+k.getColorid()+" | "+productid+" | "+k.getProduct().getProductidl()+" | "+colordetailsid+" | "+k.getColorsdetails().getColorid());
			if(k.getProduct().getProductidl().equals(productid) && k.getColorsdetails().getColorid().equals(colordetailsid)) {
				colorservice.deleteByID(k.getColorid());
				System.out.println("CÓ");
			}	
		});
	}
	@PostMapping("/rest/color")
	public Color create(@RequestBody Color color) {
		return colorservice.save(color);
	}
	@DeleteMapping("/rest/colors/delete/{productid}")
	public void deletelistcolor(@RequestParam("item") List<String> list ,@PathVariable("productid") Integer productid) {
		List<Color> colist = colorservice.getAll();
		colist.forEach(k -> {
			for(String s : list) {
			if(k.getProduct().getProductidl().equals(productid) && k.getColorsdetails().getColorid().equals(s)) {
				colorservice.deleteByID(k.getColorid());
			}
			}
		});
		for(String s : list) {
			
			System.out.println(s);
		}
	}
}
