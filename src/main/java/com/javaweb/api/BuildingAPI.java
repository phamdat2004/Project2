package com.javaweb.api;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;
import com.javaweb.service.impl.BuildingServiceImpl;

import org.springframework.*;
@RestController
public class BuildingAPI {

	@Autowired
	private BuildingServiceImpl bi;
	
	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam (value="name", required = false) String namee,
										@RequestParam (value="districtId", required = false) Long districtIdd,
										@RequestParam (value="typeCode", required = false) List<String> c) {
		List<BuildingDTO> listt = bi.getBuilding(namee, districtIdd);
				
								
		return listt;
	}
	
	
		
	
	
	
	
	
	
	@PostMapping(value="/api/building/")
	public BuildingDTO getBuilding2(@RequestBody BuildingDTO buildingDTO) {
		return buildingDTO;
	}
}
