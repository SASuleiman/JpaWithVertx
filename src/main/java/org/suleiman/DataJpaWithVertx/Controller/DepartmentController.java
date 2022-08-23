package org.suleiman.DataJpaWithVertx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suleiman.DataJpaWithVertx.Entity.Department;
import org.suleiman.DataJpaWithVertx.Services.DepartmentService;

import java.util.List;

@RestController
@RequestMapping(value = "department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department>  getAllDepartment() {
        return departmentService.getAllDepartment();
    }

}
