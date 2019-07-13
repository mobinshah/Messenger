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
    @FXML
    Text txt ;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    btnNext.setOnAction(event -> {
        String firstname = txtfFirstname.getText();
//        System.out.println(firstname);
        String lastname = txtfLastname.getText();
        String Email = txtfEmail.getText();
        String username = txtfUsername.getText();
        String pass = txtfPassword.getText();
        User user = new User(username, pass,firstname,lastname,Email);
        try {
            ArrayList<String > person11=new ArrayList<>();
//            ArrayList<String > person1 = new ArrayList<>();
//            person1 = pesonDB.getPerson(pass);
//            person11 =pesonDB.getPerson(username);
            if (person11.isEmpty()){
//                System.out.println("lllll");
                txt.setText("username not exsist");
//            pesonDB pesonDB = new pesonDB() ;
//            ArrayList<String> person1 = new ArrayList<>();
//            person1 = pesonDB.getPerson(username);
//            if (username.equals(person1.get(0))){
//                if (pass.equals(person1.get(1))) {
//                    server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));

//                }
//
           }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
////            server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
//
//
//            pesonDB pesonDB = new pesonDB();
//
//            pesonDB.addPerson(user);

//                if (person1.isEmpty())
//                    txt.setText(("password not exsist"));

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
