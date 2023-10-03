package com.Electronics.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Electronics.demo.Entity.AcEntity;
import com.Electronics.demo.Exception.ColorNotFound;
import com.Electronics.demo.Exception.ModelNotFoundException;
import com.Electronics.demo.Exception.PriceNotFoundException;
import com.Electronics.demo.Service.AcService;



@RestController
public class AcController {
	@Autowired
	AcService as;
	@PostMapping(value="postAll")
	public String postValues(@RequestBody List<AcEntity> s) { 
		return as.postAll(s);
	}
	@PostMapping(value="getAll")
	public List<AcEntity> getAll() {
        return as.getAll();
    }
	@GetMapping(value="getById/{id}")
	public AcEntity getById(@PathVariable int id) {
		return as.getById(id);
	}
	@PutMapping(value="/update")
	public AcEntity update(@RequestBody AcEntity s) {
		return as.update(s);
	}
	@GetMapping(value="getByBrand/{b}")
	public List<AcEntity> getByBrand(@PathVariable String b) throws ModelNotFoundException {
		return as.getByBrand(b);
	}
	@GetMapping(value="getByYear/{b}")
	public List<AcEntity> getByYear(@PathVariable int b) {
		return as.getByYear(b);
	}
	@GetMapping(value="getByPriceRange/{b}")
	public List<AcEntity> getByPriceRange(@PathVariable int b) {
		return as.getByPriceRange(b);
	}
	@GetMapping(value="MaxPrice")
	public AcEntity MaxPrice() {
		return as.MaxPrice();
	}
	@GetMapping(value="getMaxPrice")
	public int getMaxPrice() {
		return as.getMaxPrice();
	}
	@PostMapping(value="/postvalue")
	public String postByPriceRange(@RequestBody AcEntity s) throws PriceNotFoundException {
		return as.postByPriceRange(s);	
	}
	@GetMapping(value="getByColor/{b}")
	public List<AcEntity> getByColor(@PathVariable String b) throws ColorNotFound{
		return as.getByColor(b);
}
	@PostMapping(value="/postdata")
	public String postByPriceYearRange(@RequestBody AcEntity s) throws PriceNotFoundException {
		return as.postByPriceYearRange(s);
		}	
	@PostMapping(value="/postbrand")
	public String postByBrandYearRange(@RequestBody AcEntity s) throws ModelNotFoundException {
		return as.postByBrandYearRange(s);
	}
	@PostMapping(value="postData")
	public List<AcEntity> postByModelYear(@RequestBody List<AcEntity> s) throws ColorNotFound { 
		return as.postByModelYear(s);
	}
}
