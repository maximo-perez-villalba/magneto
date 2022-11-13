package com.magneto.analyzer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dnas")
public class DNA implements Serializable
{
	
	private static final long serialVersionUID = 2685001126703069193L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String sequences;
	
	@Column(name = "is_mutant")
	private Boolean isMutant;
	
	public DNA() {}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getSequences() 
	{
		return sequences;
	}

	public void setSequences(String sequences) 
	{
		this.sequences = sequences;
	}

	public Boolean getIsMutant() 
	{
		return isMutant;
	}

	public void setIsMutant(Boolean isMutant) 
	{
		this.isMutant = isMutant;
	}

}
