package com.magneto.analyzer.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.analyzer.service.DNAservice;

@RestController
@RequestMapping("/api/mutant")
public class MutantRestController 
{
	@Autowired
	private DNAservice service;

	@PostMapping
	public ResponseEntity<?> isMutant(@RequestBody String[] dna)
	{
		ResponseEntity<?> response;
		try 
		{
			if(this.service.isMutant(dna)) 
			{
				response = ResponseEntity.status(HttpStatus.OK).build();
			}
			else
			{
				response = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
		} 
		catch (Exception e) 
		{
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return response;
	}
}
