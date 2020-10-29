package controller;

import exception.ExceptionGeral;
import facade.Facade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.Main;
import model.Mesa;
import view.Mensagem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPagamentos implements Initializable {
    static String pagamento = "/view/TelaPagamento.fxml";
    static String telaMesa = "/view/TelaMesas.fxml";
    ControllerMesas controllerMesas, initiControllerMesas;
    Mesa mesa;
    boolean isVista = false;
    boolean isCartao = false;
    Facade facade = new Facade();

    @FXML
    private ToggleGroup tipoPg;

    @FXML
    private Label mesaLb;

    @FXML
    private TextField valorTf;

    @FXML
    private TextField hSaida;

    @FXML
    void aVista(ActionEvent event) {
        isVista = true;
        isCartao = false;
    }

    @FXML
    void finalizarConta(ActionEvent event) {
        try {
            atualizar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void noCartao(ActionEvent event) {
        isCartao = true;
        isVista = false;
    }

    @FXML
    void cancelar(ActionEvent event) throws IOException {
        Main.stageGenerico(telaMesa).show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarMesa();
    }

    void carregarMesa(){
        mesa = controllerMesas.getIsMesa();
        mesaLb.setText(mesa.getNumero().toString());
    }

    void atualizar() throws IOException {
        double convert = Double.parseDouble(valorTf.getText());
        if (isCartao){
            convert = convert + (convert * 0.10);
            System.out.println("Cartão");
        }
        mesa.setValor_conta(convert);
        mesa.setStatus("Desocupada");
        mesa.setHora_saida(hSaida.getText());
        System.out.println("Setou");
        try {
            facade.atualizaMesa(mesa);
            System.out.println("Atualizou");
        } catch (ExceptionGeral exceptionGeral) {
            Mensagem.mensagem("Erro ao efetuar pagamento!");
            exceptionGeral.printStackTrace();
        }
        Mensagem.mensagem("Pagamento efetuado com sucesso!");
        Main.stageGenerico(pagamento).close();
    }

    public Label getMesaLb() {
        return mesaLb;
    }

    public void setMesaLb(Label mesaLb) {
        this.mesaLb = mesaLb;
    }
}
