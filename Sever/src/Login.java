import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    @FXML
    Text txt;
    public static String username;
    public static String password;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        final String secretKey = "Salam";



        btnlogin.setOnAction(event -> {
            {
            username  = txtfusername.getText();

               password = txtfpassword.getText();
                try {

                    pesonDB pesonDB = new pesonDB();
                    ArrayList<String> person1 = new ArrayList<>();
                    person1 = pesonDB.getPerson(username);
//                    if (username.equals(person1.get(0))) {
                        if (password.equals(AES.decrypt(person1.get(1), secretKey))) {
                            server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
                        }else{
                            if (!password.equals(AES.decrypt(person1.get(1), secretKey))){
                                txt.setText("information does not exist ");
                            }

                        }
//                    }
                }


                 catch (Exception e) {
                    e.printStackTrace();
                }


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
