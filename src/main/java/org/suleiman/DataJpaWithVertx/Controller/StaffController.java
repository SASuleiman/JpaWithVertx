package org.suleiman.DataJpaWithVertx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suleiman.DataJpaWithVertx.Entity.Staff;
import org.suleiman.DataJpaWithVertx.Services.StaffService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }


}
