package com.ttx.spring.data;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ttx.spring.data.jpa.dao.RegionsDaoImpl;
import com.ttx.spring.data.jpa.dao.RegionsDaoImpl.RegionDTOs;
import com.ttx.spring.data.jpa.entity.hr.Regions;
import com.ttx.spring.data.jpa.repository.RegionsRepository;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/spring-datasource.xml");
		RegionsDaoImpl employeesDaoImpl = (RegionsDaoImpl) context.getBean("regionsDaoImpl");

		/**
		 * C
		 */
		employeesDaoImpl.createRegions(new RegionDTOs(5l, "MienTrung"));
		/**
		 * R
		 */
		Regions regions = employeesDaoImpl.getRegions(1l);
		System.out.println(regions.getRegionName());
		// Regions regionsNameQuery =
		// employeesDaoImpl.findByIdTestNameQuery(1l);
		// System.out.println(regionsNameQuery.getRegionName());
		List<Regions> lstRegions = employeesDaoImpl.getLstRegions();
		System.out.println(lstRegions.size());
		/**
		 * U
		 */
		// employeesDaoImpl.updateRegions(new RegionDTOs(5l,
		// regions.getRegionName()+1));

		/**
		 * D
		 */
		// employeesDaoImpl.deleteRegions(5l);

		RegionsRepository regionsRepository = context.getBean(RegionsRepository.class);
		System.out.println(regionsRepository.getClass());

		System.out.println("===================================================================");
	}
}
