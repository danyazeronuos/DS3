package org.zero.ds3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zero.ds3.entity.City;
import org.zero.ds3.repository.CityRepository;
import org.zero.ds3.utils.CreateCityDialog;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public void createCity() {
        var dialogConstructor = new CreateCityDialog();
        var newCity = dialogConstructor.init("Create City");
        newCity.ifPresent(cityRepository::save);
    }

    public List<City> getCityList() {
        return cityRepository.findAll();
    }
}
