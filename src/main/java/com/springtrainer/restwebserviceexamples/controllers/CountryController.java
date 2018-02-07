package com.springtrainer.restwebserviceexamples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springtrainer.restwebserviceexamples.services.CountryService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Juan Carlos - 2018/02/02
 *
 */
@Slf4j
@Controller
public class CountryController {
	
	CountryService countryService;	
	
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping({"", "/", "/index"})
	public String showCountryDetail(Model model) {
		log.error("In showCountryDetail controller ... ");
		model.addAttribute("country", countryService.getCountryDetail());
		return "countrydetail";
	}
}
