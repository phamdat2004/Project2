package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.impl.BuildingRepositoryImply;
import com.javaweb.service.BuildingService;
@Service
public class BuildingServiceImpl {
	@Autowired
	private BuildingRepositoryImply br;
	
	
	
	
	public List<BuildingDTO> getBuilding(String namee, Long districtIdd) {
		List<BuildingEntity> buildingEntities = br.getBuilding(namee, districtIdd);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		// TODO Auto-generated method stub
		for(BuildingEntity x : buildingEntities) {
			BuildingDTO bd = new BuildingDTO();
			bd.setName(x.getName());
			bd.setAddress(x.getStreet()+","+x.getWard());
			bd.setNumberOfBasement(x.getNumberOfBasement());
			result.add(bd);
		}
		return result;
	}




}
