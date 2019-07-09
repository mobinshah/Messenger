import com.sun.corba.se.spi.activation.Server;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Chatroom implements Initializable {
    @FXML
    Button btnSend ;
    @FXML
    Button btnEmoji ;
    @FXML
    Button btnInformation ;
    @FXML
    Button btnFile ;
    @FXML
    Button btnSetting ;
    @FXML
    TextField txtfMessege ;
    @FXML
    TextArea txta ;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
btnSetting.setOnAction(event -> {
    try {
        server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("setting.fxml"))));
    } catch (IOException e) {
        e.printStackTrace();
    }
});


btnFile.setOnAction(event -> {
    FileChooser fileChooser = new FileChooser();
    File selectedFile = fileChooser.showOpenDialog(null);
});
    }
}
