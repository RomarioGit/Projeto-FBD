package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import main.Main;

import java.io.IOException;

public class ControllerCaixa {
    static String caixa = "/view/TelaCaixa.fxml";

    @FXML
    private TableView<?> valorReceita;

    @FXML
    private TableView<?> valorDespesa;

    @FXML
    void voltar(ActionEvent event) throws IOException {
        Main.stageGenerico(caixa).close();
    }
}
