package com.magneto.analyzer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magneto.analyzer.entity.DNA;

@Repository
public interface DNARepository extends CrudRepository<DNA, Long> 
{	
	long count();
	
	long countByIsMutantTrue();
	
	long countByIsMutantFalse();
}
