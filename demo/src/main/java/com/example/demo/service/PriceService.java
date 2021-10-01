package com.example.demo.service;

import java.time.LocalDateTime;

import com.example.demo.dto.PriceDTO;

public interface PriceService {

	
	/**
	 * Se obtiene el precio deseado a partir de los siguientes parametros:
	 * 
	 * @param productId El identificador del producto
	 * @param brandId El identificador de la cadena
	 * @param dateToApply La fecha para aplicar
	 * @return
	 */
	PriceDTO getPriceByProductBrandDate(Long brandId, Long productId, LocalDateTime dateToApply);

}
