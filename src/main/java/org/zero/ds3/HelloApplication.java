package org.zero.ds3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zero.ds3.config.DatabaseConfig;
import org.zero.ds3.config.SpringConfig;

import java.io.IOException;

public class HelloApplication extends Application {
    private ApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class, DatabaseConfig.class);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}