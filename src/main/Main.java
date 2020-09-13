package main;

import exception.BusinessException;
import facade.Facade;
import facade.IFacade;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import model.Gerente;
import model.Pessoa;

import java.io.IOException;

public class Main extends Application {
    public static Stage STAGE = new Stage();
    public static Stage STAGE_PRINCIPAL = new Stage();
    public static String LOGIN = "/view/TelaLogin.fxml";
    public static String MENU = "/view/TelaControleInterno.fxml";


    @Override
    public void start(Stage primaryStage) throws Exception{
       STAGE.initOwner(STAGE_PRINCIPAL);
       STAGE.initModality(Modality.WINDOW_MODAL);
       stageLogin().setResizable(false);
       stageLogin().setTitle("Login Bar da Fava");
       stageLogin().initStyle(StageStyle.UNDECORATED);
       stageLogin().show();

    }

    public static Stage stagePrincipal() throws IOException {
        STAGE_PRINCIPAL.setScene(new Scene(FXMLLoader.load(Main.class.getResource(MENU))));
        STAGE_PRINCIPAL.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                STAGE_PRINCIPAL.close();
            }
        });
        return STAGE_PRINCIPAL;
    }

    public static Stage stageLogin() throws IOException {
        STAGE.setScene(new Scene(FXMLLoader.load(Main.class.getResource(LOGIN))));
        STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                STAGE.close();
            }
        });
        return STAGE;
    }

    public static Stage stageGenerico(String caminho) throws IOException {
        STAGE.setScene(new Scene(FXMLLoader.load(Main.class.getResource(caminho))));
        STAGE.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                STAGE.close();
            }
        });
        return STAGE;
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        Pessoa pessoa = new Pessoa("123",1);
        try {
            facade.salvarPessoa(pessoa);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
