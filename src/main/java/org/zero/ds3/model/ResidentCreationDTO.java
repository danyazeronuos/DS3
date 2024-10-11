package org.zero.ds3.model;

import org.zero.ds3.entity.City;
import org.zero.ds3.entity.Language;

import java.util.List;

public record ResidentCreationDTO(
        List<City> cityList,
        List<Language> languageList
) {
}
