package org.zero.ds3.model;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.Optional;

public abstract class Dialog<T> {
    javafx.scene.control.Dialog<T> dialog;

    abstract protected GridPane getDialogPane();

    public Optional<T> init(String title) {
        dialog = new javafx.scene.control.Dialog<>();
        dialog.setTitle(title);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        dialog.getDialogPane().setContent(this.getDialogPane());
        dialog.setResultConverter(this.getResultConverter());

        return dialog.showAndWait();
    }

    abstract protected Callback<ButtonType, T> getResultConverter();

}
