package org.suleiman.DataJpaWithVertx.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.suleiman.DataJpaWithVertx.Entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

}
