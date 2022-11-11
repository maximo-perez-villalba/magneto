package com.magneto.analyzer.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.analyzer.core.Analyzer;

@RestController
@RequestMapping("/api/mutant")
public class MutantRestController 
{

	@PostMapping
	public ResponseEntity<?> isMutant(@RequestBody String[] dna)
	{
		ResponseEntity<?> response;
		Analyzer analyzer = new Analyzer();
		try 
		{
			if(analyzer.isMutant(dna)) 
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
