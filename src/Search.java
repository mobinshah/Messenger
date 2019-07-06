import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {
    @FXML
    Button btnSearch ;
    @FXML
    Button btnBack ;
    @FXML
    Button btnExit ;
    @FXML
    TextField txtfSearch ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       btnSearch.setOnAction(event -> {
           String Search = txtfSearch.getText();
           try {
               server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("chatroom.fxml"))));
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
