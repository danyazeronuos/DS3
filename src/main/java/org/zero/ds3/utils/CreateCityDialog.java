package org.zero.ds3.utils;

import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zero.ds3.entity.City;
import org.zero.ds3.model.Dialog;

@Component
public class CreateCityDialog extends Dialog<City> {
    private final FieldsValueHandler fieldsValueHandler = new FieldsValueHandler();

    @Override
    protected GridPane getDialogPane() {
        var gridPane = new GridPane();

        TextField foundationYear = new TextField();
        foundationYear.setPromptText("Foundation Year");
        gridPane.add(foundationYear, 1, 0);
        fieldsValueHandler.addField("foundationYear", foundationYear);

        TextField cityName = new TextField();
        cityName.setPromptText("City Name");
        gridPane.add(cityName, 1, 1);
        fieldsValueHandler.addField("cityName", cityName);

        TextField cityArea  = new TextField();
        cityArea.setPromptText("City Area");
        gridPane.add(cityArea, 1, 2);
        fieldsValueHandler.addField("cityArea", cityArea);

        return gridPane;
    }

    @Override
    protected Callback<ButtonType, City> getResultConverter() {
        return buttonType -> {
            if (buttonType == ButtonType.OK) {
                var city = new City();

                var cityName = (String) fieldsValueHandler.getFieldValue("cityName");
                var foundationYear = Short.valueOf((String) fieldsValueHandler.getFieldValue("foundationYear"));
                var cityArea = Short.valueOf((String) fieldsValueHandler.getFieldValue("cityArea"));

                city.setFoundationYear(foundationYear);
                city.setArea(cityArea);
                city.setName(cityName);

                return city;
            }

            return null;
        };
    }
}
