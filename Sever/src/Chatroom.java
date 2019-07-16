import com.sun.security.ntlm.Server;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Chatroom implements Initializable {

    String laugh = "\uD83D\uDE02";
    String cry = "\uD83D\uDE2D";
    String scared = "\uD83D\uDE31";
    String mad = "\uD83D\uDE21";
    String poker = "\uD83D\uDE10";
    String heart = "❤";

    @FXML
    Button btnSend ;
    @FXML
    Button btnh;
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
    @FXML
    Button btnL ;
    @FXML
    Button btnc ;
    @FXML
    Button btns ;
    @FXML
    Button btnm ;
    @FXML
    Button btnp;


    public static String TEXT ;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            chatHistoryDB chatHistoryDB = new chatHistoryDB() ;

            for ( int i = 0 ;i<chatHistoryDB.showPm(Login.username , Search.Search).size();i++) {
                chatHistoryDB.showPm(Login.username, Search.Search).get(i);
            }
            for ( int i = 0 ;i<chatHistoryDB.showPm( Search.Search ,Login.username ).size();i++){
                chatHistoryDB.showPm( Search.Search  ,Login.username ).get(i);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }










        btnh.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(heart));
        });
        btnL.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(laugh));

        });
        btnc.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(cry));
        });
        btns.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(scared));
        });
        btnm.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(mad));
        });
        btnp.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(poker));
        });


        btnInformation.setOnAction(event -> {

            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("information.fxml"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        Date date=new Date();
        String date1=date.toString();
        btnSetting.setOnAction(event -> {
        try {
             server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("setting.fxml"))));
     } catch (IOException e) {
            e.printStackTrace();
     }

    });
        try {
            pesonDB pd = new pesonDB();
            Image image = new Image(new FileInputStream(pd.getPerson(Search.Search).get(5)));
            ImageView iv=new ImageView(image);
            iv.setFitHeight(100);
            iv.setFitWidth(60);
            btnInformation.setGraphic(iv);


        } catch (Exception e) {
            e.printStackTrace();
        }

        btnFile.setOnAction(event -> {
         FileChooser fileChooser = new FileChooser();
         File selectedFile = fileChooser.showOpenDialog(null);
//            if (file != null) {
//                String fileAsString = file.toString();
//
//                chosen.setText("Chosen: " + fileAsString);
//            } else {
//                chosen.setText(null);
//            }
//        });
    });

        btnSend.setOnAction(event -> {
            new Thread(()-> {

                try {
                    TEXT = txtfMessege.getText();
                    server.dos.writeUTF(Login.username + ":" +TEXT);
                    chatHistoryDB chatHistoryDB = new chatHistoryDB();
                    chatHistory chatHistory = new chatHistory(Login.username,Search.Search ,TEXT , date1);
                    chatHistoryDB.addpm(chatHistory);
                    txta.appendText("you :" +TEXT +"\n");

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }).start();



        });


        new Thread(()->{
            try {
//
                while (true) {

//                TEXT = txtfMessege.getText();
                    TEXT = server.dis.readUTF();
                    txta.appendText(TEXT + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }
}

