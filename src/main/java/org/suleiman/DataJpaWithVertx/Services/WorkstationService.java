package org.suleiman.DataJpaWithVertx.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.suleiman.DataJpaWithVertx.Entity.Workstation;
import org.suleiman.DataJpaWithVertx.Repositories.WorkstationRepo;

import java.util.List;
import java.util.Optional;

@Service
public class WorkstationService {
    @Autowired
    WorkstationRepo workstationRepo;

    public List<Workstation> getAllWorkStation() {
        return workstationRepo.findAll();
    }

    public Workstation addWorkstation(Workstation workstation) {
        boolean isPresent = workStationExists(workstation.getSerialNumber());
      if(isPresent) {
          throw new IllegalArgumentException("The manufacturer serial number already exists");
      }
      workstationRepo.save(workstation);
      return workstation;
    }

    public String deleteWorkstation(String serialNumber) {
        boolean isPresent = workStationExists(serialNumber);
        if(!isPresent) {
            throw new IllegalArgumentException("The workstation you are trying to delete does not exist");
        }
        Workstation selectedWorkstation = workstationRepo.findBySerialNumber(serialNumber);
        workstationRepo.deleteById(selectedWorkstation.getWorkstationId());
        return "the workstation has successfully been deleted from the database";
    }

    @Transactional
    public Workstation updateWorkstation(Workstation workstation) {
        boolean isPresent = workstationRepo.existsById(workstation.getWorkstationId());
        if(!isPresent) {
            throw new IllegalArgumentException("the workstation serial number does not exist in the data base");
        }
        workstationRepo.findById(workstation.getWorkstationId()).ifPresent(ws -> {
            ws.setManufacturer(workstation.getManufacturer());
            ws.setSerialNumber(workstation.getSerialNumber());
        });

        return workstation;
    }

    private boolean workStationExists(String serialNumber) {
        return Optional.ofNullable(workstationRepo.findBySerialNumber(serialNumber)).isPresent();
    }
}
