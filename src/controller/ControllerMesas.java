package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.Main;

import java.io.IOException;

public class ControllerMesas {
    static String mesa = "/view/TelaMesas.fxml";
    static String pagamento = "/view/TelaPagamento.fxml";

    @FXML
    private Tab registrar;

    @FXML
    private TextField hChegada;

    @FXML
    private TextField clienteMesa;

    @FXML
    private ComboBox<?> numMesa;

    @FXML
    private Tab ocupada;

    @FXML
    private TableView<?> mesas;

    @FXML
    private TableColumn<?, ?> numMesaOcuped;

    @FXML
    private TableColumn<?, ?> horaMesaOcuped;

    @FXML
    private TableColumn<?, ?> clienteMesaOcuped;

    @FXML
    private TableColumn<?, ?> pedidosMesaOcuped;

    @FXML
    void buscaMesa(ActionEvent event) {

    }

    @FXML
    void fecharConta(ActionEvent event) throws IOException {
        Main.stageGenerico(pagamento).show();
    }

    @FXML
    void salvaMesa(ActionEvent event) {

    }

    @FXML
    void voltaMesa(ActionEvent event) throws IOException {
        Main.stageGenerico(mesa).close();
    }

}