import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SingUp implements Initializable {
    @FXML
    Button btnBack ;
    @FXML
    Button btnNext ;
    @FXML
    Button btnExit ;
    @FXML
    TextField txtfFirstname;
    @FXML
    TextField txtfLastname ;
    @FXML
    TextField txtfEmail ;
    @FXML
    TextField txtfUsername ;
    @FXML
    TextField txtfPassword ;
    @FXML
    Button btnPhoto ;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    btnNext.setOnAction(event -> {
        String firstname = txtfFirstname.getText();
        String lastname = txtfLastname.getText();
        String Email = txtfEmail.getText();
        String username= txtfUsername.getText();
        try {
            server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
        btnBack.setOnAction(event -> {
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("login.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnExit.setOnAction(event -> {

            System.exit(0);
        });

    }
}
