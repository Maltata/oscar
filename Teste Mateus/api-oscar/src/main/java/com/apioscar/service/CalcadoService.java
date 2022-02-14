package com.apioscar.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.apioscar.model.Calcado;
import com.apioscar.repository.CalcadoRepository;

@Service
public class CalcadoService {

	@Autowired
	private CalcadoRepository calcadoRepository;

	public Calcado atualizar(Long idCalcado, Calcado calcado) {
		Calcado calcadoSalvo = calcadoRepository.findById(idCalcado)
                                .orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		BeanUtils.copyProperties(calcado, calcadoSalvo, "idCodigo");
		return calcadoRepository.save(calcadoSalvo);
	}

	public LocalDate getDataAtual() {
		LocalDate todaysDate = LocalDate.now();
		
		return todaysDate;
	}   
}
