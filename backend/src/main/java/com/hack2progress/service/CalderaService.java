package com.hack2progress.service;

import java.util.List;

import com.hack2progress.model.dto.CalculoDTO;
import com.hack2progress.model.dto.response.CalderaResponse;

public interface CalderaService {
	
	public List<CalderaResponse> calcular(CalculoDTO calculo);

}
