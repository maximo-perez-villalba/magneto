package com.magneto.analyzer.core;

import org.springframework.stereotype.Component;

@Component
public class Analyzer 
{
	
	public boolean isMutant(String[] dna) throws Exception 
	{
		int matches = 0; 
		matches = this.analyzeHorizontalLines(dna);
		matches += this.analyzeVerticalLines(dna);
		matches += this.analyzeDiagonalLines(dna);
		return matches > 2;
	}
	
	public int analyzeHorizontalLines(String[] dna) throws Exception 
	{
		int matches = 0; 
		for(int row=0; row < dna.length; row++) 
		{
			ChainDNA chain = new ChainDNA(dna.length);
			for(int col=0; col <  dna.length; col++) 
			{
				chain.add(dna[row].charAt(col));
			}
			
			if(chain.existsMutantSequence()) 
			{
				matches++;
			}
		}
		return matches;
	}
	
	public int analyzeVerticalLines(String[] dna) throws Exception 
	{
		int matches = 0; 
		for(int col=0; col < dna.length; col++) 
		{
			ChainDNA chain = new ChainDNA(dna.length);
			
			for(int row=0; row <  dna.length; row++) 
			{
				chain.add(dna[row].charAt(col));
			}
			
			if(chain.existsMutantSequence()) 
			{
				matches++;
			}
		}
		return matches;
	}

	public int analyzeDiagonalLines(String[] dna) throws Exception 
	{
		int matches = 0; 

		/*
		 * Analiza las cadenas diagonales que comienzan con: dna[0][0], dna[1][0], dna[2][0].
		 */
		int range = Math.floorDiv(dna.length,2);
		for(int offset = 0; offset < range; offset++)
		{
			ChainDNA chain = new ChainDNA(dna.length - offset);
			for(int row = offset, col = 0; col < dna.length - offset; row++, col++) 
			{
				chain.add(dna[row].charAt(col));
			}
			if(chain.existsMutantSequence()) 
			{
				matches++;				
			}
		}

		/*
		 * Analiza las cadenas diagonales que comienzan con: dna[1][0], dna[2][0].
		 */
		for(int offset = 1; offset < range; offset++)
		{
			ChainDNA chain = new ChainDNA(dna.length - offset);
			for(int row = 0, col = offset; row < dna.length - offset; row++, col++) 
			{
				chain.add(dna[row].charAt(col));
			}
			if(chain.existsMutantSequence()) 
			{
				matches++;
			}
		}
		
		return matches;
	}
}
