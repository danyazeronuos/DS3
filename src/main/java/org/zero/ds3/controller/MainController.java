package org.zero.ds3.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.zero.ds3.entity.City;
import org.zero.ds3.entity.Resident;
import org.zero.ds3.service.CityService;
import org.zero.ds3.service.GroupService;
import org.zero.ds3.service.ResidentService;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CityService cityService;
    private final GroupService groupService;
    private final ResidentService residentService;

    @FXML
    public ListView<City> cityList;

    @FXML
    public ListView<Resident> residents;

    @FXML
    public void initialize() {
        cityList.setItems(
                FXCollections.observableArrayList(
                        cityService.getCityList()
                )
        );

        residents.setItems(
                FXCollections.observableArrayList(
                        residentService.getResidentList()
                )
        );
    }

    @FXML
    protected void onResidentCreateButtonClick(ActionEvent actionEvent) {
        residentService.createResident();
    }

    @FXML
    protected void onCityCreateButtonClick(ActionEvent actionEvent) {
        cityService.createCity();
    }

    @FXML
    protected void onGroupCreateButtonClick(ActionEvent actionEvent) {
        groupService.createGroup();
    }
}