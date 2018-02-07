package com.springtrainer.restwebserviceexamples.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.springtrainer.restwebserviceexamples.domain.Country;
import com.springtrainer.restwebserviceexamples.domain.GeoWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Juan Carlos - 2018/02/02
 *
 */
@Slf4j
@Service
public class CountryServiceImpl implements CountryService {
	private RestTemplate restTemplate;
	private final String api_url;

	public CountryServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
		this.restTemplate = restTemplate;
		this.api_url = api_url;
	}

	/* (non-Javadoc)
	 * @see com.springtrainer.restwebserviceexamples.services.CountryService#getCountryDetail()
	 */
	@Override
	public Country getCountryDetail() {
		MultiValueMap<String, String> params =  new LinkedMultiValueMap<>();
		params.add("formatted", "false");
		params.add("lang", "it");
		params.add("country", "PE");
		params.add("username", "jkarloz");
		params.add("style", "full");
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromUriString(api_url)
				.queryParams(params);
		log.error("Before executing call to service ...");
		GeoWrapper response = restTemplate.getForObject(uriBuilder.toUriString(), GeoWrapper.class);
		log.error("After calling service - content size: " + response.getGeonames().size());
		return response.getGeonames().get(0);
	}

}
