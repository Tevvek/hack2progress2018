package com.hack2progress.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hack2progress.enumeraciones.ZonaClimatica;
import com.hack2progress.model.dto.ElementoDTO;

@Component
public class Util {

	@Value("${url.cartociudad}")
	private String urlCartociudad;

	public Double getValorZonaClimatica(Double lon, Double lat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = urlCartociudad + "lon=" + lon.toString() + "&lat=" + lat.toString();
		Cartociudad cartociudadResponse = restTemplate.getForObject(url, Cartociudad.class);
		//TODO devolver valor zona enum
		ZonaClimatica zonaClimatica = ZonaClimatica.getByNombre(cartociudadResponse.getProvince());
		return zonaClimatica.getZona();
	}
	
	public Double getHorasSolaresPico(Double lon, Double lat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = urlCartociudad + "lon=" + lon.toString() + "&lat=" + lat.toString();
		Cartociudad cartociudadResponse = restTemplate.getForObject(url, Cartociudad.class);
		//TODO devolver valor zona enum
		ZonaClimatica zonaClimatica = ZonaClimatica.getByNombre(cartociudadResponse.getProvince());
		return zonaClimatica.getHorasSolaresPico();
	}

	
	public Double round(Double valor) {
		return Math.round(valor*100.0)/100.0;
	}

	// No viable para caldera
/*	public static int getNumeroPanelesEstimacion(Double horasUsoCaldera, Double potenciaCaldera, ZonaClimatica zonaClimatica,
			List<ElementoConsumo> elementos) {

		Double consumoDiario = horasUsoCaldera * potenciaCaldera;
		if (elementos != null && elementos.size() > 0) {
			for (ElementoConsumo elemento : elementos) {
				consumoDiario = consumoDiario + (elemento.getPotencia() * elemento.getHorasUso());
			}
		}
		Double energiaNecesaria = consumoDiario / 0.75;

		Integer numPaneles = (int) Math.round(energiaNecesaria / (zonaClimatica.getHorasSolaresPico() * 0.8 * 180));
		return numPaneles;
	}*/
	
	public int getNumeroPanelesEstimacion(Double hsp,List<ElementoDTO> elementos) {
		Double consumoDiario = 0.0;
	//	Double consumoDiario = horasUsoCaldera * potenciaCaldera;
		if (elementos != null && elementos.size() > 0) {
			for (ElementoDTO elemento : elementos) {
				consumoDiario = consumoDiario + (elemento.getPotencia() * elemento.getHorasUso());
			}
		}
		Double energiaNecesaria = consumoDiario / 0.75;

		Integer numPaneles = (int) Math.round(energiaNecesaria / (hsp * 0.8 * 180));
		return numPaneles;
	}

/*	public Double ponteciaConvertidor(Caldera caldera, List<ElementoConsumo> elementos) {

		Double potenciaConsumo = caldera.getPotencia();
		for (ElementoConsumo elementoConsumo : elementos) {
			if (elementos != null && elementos.size() > 0) {
				potenciaConsumo = potenciaConsumo + elementoConsumo.getPotencia();
			}

		}
		return potenciaConsumo / 0.7;
	}
	*/
	public  Double ponteciaConvertidor( List<ElementoDTO> elementos) {
		Double potenciaConsumo = 0.0;
		for (ElementoDTO elementoConsumo : elementos) {
			if (elementos != null && elementos.size() > 0) {
				potenciaConsumo = potenciaConsumo + elementoConsumo.getPotencia();
			}

		}
		return potenciaConsumo / 0.7;
	}
	
	public  Integer numeroBaterias ( List<ElementoDTO> elementos, Integer diasAutonomia, Integer ampHoraBateria) {
		Double consumoDiario = 0.0;

		if (elementos != null && elementos.size() > 0) {
			for (ElementoDTO elemento : elementos) {
				consumoDiario = consumoDiario + (elemento.getPotencia() * elemento.getHorasUso());
			}
		}
		Double energiaNecesaria = consumoDiario / 0.75;
		
		Double ampHoraNecesarios = (energiaNecesaria * diasAutonomia)/ (24*0.85);
		
		Integer numBaterias =  (int) Math.round (ampHoraNecesarios/ampHoraBateria);
		
		return numBaterias;
		
		 
	}
}
