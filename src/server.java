import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
Stage stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setTitle("Messanger");
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch();
        ServerSocket serverSocket = new ServerSocket(100100);
        Socket socket ;
        socket = serverSocket.accept();
        DataOutputStream dos =new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        }

    }

