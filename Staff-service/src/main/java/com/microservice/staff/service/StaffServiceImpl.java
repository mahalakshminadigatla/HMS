package com.microservice.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.staff.entity.Staff;
import com.microservice.staff.repository.StaffRepository;

@Service
public class StaffServiceImpl {

	@Autowired
	private StaffRepository staffRepository;
	
	
	public void addStaff(Staff staff) {
		staffRepository.save(staff);
	}

	
	public List<Staff> getAllStaff() {
		return staffRepository.findAll();
	}

	
	public Optional<Staff> getStaffById(long staffId) {
		return staffRepository.findById(staffId);
	}

	
	public void updateStaff(long staffId, Staff staff) {
		staffRepository.save(staff);
	}

	
	public void deleteStaff(long staffId) {
		staffRepository.deleteById(staffId);
	}

	
	public List<Staff> getStaffByName(String staffName) {
		return staffRepository.findByStaffName(staffName);
	}
	
}
