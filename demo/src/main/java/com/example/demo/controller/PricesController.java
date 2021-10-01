package com.example.demo.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PriceDTO;
import com.example.demo.service.PriceService;

@RestController
@RequestMapping("/prices")
public class PricesController {
	
	@Autowired
	private PriceService priceService;
	
	private static final Logger log = LoggerFactory.getLogger(PricesController.class);

	@GetMapping(value = "/{brandId}/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public PriceDTO getPriceByProductBrandDate(@PathVariable Long brandId,  
											   @PathVariable Long productId,
											   @RequestParam(name = "date") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dateToApply) { 
		
		log.debug("getPriceByProductBrandDate recieved request {}/{}/{}", productId, brandId, dateToApply);
		
		Assert.notNull(productId, "El identificador del producto no puede ser nulo");
		Assert.notNull(brandId, "El identificador de la cadena no puede ser nulo");
		Assert.notNull(dateToApply, "Es necesario una fecha para poder devolver el precio");
		
		return priceService.getPriceByProductBrandDate(brandId, productId, dateToApply);
	}
	
}
