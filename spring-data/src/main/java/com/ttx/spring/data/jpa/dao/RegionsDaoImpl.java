package com.ttx.spring.data.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ttx.spring.data.jpa.entity.hr.Regions;
import com.ttx.spring.data.jpa.repository.RegionsRepository;

/**
 * Demo CRUD
 * 
 * @author thanh
 *
 */

@Component("regionsDaoImpl")
public class RegionsDaoImpl {

	@Autowired
	RegionsRepository regionsRepository;

	/**
	 * C
	 */
	public void createRegions(RegionDTOs regionDTOs) {

		Regions regions = new Regions();
		regions.setRegionName(regionDTOs.getRegionName());
		regions.setRegionId(regionDTOs.getRegionId());
		regionsRepository.save(regions);
	}

	/**
	 * R
	 */
	public Regions getRegions(Long id) {
		return regionsRepository.findOne(id);
	}

	/**
	 * R
	 */
	// public Regions findByIdTestNameQuery(Long id) {
	// return regionsRepository.findByIdTestNameQuery(id);
	// }

	/**
	 * R
	 */
	public List<Regions> getLstRegions() {
		return regionsRepository.lstRegions();
	}

	/**
	 * U
	 */
	public void updateRegions(RegionDTOs regionDTOs) {
		Regions regions = regionsRepository.findOne(regionDTOs.getRegionId());
		regions.setRegionName(regionDTOs.getRegionName());
		regionsRepository.save(regions);
	}

	/**
	 * D
	 */
	public void deleteRegions(Long id) {
		Regions regions = regionsRepository.findOne(id);
		if (regions != null) {
			regionsRepository.delete(regions);
		}
	}

	public static class RegionDTOs implements java.io.Serializable {

		private Long regionId;
		private String regionName;

		public RegionDTOs() {
		}

		public RegionDTOs(Long regionId) {
			this.regionId = regionId;
		}

		public RegionDTOs(Long regionId, String regionName) {
			this.regionId = regionId;
			this.regionName = regionName;
		}

		public Long getRegionId() {
			return this.regionId;
		}

		public void setRegionId(Long regionId) {
			this.regionId = regionId;
		}

		public String getRegionName() {
			return this.regionName;
		}

		public void setRegionName(String regionName) {
			this.regionName = regionName;
		}
	}
}
