package com.microservice.staff;

import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservice.staff.entity.Staff;
import com.microservice.staff.repository.StaffRepository;
import com.microservice.staff.service.StaffServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class StaffServiceApplicationTests {

	@Autowired
	private StaffServiceImpl staffService;
	
	@MockBean
	private StaffRepository staffRepository;

	@Test
	public void addStaffTest() {
		Staff staff=new Staff(1,"Asim",11500,"asim@gmail.com");
		staffService.addStaff(staff);
		verify(staffRepository,times(1)).save(staff);
	}
	
	@Test
	public void getAllStaffTest() {
		when(staffRepository.findAll()).thenReturn(Stream
				.of(new Staff(1,"Asim",11500,"asim@gmail.com"))
				.collect(Collectors.toList()));
		assertEquals(2,staffService.getAllStaff().size());
	}
	
	@Test
	public void updateStaffTest() {
		long rNum =1;
		Staff staff =new Staff(1,"Asim",11500,"asim@gmail.com");
		staffService.updateStaff(rNum, staff);
		verify(staffRepository, times(1)).save(staff);
	}
	
	@Test
	public void deleteStaffTest() {
		long rNum =1;
		staffService.deleteStaff(rNum);
		verify(staffRepository, times(1)).deleteById(rNum);
	}
	
}
