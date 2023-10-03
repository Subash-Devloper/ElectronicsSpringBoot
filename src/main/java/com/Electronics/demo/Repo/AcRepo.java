package com.Electronics.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Electronics.demo.Entity.AcEntity;

public interface AcRepo extends JpaRepository<AcEntity, Integer> {
@Query(value="select*from ac where brand like ?",nativeQuery=true)
public List<AcEntity> getbyBrand(String brand);
@Query(value="select*from ac where model_year like ?",nativeQuery=true)
public List<AcEntity> getByYear(int year);
@Query(value="select*from ac where price >?",nativeQuery=true)
public List<AcEntity> getByPriceRange(int year);
@Query(value="select * from ac where price = (select max(price) from ac)",nativeQuery=true)
public AcEntity MaxPrice();
@Query(value="select max(price) from ac ",nativeQuery=true)
public int getMaxPrice();
@Query(value="select*from ac where color like ?",nativeQuery=true)
public List<AcEntity> getByColor(String color);
@Query(value="select*from ac where model_year ?= 2019",nativeQuery=true)
public List<AcEntity> postByModelYear(List<AcEntity> s) ;

}
