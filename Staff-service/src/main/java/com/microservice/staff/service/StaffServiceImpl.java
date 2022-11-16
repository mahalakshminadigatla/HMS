package com.microservice.staff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.staff.entity.Staff;
import com.microservice.staff.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.microservice.staff.entity.Staff.SEQUENCE_NAME;


@Service
public class StaffServiceImpl {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	public SequenceGeneratorService sequenceGeneratorService;


	public void addStaff(Staff staff) {
		staff.setStaffId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
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
