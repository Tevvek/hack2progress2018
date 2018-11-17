package com.hack2progress.service;

import com.hack2progress.model.dto.CalculoDTO;
import com.hack2progress.model.dto.response.CalculoResponse;

public interface CalderaService {
	
	public CalculoResponse calcular(CalculoDTO calculo);

}
