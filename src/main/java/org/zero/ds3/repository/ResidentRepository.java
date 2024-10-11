package org.zero.ds3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zero.ds3.entity.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
}
