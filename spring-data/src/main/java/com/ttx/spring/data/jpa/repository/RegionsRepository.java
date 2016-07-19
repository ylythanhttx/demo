package com.ttx.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ttx.spring.data.jpa.entity.hr.Regions;

public interface RegionsRepository extends CrudRepository<Regions, Long> {

	/**
	 * Test @Query
	 * 
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from Regions")
	List<Regions> lstRegions();

	/**
	 * Test NameQuery
	 * 
	 * @param id
	 * @return
	 */
	// Regions findByIdTestNameQuery(Long regionId);
}
