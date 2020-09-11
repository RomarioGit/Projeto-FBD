package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.Main;

import java.io.IOException;

public class ControllerCadastro {
    static String cadastro = "/view/TelaCadastro.fxml";
    @FXML
    private TextField nomeTf;

    @FXML
    private TextField cpfTf;

    @FXML
    private TextField cidadeTf;

    @FXML
    private TextField ruaTf;

    @FXML
    private DatePicker dataNasc;

    @FXML
    private TextField bairroTf;

    @FXML
    private TextField emailTf;

    @FXML
    private TextField foneTf;

    @FXML
    private TextField complementoTf;

    @FXML
    private TextField senhaTfDefine;

    @FXML
    private TextField senhaTfConfirm;

    @FXML
    void cadastrarBt(ActionEvent event) {

    }

    @FXML
    void cancelarBt(ActionEvent event) throws IOException {
        Main.stageGenerico(cadastro).close();
    }

}
