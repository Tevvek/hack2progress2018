package com.hack2progress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hack2progress.model.dto.CalculoPanelesDTO;
import com.hack2progress.model.dto.response.PanelesResponse;
import com.hack2progress.service.PanelesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PanelesController {

	@Autowired
	private PanelesService panelesService;
	@GetMapping("/pruebasPanel")
	public int pruebas() {
		return 1;
    }
	
	@PostMapping(path="/calcularPaneles")
    public PanelesResponse calcular(@RequestBody CalculoPanelesDTO calculo) {
		return panelesService.calcular(calculo);  
    }
}
