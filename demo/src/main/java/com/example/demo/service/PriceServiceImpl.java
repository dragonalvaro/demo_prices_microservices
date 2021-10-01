package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.DateConverter;
import com.example.demo.dto.PriceDTO;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.PriceModel;
import com.example.demo.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private DateConverter dateConverter;
	
	@Autowired
	private DozerBeanMapper objectMapper;
	

	@Override
	public PriceDTO getPriceByProductBrandDate(Long brandId, Long productId, LocalDateTime dateToApply) {
		
		Date date = dateConverter.convertTo(dateToApply);
		
		//Como las palabras claves After y Before son estrictamente mayor o menor que la fecha, no encontraría resultados cuando coincida exactamente la fecha
		//por lo que lo correcto seria usar una CustomQuery.
		//Tambien seria posible que al definir la query manualmente, devolviera el resultado con el priority mas alto, pero he decidirlo dejarlo asi
		//para poder usar streams
		
		//List<PriceModel> priceModel = priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(brandId, productId, date, date);
		
		List<PriceModel> priceModel = priceRepository.findPriceByBrandIdProductIdDate(brandId, productId, date);
		
		PriceModel found = priceModel.stream().max(Comparator.comparing(PriceModel::getPriority)).orElseThrow(NotFoundException::new);
		
		return objectMapper.map(found, PriceDTO.class);
	}
	

}