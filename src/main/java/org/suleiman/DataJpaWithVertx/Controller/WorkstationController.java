package org.suleiman.DataJpaWithVertx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.suleiman.DataJpaWithVertx.Entity.Workstation;
import org.suleiman.DataJpaWithVertx.Services.WorkstationService;

import java.util.List;

@RestController
@RequestMapping(value  = "/workstation")
public class WorkstationController {

    @Autowired
    WorkstationService workstationService;

    @GetMapping
    public List<Workstation> getAllWorkstation() {
    return workstationService.getAllWorkStation();
    }

    @PostMapping
    public Workstation addWorkstation(@RequestBody Workstation workstation) {
        return workstationService.addWorkstation(workstation);
    }

    @PutMapping
    public Workstation updateWorkstation(@RequestBody Workstation workstation) {
        return workstationService.updateWorkstation(workstation);
    }

    @DeleteMapping
    public String deleteWorkstation(@RequestBody Workstation workstation) {
        return  workstationService.deleteWorkstation(workstation.getSerialNumber());
    }
}
