package com.magneto.analyzer.service;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.magneto.analyzer.core.Analyzer;
import com.magneto.analyzer.entity.DNA;
import com.magneto.analyzer.model.DNAStats;
import com.magneto.analyzer.repository.DNARepository;

@Service
public class DNAservice 
{
	@Autowired
	private Analyzer analyzer;
	
	@Autowired
	private DNARepository repository;
	
	/**
	 * Cachea las estadísticas. 
	 */
	private static DNAStats stats = null;
	
	@Transactional
	public boolean isMutant(String[] dna) throws Exception 
	{
		DNA dnaObject = new DNA();
		dnaObject.setSequences((new Gson()).toJson(dna));
		dnaObject.setIsMutant(this.analyzer.isMutant(dna));
		this.repository.save(dnaObject);
		
		//Fuerza la actualización de las estadísticas.
		stats = null;
		
		return dnaObject.getIsMutant();
	}
	
	public DNAStats stats() 
	{
		if(Objects.isNull(stats)) 
		{
			long countMutant = this.repository.countByIsMutantTrue();
			long countHuman = this.repository.countByIsMutantFalse();
			
			double ratio = 0.0;
			if(countHuman > 0)
			{
				ratio = (double)countMutant/countHuman;
			}
			
			stats = new DNAStats();
			stats.setCount_mutant_dna(countMutant);
			stats.setCount_human_dna(countHuman);
			stats.setRatio(ratio);
		}
		return stats;		
	}
}
