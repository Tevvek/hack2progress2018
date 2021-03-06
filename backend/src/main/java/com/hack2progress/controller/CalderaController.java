package com.hack2progress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hack2progress.model.dto.CalculoDTO;
import com.hack2progress.model.dto.response.CalderaResponse;
import com.hack2progress.service.CalderaService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CalderaController {
	
	@Autowired
	private CalderaService calderaService;
	
	@GetMapping("/pruebas")
	public int pruebas() {
		return 1;
    }
	
	@PostMapping(path="/calcular", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<CalderaResponse> calcular(@RequestBody CalculoDTO calculo) {
		List<CalderaResponse> lista = calderaService.calcular(calculo);  
		return lista;
    }
}
