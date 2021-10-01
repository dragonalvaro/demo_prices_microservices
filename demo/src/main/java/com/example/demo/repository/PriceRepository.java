package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.PriceModel;

public interface PriceRepository extends JpaRepository<PriceModel, Long>{
	
	List<PriceModel> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(Long brandId, Long productId, Date startDate, Date endDate);
	
	@Query("SELECT p FROM PriceModel p WHERE p.brandId = ?1 AND p.productId = ?2 AND p.startDate <= ?3 AND p.endDate >= ?3")
	List<PriceModel> findPriceByBrandIdProductIdDate(Long brandId, Long productId, Date date);
	
}
