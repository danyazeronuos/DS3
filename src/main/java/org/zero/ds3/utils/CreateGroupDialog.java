package org.zero.ds3.utils;

import javafx.collections.FXCollections;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import org.springframework.stereotype.Component;
import org.zero.ds3.entity.City;
import org.zero.ds3.entity.CityResident;
import org.zero.ds3.entity.Resident;
import org.zero.ds3.model.Dialog;
import org.zero.ds3.model.GroupCreationDTO;
import org.zero.ds3.repository.CityRepository;
import org.zero.ds3.repository.ResidentRepository;

import java.util.List;

public class CreateGroupDialog  extends Dialog<CityResident> {
    private final List<City> cityList;
    private final List<Resident> residentList;
    private final FieldsValueHandler fieldsValueHandler = new FieldsValueHandler();

    public CreateGroupDialog(GroupCreationDTO groupCreationDTO) {
        this.residentList = groupCreationDTO.residentList();
        this.cityList = groupCreationDTO.cityList();
    }



    @Override
    protected GridPane getDialogPane() {
        var gridPane = new GridPane();

        var residentComboBox = new ComboBox<String>(FXCollections.observableArrayList(
                residentList.stream().map(Resident::getName).toList()
        ));
        residentComboBox.setPromptText("Resident");
        gridPane.add(residentComboBox, 0, 0);
        fieldsValueHandler.addField("resident", residentComboBox);

        var cityComboBox = new ComboBox<String>(FXCollections.observableArrayList(
                cityList.stream().map(City::getName).toList()
        ));
        cityComboBox.setPromptText("City");
        gridPane.add(cityComboBox, 0, 1);
        fieldsValueHandler.addField("city", cityComboBox);

        var appearanceTextField = new TextField();
        appearanceTextField.setPromptText("Appearance");
        gridPane.add(appearanceTextField, 0, 2);
        fieldsValueHandler.addField("appearance", appearanceTextField);

        return gridPane;
    }

    @Override
    protected Callback<ButtonType, CityResident> getResultConverter() {
        return buttonType -> {
            if (buttonType == ButtonType.OK) {

                var residentTitle = (String) fieldsValueHandler.getFieldValue("resident");
                var resident = residentList.stream()
                        .filter(r -> r.getName().equals(residentTitle))
                        .findFirst()
                        .orElse(null);

                var cityTitle = (String) fieldsValueHandler.getFieldValue("city");
                var city = cityList.stream()
                        .filter(r -> r.getName().equals(cityTitle))
                        .findFirst()
                        .orElse(null);

                var appearedTitle = Short.parseShort((String) fieldsValueHandler.getFieldValue("appearance"));

                var result = new CityResident();
                result.setResident(resident);
                result.setCity(city);
                result.setAppeared(appearedTitle);
                return result;
            }
            return null;
        };
    }
}
