package org.suleiman.DataJpaWithVertx.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.suleiman.DataJpaWithVertx.Entity.Staff;
import org.suleiman.DataJpaWithVertx.Repositories.StaffRepo;

import java.util.List;
import java.util.Optional;

@Service 
public class StaffService {
    @Autowired
    StaffRepo staffRepo; 
    
    public List<Staff> getAllStaff() {
       return staffRepo.findAll(); 
    }
    
    public Staff addStaff(Staff staff) {
//    staffRepo.findById(staff.getStaffId()).ifPresent((s) -> new IllegalArgumentException(s.toString() + " already exists in the dataBase"));
    staffRepo.save(staff); 
    return  staff; 
    }
    

    public String deleteStaff(Staff staff) {
        staffRepo.findById(staff.getStaffId()).ifPresent((s) -> new IllegalArgumentException(s.toString() + " already exists in the dataBase"));
        staffRepo.deleteById(staff.getStaffId());
        return " the staff has successfully been deleted from the database ";
    }
    @Transactional
    public Staff updateStaff(Staff staff) {
        staffRepo.findById(staff.getStaffId()).ifPresent((s) -> new IllegalArgumentException(s.toString() + " already exists in the dataBase"));
         staffRepo.findById(staff.getStaffId()).ifPresent((s) -> {
             s.setDependent(staff.getDependent());
//             s.setDepartment(staff.getDepartment());
             s.setName(staff.getName());
             s.setSkill(staff.getSkill());
             s.setSalary(staff.getSalary());
//             s.setWorkstation(staff.getWorkstation());

         });
         return staff;
    }
}
