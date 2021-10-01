package com.example.demo.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.dozer.DozerConverter;
import org.springframework.stereotype.Component;

/**
 * <b>Converter Dozer</b> : Convert a {@link LocalDate} to {@link Date}.
 */
@Component
public class DateConverter extends DozerConverter<LocalDateTime, Date> {

	public DateConverter() {
		super(LocalDateTime.class, Date.class);
	}

	@Override
	public Date convertTo(LocalDateTime source, Date destination) {
		if (source == null) {
			return null;
		}

		return Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
	}

	@Override
	public LocalDateTime convertFrom(Date source, LocalDateTime destination) {
		if (source == null) {
			return null;
		}

		return LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
	}

}
