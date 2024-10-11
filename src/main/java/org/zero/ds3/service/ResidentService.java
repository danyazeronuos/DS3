package org.zero.ds3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zero.ds3.entity.Resident;
import org.zero.ds3.model.ResidentCreationDTO;
import org.zero.ds3.repository.CityRepository;
import org.zero.ds3.repository.LanguageRepository;
import org.zero.ds3.repository.ResidentRepository;
import org.zero.ds3.utils.CreateResidentDialog;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentService {
    private final CityRepository cityRepository;
    private final ResidentRepository residentRepository;
    private final LanguageRepository languageRepository;

    public void createResident() {
        var dialogConstructor = new CreateResidentDialog(this.getResidentCreationData());
        var newResident = dialogConstructor.init("Create Resident");
        newResident.ifPresent(residentRepository::save);
    }

    public List<Resident> getResidentList() {
        return residentRepository.findAll();
    }

    private ResidentCreationDTO getResidentCreationData() {
        return new ResidentCreationDTO(
                cityRepository.findAll(),
                languageRepository.findAll()
        );
    }
}
