package com.hack2progress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack2progress.model.dto.CalculoPanelesDTO;
import com.hack2progress.model.dto.response.PanelesResponse;
import com.hack2progress.util.Util;

@Service
public class PanelesServiceImpl implements PanelesService {

	@Autowired
	private Util util;
	
	@Override
	public PanelesResponse calcular(CalculoPanelesDTO calculo) {

		PanelesResponse response = new PanelesResponse();
		Double hsp = util.getHorasSolaresPico(calculo.getPosicion().getLon(), calculo.getPosicion().getLat());
		
		response.setNumPaneles(util.getNumeroPanelesEstimacion(hsp, calculo.getElementos()));
		response.setNumBaterias(util.numeroBaterias(calculo.getElementos(), 2, 120));
		response.setPotenciaInversor( (int) Math.round (util.ponteciaConvertidor(calculo.getElementos())));
		return response;
	}

}
