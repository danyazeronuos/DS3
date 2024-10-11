package org.zero.ds3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zero.ds3.entity.City;
import org.zero.ds3.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
