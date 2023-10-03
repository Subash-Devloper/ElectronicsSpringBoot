package com.Electronics.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Electronics.demo.Doa.AcDoa;
import com.Electronics.demo.Entity.AcEntity;
import com.Electronics.demo.Exception.ColorNotFound;
import com.Electronics.demo.Exception.ModelNotFoundException;
import com.Electronics.demo.Exception.PriceNotFoundException;
@Service
public class AcService {
@Autowired
AcDoa ad;
	public String postAll(List<AcEntity> s) {
		return ad.postAll(s);
	}
	public List<AcEntity> getAll() {
		return ad.getAll();
	}
	public AcEntity getById(int id) {
		return ad.getById(id);
	}
	public AcEntity update(AcEntity s) {
		return ad.update(s);
	}
	public List<AcEntity> getByBrand(String brand)throws ModelNotFoundException {
		
		return ad.getByBrand(brand);
	}
public List<AcEntity> getByYear(int a) {
		
		return ad.getByYear(a);
	}
public List<AcEntity> getByPriceRange(int b) {
	
	return ad.getByPriceRange(b);
}
public AcEntity MaxPrice() {
	return ad.MaxPrice();
}
public int getMaxPrice() {
	return ad.getMaxPrice();
}
public String postByPriceRange(AcEntity s) throws PriceNotFoundException {
	return ad.postByPriceRange(s);	
}

public List<AcEntity> getByColor(String b) throws ColorNotFound {
		if(ad.getByColor(b).isEmpty() ) {
			throw new ColorNotFound("NotMatchColor");
		}
		else {
			return ad.getByColor(b) ;
		}
}
public String postByPriceYearRange(AcEntity s) throws PriceNotFoundException {
	if(s.getPrice()<=30000 && s.getModelYear()==2020) {
		return ad.postByPriceYearRange(s);
	}
	else {
	 throw new PriceNotFoundException("This price very High");
	}
	
}
public String postByBrandYearRange(AcEntity s) throws ModelNotFoundException {
	if(s.getModelYear()==2019 && s.getBrand().equals("croma")) {
		return ad.postByBrandYearRange(s);
	}
	else {
	 throw new ModelNotFoundException("This brand not equal");
	}
	
}
public List<AcEntity> postByModelYear(List<AcEntity> s) throws ColorNotFound {
	
	if(ad.postByModelYear(s).isEmpty()) {
			throw new ColorNotFound("NotMatchYear");
		}
		else {
			return ad.postByModelYear(s) ;
		}
}
}

