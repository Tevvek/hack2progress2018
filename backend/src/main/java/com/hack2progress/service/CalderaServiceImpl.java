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
		util.getValorZonaClimatica("-3.8166997", "43.4617696");
		
		return new CalculoResponse();
	}

}
