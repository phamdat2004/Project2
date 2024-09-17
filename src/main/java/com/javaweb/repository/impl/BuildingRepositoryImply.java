package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImply {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estateadvance";
	static final String USER = "root";
	static final String PASS = "2172004";
	
	public List<BuildingEntity> getBuilding(String name, Long districtId) {
		List<BuildingEntity> list = new ArrayList<BuildingEntity>();
		try {
			Connection c = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st =  c.createStatement();
			StringBuilder sql = new StringBuilder("SELECT * FROM building b where 1=1");
			if(name!=null && name.equals("")) {
				sql.append("and b.name like '%"+name+"%'");
			}
			if(districtId!=null) {
				sql.append("and b.districtId = "+districtId+" ");
			}
			ResultSet rs =  st.executeQuery(sql.toString());
			while(rs.next()) {
				String namee = rs.getString("name");
				Integer number = rs.getInt("numberofbasement");
				String ward = rs.getString("ward");
				String street = rs.getString("street");
				BuildingEntity bd = new BuildingEntity(namee, number, ward, street);
				list.add(bd);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
