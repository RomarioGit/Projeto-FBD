package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.Main;

import java.io.IOException;

public class ControllerPagamentos {
    static String pagamento = "/view/TelaPagamento.fxml";
    @FXML
    void aVista(ActionEvent event) {

    }

    @FXML
    void finalizarConta(ActionEvent event) {

    }

    @FXML
    void noCartao(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) throws IOException {
        Main.stageGenerico(pagamento).close();
    }

}
