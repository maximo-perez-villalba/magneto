package com.magneto.analyzer.core;

public class ChainDNA 
{

	private int sequenceLenght;
	private char[] chain;
	
	public ChainDNA(int chainLenght) 
	{
		this.chain = new char[chainLenght];
		this.sequenceLenght = 4;
	}
	
	public ChainDNA(int chainLenght, int sequenceLenght ) 
	{
		this.chain = new char[chainLenght];
		this.sequenceLenght = sequenceLenght;
	}

	public void add(char aNitrogenBase) throws Exception 
	{
		this.checkIsNitrogenBase(aNitrogenBase);
		this.chain[this.chain.length] = aNitrogenBase;
	} 
	
	private boolean checkIsNitrogenBase(char aNitrogenBaseValue) throws Exception
	{
		boolean isNitrogenBase = aNitrogenBaseValue == 'T';
		isNitrogenBase |= aNitrogenBaseValue == 'A';
		isNitrogenBase |= aNitrogenBaseValue == 'C';
		isNitrogenBase |= aNitrogenBaseValue == 'G';
		
		if(!isNitrogenBase)
		{
			throw new Exception("El valor recibido '"+aNitrogenBaseValue+"' no es una base nitrogenada.");
		}
		return true;
	}
	
	/**
	 * El método verifica si existe la secuencia mutante en la cadena de ADN. 
	 * @return boolean
	 */
	public boolean existsMutantSequence() 
	{
		int range = this.chain.length - this.sequenceLenght; 
		
		boolean exist = false;
		for(int index = 0; index <= range && !exist; index++ ) 
		{
			exist = this.chain[index] == this.chain[index+1];
			exist &= this.chain[index] == this.chain[index+2];
			exist &= this.chain[index] == this.chain[index+3];
		}
		return exist;
	}

}
