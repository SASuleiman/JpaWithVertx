package org.suleiman.DataJpaWithVertx.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.suleiman.DataJpaWithVertx.Entity.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long> {

}
