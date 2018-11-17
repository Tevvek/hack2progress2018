package com.hack2progress.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hack2progress.enumeraciones.ZonaClimatica;
import com.hack2progress.model.Caldera;
import com.hack2progress.model.ElementoConsumo;

@Component
public class Util {

	@Value("${url.cartociudad}")
	private String urlCartociudad;

	public Double getValorZonaClimatica(Double lon, Double lat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = urlCartociudad + "lon=" + lon.toString() + "&lat=" + lat.toString();
		Cartociudad cartociudadResponse = restTemplate.getForObject(url, Cartociudad.class);
		//TODO devolver valor zona enum
		return new Double("1.04");
	}

	public int getNumeroPanelesEstimacion(Double horasUsoCaldera, Double potenciaCaldera, ZonaClimatica zonaClimatica,
			List<ElementoConsumo> elementos) {

		Double consumoDiario = horasUsoCaldera * potenciaCaldera;
		if (elementos != null && elementos.size() > 0) {
			for (ElementoConsumo elemento : elementos) {
				consumoDiario = consumoDiario + (elemento.getPotencia() * elemento.getHorasUso());
			}
		}
		Double energiaNecesaria = consumoDiario / 0.75;

		Integer numPaneles = (int) Math.round(energiaNecesaria / (zonaClimatica.getHorasSolaresPico() * 0.8 + 180));
		return numPaneles;
	}

	public Double ponteciaConvertidor(Caldera caldera, List<ElementoConsumo> elementos) {

		Double potenciaConsumo = caldera.getPotencia();
		for (ElementoConsumo elementoConsumo : elementos) {
			if (elementos != null && elementos.size() > 0) {
				potenciaConsumo = potenciaConsumo + elementoConsumo.getPotencia();
			}

		}
		return potenciaConsumo / 0.7;
	}
}
