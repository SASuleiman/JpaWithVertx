package org.suleiman.DataJpaWithVertx.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.suleiman.DataJpaWithVertx.Entity.Workstation;

@Repository
public interface WorkstationRepo extends JpaRepository<Workstation,Long> {

    Workstation findBySerialNumber(String serialNumber);

}
