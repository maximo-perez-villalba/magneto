package com.magneto.analyzer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.magneto.analyzer.core.Analyzer;
import com.magneto.analyzer.entity.DNA;
import com.magneto.analyzer.repository.DNARepository;

@Service
public class DNAservice 
{
	private Analyzer analyzer;
	
	@Autowired
	private DNARepository repository;
	
	public DNAservice() 
	{
		this.analyzer = new Analyzer();
	}
	
	@Transactional
	public boolean isMutant(String[] dna) throws Exception 
	{
		DNA dnaObject = new DNA();
		dnaObject.setSequences((new Gson()).toJson(dna));
		dnaObject.setIsMutant(this.analyzer.isMutant(dna));
		this.repository.save(dnaObject);
		
		return dnaObject.getIsMutant();
	}
}
