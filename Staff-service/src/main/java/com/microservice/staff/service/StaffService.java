package com.microservice.staff.service;


import com.microservice.staff.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StaffService {
    void addStaff(Staff staff);
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(long staffId);
    void updateStaff(long staffId,Staff staff);

    void deleteStaff(long staffId);

}
