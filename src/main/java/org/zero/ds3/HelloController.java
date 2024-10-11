package org.zero.ds3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Controller;
import org.zero.ds3.repository.ResidentRepository;
import org.zero.ds3.utils.MyFunction;

@Controller
public class HelloController {

    private final ResidentRepository residentRepository;


    public HelloController(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        System.out.println(residentRepository.findById(1).get().getName());
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}