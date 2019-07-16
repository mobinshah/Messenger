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
   public static DataInputStream dis ;
   public static DataOutputStream dos ;

    static Stage stage;


    // static
    @Override
    public void start(Stage Stage) throws Exception {
        stage = Stage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage.setScene(new Scene(root, 600, 600));
        Stage.setTitle("Messanger1");
        stage.alwaysOnTopProperty();
        Stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket ;
        socket = serverSocket.accept();
        dos =new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());





        }

    }

