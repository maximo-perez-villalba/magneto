package com.magneto.analyzer.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnalyzerTest 
{

	@Test
	void testAnalyzeHorizontalLinesOK() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		
		int match = analyzer.analyzeHorizontalLines(this.dnaMutant());
		
		assertEquals(1, match);
	}
	
	@Test
	void testAnalyzeHorizontalLinesFail() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		
		int match = analyzer.analyzeHorizontalLines(this.dnaHuman());
		
		assertEquals(0, match);
	}

	@Test
	void testAnalyzeVerticalLinesOk() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		
		int match = analyzer.analyzeVerticalLines(this.dnaMutant());
		
		assertEquals(1, match);
	}

	@Test
	void testAnalyzeVerticalLinesFail() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		
		int match = analyzer.analyzeVerticalLines(this.dnaHuman());
		
		assertEquals(0, match);
	}
	
	@Test
	void testAnalyzeDiagonalLinesOk() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		
		int match = analyzer.analyzeDiagonalLines(this.dnaMutant());
		
		assertEquals(1, match);
	}
	
	@Test
	void testAnalyzeDiagonalLinesFail() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		
		int match = analyzer.analyzeDiagonalLines(this.dnaHuman());
		
		assertEquals(0, match);
	}
	
	@Test
	void testIsMutantTrue() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		assertTrue(analyzer.isMutant(this.dnaMutant()));
	}
	
	@Test
	void testIsMutantTrueA() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		assertTrue(analyzer.isMutant(this.dnaMutantA()));
	}
	
	@Test
	void testIsMutantTrueB() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		assertTrue(analyzer.isMutant(this.dnaMutantB()));
	}
	
	@Test
	void testIsMutantFalse() throws Exception 
	{
		Analyzer analyzer = new Analyzer();
		assertFalse(analyzer.isMutant(this.dnaHuman()));
	}
	
	private String[] dnaMutant() 
	{
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		return dna;
	}

	private String[] dnaHuman() 
	{
		String[] dna = {"ATGCAA","CGATGC","TTATCT","AGAAGG","CAGCTA","TCACTG"};
		return dna;
	}
	
	private String[] dnaMutantA() 
	{
		String[] dna = {"ATTTTA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCGGGG"};
		return dna;
	}
	
	private String[] dnaMutantB() 
	{
		String[] dna = {"ATCTAA","CACTAC","TAGTAT","AACGAG","CACGGA","TCGGGG"};
		return dna;
	}	
}
