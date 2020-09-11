package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.StageStyle;
import main.Main;

import java.io.IOException;

public class ControllerControleInterno {
    static String cadastro = "/view/TelaCadastro.fxml";
    static String mesa = "/view/TelaMesas.fxml";
    static String caixa = "/view/TelaCaixa.fxml";
    @FXML
    void aCadastroBt(ActionEvent event) throws IOException {
        Main.stageGenerico(cadastro).show();
    }

    @FXML
    void aCaixaBt(ActionEvent event) throws IOException {
        Main.stageGenerico(caixa).show();
    }

    @FXML
    void aMesaBt(ActionEvent event) throws IOException {
        Main.stageGenerico(mesa).show();
    }

    @FXML
    void aSairBt(ActionEvent event) throws IOException {
        Main.stagePrincipal().close();
        Main.stageLogin().show();
    }

}