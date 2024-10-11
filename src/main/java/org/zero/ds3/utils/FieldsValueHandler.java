package org.zero.ds3.utils;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;

@Component
public class FieldsValueHandler {
    private final HashMap<String, Object> fields = new HashMap<>();

    public void addField(String fieldName, Object fieldValue) {
        fields.put(fieldName, fieldValue);
    }

    public Object getFieldValue(String fieldName) {

        return extractFieldValue(fields.get(fieldName));
    }

    private Object extractFieldValue(Object object) {
        if (object == null) return null;

        if (object instanceof TextField textField) return textField.getText();
        if (object instanceof ComboBox comboBox) return comboBox.getValue();
        return object;
    }
}
