package org.suleiman.DataJpaWithVertx.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.suleiman.DataJpaWithVertx.Entity.Department;
import org.suleiman.DataJpaWithVertx.Repositories.DepartmentRepo;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    public Department addDepartment(Department department) {
        departmentRepo.save(department);
        return department;
    }

    @Transactional
    public Department updateDepartment(Department department) {
        boolean isPresent = departmentRepo.findById(department.getDepartmentId()).isPresent();

        if(!isPresent) {
            throw new IllegalArgumentException("the id of the input that is entered does not exist");
        }
        Department fetchedDepartment = departmentRepo.getReferenceById(department.getDepartmentId());
        fetchedDepartment.setDepartmentName(department.getDepartmentName());
        fetchedDepartment.setBuilding(department.getBuilding());
        return department;
    }

    public String deleteDepartment(Department department) {
//        departmentRepo.findById(department.getDepartmentId()).orElseThrow(IllegalArgumentException::new);
         departmentRepo.findById(department.getDepartmentId()).orElseThrow(() -> new IllegalArgumentException("the department you entered does not exist"));
         departmentRepo.deleteById(department.getDepartmentId());
         return "The Department has successfully been deleted form the database";
    }
}
//61737138