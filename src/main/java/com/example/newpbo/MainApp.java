package com.example.newpbo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Pengguna user1 = new Pelanggan("Dhani", 505000, "44376034", 1522.88);
        Pengguna user2 = new Pelanggan("Surya", 150000, "39230313", 1444.70);
        Pengguna user3 = new Pelanggan("Rahmat", 150000, "32230313", 1444.70);
        DataPengguna.addPengguna(user1);
        DataPengguna.addPengguna(user2);
        DataPengguna.addPengguna(user3);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Parent root = loader.load();

        MainController controller = loader.getController();

        controller.setDataPengguna(user1);

        primaryStage.setTitle("Aplikasi Loket Pembayaran");
        primaryStage.setScene(new Scene(root, 680, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
