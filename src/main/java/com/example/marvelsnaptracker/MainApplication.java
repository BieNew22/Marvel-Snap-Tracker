package com.example.marvelsnaptracker;

import com.example.marvelsnaptracker.card.CardManager;
import com.example.marvelsnaptracker.deck.DeckManager;
import com.example.marvelsnaptracker.utils.db.DatabaseDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 510, 700);

        // TODO : 제목 표시줄 부분 나중에 HBOX를 추가하여 수정
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Marvel Snap");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {

        // 0. DB 초기화
        DatabaseDriver.getInstance().initDB();

        // 1. 사용자 덱 정보 초기화하기
        DeckManager.getInstance().initDeck();

        launch();
    }
}