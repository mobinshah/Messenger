import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    Button btnexit;
    @FXML
    Button btnlogin;
    @FXML
    Button btnsignup;
    @FXML
    TextField txtfusername ;
    @FXML
    TextField txtfpassword ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnlogin.setOnAction(event -> {
            {
              String username = txtfusername.getText();
              String password = txtfpassword.getText();



            }
        });
        btnsignup.setOnAction(event -> {
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("SingUp.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnexit.setOnAction(event -> {
            System.exit(0);
        });

    }
}
