package com.hack2progress.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Util {
	
	@Value("${url.cartociudad}")
	private String urlCartociudad;
	
	public int getValorZonaClimatica(String lon, String lat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = urlCartociudad + "lon=" + lon + "&lat=" + lat;
        Cartociudad cartociudadResponse = restTemplate.getForObject(url, Cartociudad.class);
        System.out.println(cartociudadResponse);
        return 1;
	}
}
