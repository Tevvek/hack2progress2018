package com.hack2progress.service;

import com.hack2progress.model.dto.CalculoPanelesDTO;
import com.hack2progress.model.dto.response.PanelesResponse;

public interface PanelesService {
	
	public PanelesResponse calcular(CalculoPanelesDTO calculo);

}
