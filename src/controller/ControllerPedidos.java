package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;

public class ControllerPedidos {
    static String pedidos = "/view/TelaPedidos.fxml";

    @FXML
    private ComboBox<?> nPedido;

    @FXML
    void addPedido(ActionEvent event) {

    }

    @FXML
    void realizarPedidos(ActionEvent event) {

    }
    @FXML
    void voltarControle(ActionEvent event) throws IOException {
        Main.stageGenerico(pedidos).close();
    }

}

