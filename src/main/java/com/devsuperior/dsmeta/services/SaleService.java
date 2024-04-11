package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SalesReportDTO> findAllReport(String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate finalDate = maxDate.equals("") ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) : LocalDate.parse(maxDate);
		LocalDate initialDate = minDate.equals("") ? finalDate.minusYears(1L) : LocalDate.parse(minDate);

		Page<Sale> result = repository.searchSales(initialDate, finalDate, name, pageable);
		return result.map(x -> new SalesReportDTO(x));
	}

	public Page<SalesSummaryDTO> findSummary(String minDate, String maxDate, Pageable pageable) {
		LocalDate finalDate = maxDate.equals("") ? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) : LocalDate.parse(maxDate);
		LocalDate initialDate = minDate.equals("") ? finalDate.minusYears(1L) : LocalDate.parse(minDate);

		Page<Object[]> result = repository.searchSalesSummary(initialDate, finalDate, pageable);
		return result.map(x -> new SalesSummaryDTO(x));
	}

}
