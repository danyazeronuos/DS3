package org.zero.ds3.utils;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import org.zero.ds3.entity.City;
import org.zero.ds3.entity.Language;
import org.zero.ds3.entity.Resident;
import org.zero.ds3.model.Dialog;
import org.zero.ds3.model.ResidentCreationDTO;

import java.util.List;
import java.util.Objects;


public class CreateResidentDialog extends Dialog<Resident> {
    private final List<City> cityList;
    private final List<Language> languageList;
    private final FieldsValueHandler fieldsValueHandler = new FieldsValueHandler();

    public CreateResidentDialog(ResidentCreationDTO residentCreationDataDTO) {
        this.cityList = residentCreationDataDTO.cityList();
        this.languageList = residentCreationDataDTO.languageList();
    }

    @Override
    protected GridPane getDialogPane() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField residentName = new TextField();
        residentName.setPromptText("Resident Name");
        gridPane.add(residentName, 0, 0);
        fieldsValueHandler.addField("name", residentName);

        ComboBox<String> languageComboBox = new ComboBox<>(
                FXCollections.observableArrayList(
                        languageList
                                .stream().map(Language::getTitle)
                                .toList()
                ));
        languageComboBox.setPromptText("Language");
        gridPane.add(languageComboBox, 1, 0);
        fieldsValueHandler.addField("language", languageComboBox);

        ComboBox<String> cityComboBox = new ComboBox<>(
                FXCollections.observableArrayList(
                        cityList
                                .stream().map(City::getName)
                                .toList()
                )
        );
        cityComboBox.setPromptText("City");
        gridPane.add(cityComboBox, 0, 1);
        fieldsValueHandler.addField("city", cityComboBox);

        return gridPane;
    }

    @Override
    protected Callback<ButtonType, Resident> getResultConverter() {
        return buttonType -> {
            if (buttonType == ButtonType.OK) {

                var resident = new Resident();
                resident.setName((String) fieldsValueHandler
                        .getFieldValue("name"));

                String cityTitle = (String) fieldsValueHandler
                        .getFieldValue("city");

                City city = cityList.stream()
                        .filter(element -> Objects.equals(element.getName(), cityTitle))
                        .findFirst()
                        .orElse(null);

                resident.setCity(city);

                String languageTitle = (String) fieldsValueHandler
                        .getFieldValue("language");
                Language language = languageList.stream()
                        .filter(element -> element.getTitle().equals(languageTitle))
                        .findFirst()
                        .orElse(null);
                resident.setLanguage(language);

                return resident;
            }
            return null;
        };
    }
}
