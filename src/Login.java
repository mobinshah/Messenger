import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
@FXML
    Button btnexit;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
btnexit.setOnAction(event -> {
    System.exit(0);
});
    }
}
