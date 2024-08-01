package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        
        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("Login successful");
            
        } else {
            System.out.println("Login failed");
        }
    }
}
