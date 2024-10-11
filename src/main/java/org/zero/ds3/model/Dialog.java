package org.zero.ds3.model;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.Optional;

public abstract class Dialog<T> {
    javafx.scene.control.Dialog<T> dialog = new javafx.scene.control.Dialog<T>();

    abstract protected GridPane getDialogPane();

    Optional<T> render(String title) {
        dialog.setTitle(title);
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);

        dialog.getDialogPane().setContent(this.getDialogPane());
        dialog.setResultConverter(this.getResultConverter());

        return dialog.showAndWait();
    }

    abstract protected Callback<ButtonType, T> getResultConverter();

}
