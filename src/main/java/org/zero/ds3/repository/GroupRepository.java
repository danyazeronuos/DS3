package org.zero.ds3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zero.ds3.entity.CityResident;

public interface GroupRepository extends JpaRepository<CityResident, Integer> {
}
