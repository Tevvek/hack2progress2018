package com.hack2progress.util;

public class Cartociudad {
	public String poblacion;
	public String province;

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Cartociudad [poblacion=" + poblacion + ", province=" + province + "]";
	}
}
