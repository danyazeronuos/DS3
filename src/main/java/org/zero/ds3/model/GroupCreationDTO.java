package org.zero.ds3.model;

import org.zero.ds3.entity.City;
import org.zero.ds3.entity.Resident;

import java.util.List;

public record GroupCreationDTO(
    List<City> cityList,
    List<Resident> residentList
){}
