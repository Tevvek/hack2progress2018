package com.hack2progress.model.dto.response;

import java.util.List;

public class CalculoResponse {
	private List<CalderaResponse> calderas;

	public List<CalderaResponse> getCalderas() {
		return calderas;
	}

	public void setCalderas(List<CalderaResponse> calderas) {
		this.calderas = calderas;
	}
}
