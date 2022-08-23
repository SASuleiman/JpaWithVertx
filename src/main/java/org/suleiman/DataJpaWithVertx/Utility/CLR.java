package org.suleiman.DataJpaWithVertx.Utility;

import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.suleiman.DataJpaWithVertx.Entity.Department;
import org.suleiman.DataJpaWithVertx.Entity.Dependent;
import org.suleiman.DataJpaWithVertx.Entity.Staff;
import org.suleiman.DataJpaWithVertx.Entity.Workstation;
import org.suleiman.DataJpaWithVertx.Repositories.DepartmentRepo;
import org.suleiman.DataJpaWithVertx.Repositories.StaffRepo;
import org.suleiman.DataJpaWithVertx.Repositories.WorkstationRepo;

@Component
public class CLR implements CommandLineRunner {

    @Autowired
    WorkstationRepo workstationRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    StaffRepo staffRepo;

    @Override
    public void run(String... args) throws Exception {
//
//
      Department d2 = new Department();
      d2.setBuilding("Building-5");
      d2.setDepartmentName("Paytoken");
      departmentRepo.save(d2);
//
//
        Staff s1 = new Staff();
        s1.setName("Jakob Smith");
        s1.setSalary(9000000L);
        s1.setSkill(Skill.DEVOPS.name());
        s1.setDependent(new Dependent("James Smith","Brother"));
//        s1.setWorkstation(workstationRepo.findBySerialNumber("11222222222"));
//        s1.setDepartment(departmentRepo.getReferenceById(1L));
        staffRepo.save(s1);

//
        Workstation w2= new Workstation();
        w2.setWorkstationId(1L);
        w2.setManufacturer("MSI");
        w2.setSerialNumber("11222222222");
        w2.setDevice(Device.LAPTOP.name());
//        w2.setStaff(staffRepo.getReferenceById(2L));
        workstationRepo.save(w2);
//
//

    }
}
