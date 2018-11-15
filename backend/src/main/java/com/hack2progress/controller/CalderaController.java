package com.hack2progress.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hack2progress.model.Caldera;
import com.hack2progress.repository.CalderaRepository;

@RestController
public class CalderaController {
	
	@Autowired
	private CalderaRepository calderaRepository;
	
	@GetMapping("/caldera/list")
	public Page<Caldera> getCalderaList(Pageable pageable){
		return calderaRepository.findAll(pageable);
	}
	
	@PostMapping("/caldera")
    public Caldera createQuestion(@Valid @RequestBody Caldera caldera) {
        return calderaRepository.save(caldera);
    }

}
