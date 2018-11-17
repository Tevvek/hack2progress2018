package com.hack2progress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack2progress.model.dto.CalculoDTO;
import com.hack2progress.model.dto.response.CalculoResponse;
import com.hack2progress.util.Util;

@Service
public class CalderaServiceImpl implements CalderaService {

	@Autowired
	private Util util;
	
	@Override
	public CalculoResponse calcular(CalculoDTO calculo) {
		CalculoResponse calculoResponse = new CalculoResponse();
		Double valorZC = util.getValorZonaClimatica(calculo.getPosicion().getLon(), calculo.getPosicion().getLat());
		Double potenciaCaldera = (calculo.getSuperficie() * calculo.getValorOrientacion() * calculo.getValorAislamiento() * valorZC * 85)/1000;
		
		return new CalculoResponse();
	}

}
