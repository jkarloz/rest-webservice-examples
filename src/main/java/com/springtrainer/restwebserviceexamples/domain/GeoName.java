package com.springtrainer.restwebserviceexamples.domain;

import java.util.List;

/**
 * @author Juan Carlos - 2018/02/02
 *
 */
public class GeoName {
	private List<Country> geonames;

	public List<Country> getGeonames() {
		return geonames;
	}

	public void setGeonames(List<Country> geonames) {
		this.geonames = geonames;
	}
}
