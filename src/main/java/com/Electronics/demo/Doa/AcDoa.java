package com.Electronics.demo.Doa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Electronics.demo.Entity.AcEntity;
import com.Electronics.demo.Exception.ColorNotFound;
import com.Electronics.demo.Exception.ModelNotFoundException;
import com.Electronics.demo.Exception.PriceNotFoundException;
import com.Electronics.demo.Repo.AcRepo;
@Repository
public class AcDoa {
@Autowired
AcRepo ar;
	public String postAll(List<AcEntity> s) {
		ar.saveAll(s);
		return "Data Saved Successfully";
	}
	public List<AcEntity> getAll() {
		return ar.findAll();
	}
	public AcEntity getById(int id) {
		return ar.findById(id).get();
		
	}
	public AcEntity update(AcEntity s) {
		return ar.save(s);
	}
	public List<AcEntity> getByBrand(String brand)throws ModelNotFoundException {
		if(ar.getbyBrand(brand).isEmpty()) {
			throw new ModelNotFoundException("This brand is not available ");
		} 
		else {
			return ar.getbyBrand(brand);
		}
	}
	public List<AcEntity> getByYear(int a) {
		return ar.getByYear(a);
	}
	public List<AcEntity> getByPriceRange(int b) {
		return ar.getByPriceRange(b);
	}
	public AcEntity MaxPrice() {
		return ar.MaxPrice();
	}
	public int getMaxPrice() {
		return ar.getMaxPrice();
	}
	public String postByPriceRange(AcEntity s) throws PriceNotFoundException {
		if(s.getPrice()>=30000) {
			throw new PriceNotFoundException("This price very High");
		}
		else {
		 ar.save(s);
		 return "Saved Successfully";
		}
		
	}
	public List<AcEntity> getByColor(String b)throws ColorNotFound {
		return ar.getByColor(b);
	}
	public String postByPriceYearRange(AcEntity s) {
		 ar.save(s);
		 return "Data Saved Succesfully";
	}
	public String postByBrandYearRange(AcEntity s) {
		ar.save(s);
		 return "Data Saved Succesfully";
	}
	public List<AcEntity> postByModelYear(List<AcEntity> s) {
		return ar.saveAll(s);
		
	}
	

}
