package com.magneto.analyzer.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ChainDNATest 
{

	@Test
	void testCheckIsNitrogenBaseOk() 
	{
		ChainDNA chain = new ChainDNA(0);
		try 
		{
			assertTrue(chain.checkIsNitrogenBase('T'));		
			assertTrue(chain.checkIsNitrogenBase('A'));		
			assertTrue(chain.checkIsNitrogenBase('C'));		
			assertTrue(chain.checkIsNitrogenBase('G'));		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	void testCheckIsNitrogenBasefail() 
	{
		ChainDNA chain = new ChainDNA(0);

	    Exception exception = assertThrows(
	    		Exception.class, 
	    		() -> { chain.checkIsNitrogenBase('X'); }
	    	);
		String expected = "El valor recibido 'X' no es una base nitrogenada.";
		assertEquals(expected, exception.getMessage());		
	}
	
	@Test
	void testAddFail() throws Exception 
	{
		ChainDNA chain = new ChainDNA(0);
		ArrayIndexOutOfBoundsException exception = assertThrows(
				ArrayIndexOutOfBoundsException.class, 
				() -> {chain.add('A');}
			);
		String expected = "Index 0 out of bounds for length 0";
		assertEquals(expected, exception.getMessage());
	}
	
	
	@Test
	void testAddOk() throws Exception 
	{
		ChainDNA chainDNA = new ChainDNA(4);
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('A');
		
		boolean response = true;
		char[] innerChain = chainDNA.getChain();
		for(int index=0; index < innerChain.length; index++) 
		{
			response &= (innerChain[index] == 'A');
		}
		
		assertTrue(response);
	}

	@Test
	void testExistsMutantSequenceOk1() throws Exception 
	{
		ChainDNA chainDNA = new ChainDNA(6);
		chainDNA.add('T');
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('C');
		assertTrue(chainDNA.existsMutantSequence());
	}

	@Test
	void testExistsMutantSequenceOk2() throws Exception 
	{
		ChainDNA chainDNA = new ChainDNA(6);
		chainDNA.add('T');
		chainDNA.add('G');
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('A');
		assertTrue(chainDNA.existsMutantSequence());
	}

	@Test
	void testExistsMutantSequenceOk3() throws Exception 
	{
		ChainDNA chainDNA = new ChainDNA(5);
		chainDNA.add('T');
		chainDNA.add('T');
		chainDNA.add('T');
		chainDNA.add('T');
		chainDNA.add('A');
		assertTrue(chainDNA.existsMutantSequence());
	}

	@Test
	void testExistsMutantSequenceFail() throws Exception 
	{
		ChainDNA chainDNA = new ChainDNA(6);
		chainDNA.add('T');
		chainDNA.add('G');
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('A');
		chainDNA.add('C');
		assertFalse(chainDNA.existsMutantSequence());
	}
}
