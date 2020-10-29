package controller;

import exception.ExceptionGeral;
import facade.Facade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.Main;
import model.Garcon;
import model.Mesa;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerMesas implements Initializable {
    static String mesa = "/view/TelaMesas.fxml";
    static String pagamento = "/view/TelaPagamento.fxml";
    Garcon garcon;
    Facade facade = new Facade();
    static Mesa isMesa;
    boolean selecionei = false;

    @FXML
    private Tab registrar;

    @FXML
    private TextField hChegada;

    @FXML
    private TextField clienteMesa;

    @FXML
    private TextField numMesa;

    @FXML
    private Tab ocupada;

    @FXML
    private TableView<Mesa> mesas;

    @FXML
    private TableColumn<Mesa, Integer> numMesaOcuped;

    @FXML
    private TableColumn<Mesa, String> horaMesaOcuped;

    @FXML
    private TableColumn<Mesa, String> clienteMesaOcuped;

    @FXML
    private TableColumn<Mesa, String> pedidosMesaOcuped;

    @FXML
    private TextField pedidosTf;

    @FXML
    void buscaMesa(ActionEvent event) {
        try {
            buscarMesa(facade.getAllMesa());
        } catch (ExceptionGeral exceptionGeral) {
            exceptionGeral.printStackTrace();
        }
    }

    @FXML
    void fecharConta(ActionEvent event) throws IOException {
        if (selecionei) {
            Main.stageGenerico(pagamento).show();
        }
    }

    @FXML
    void salvaMesa(ActionEvent event) throws ExceptionGeral {
        registarMesa();
    }

    @FXML
    void voltaMesa(ActionEvent event) throws IOException {
        Main.stageGenerico(mesa).close();
    }
    @Override
    public void initialize(URL url, ResourceBundle bundle){
        mesas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 1){
                    if (mesas.getSelectionModel().getSelectedItem() != null){

                        isMesa = mesas.getSelectionModel().getSelectedItem();
                        selecionei = true;
                    }
                }
            }
        });
    }
    void registarMesa() throws ExceptionGeral {
        Mesa mesa = new Mesa();
        mesa.setNumero(Integer.parseInt(numMesa.getText()));
        mesa.setHora_entrada(hChegada.getText());
        mesa.setCliente(clienteMesa.getText());
        mesa.setPedido(pedidosTf.getText());
        mesa.setHora_saida("0");
        mesa.setStatus("Ocupada");
        mesa.setValor_conta(0.0);
        facade.salvarMesa(mesa);
        limpar();

    }

    void buscarMesa(ArrayList<Mesa> m) throws ExceptionGeral{
        clienteMesaOcuped.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        numMesaOcuped.setCellValueFactory(new PropertyValueFactory<>("numero"));
        pedidosMesaOcuped.setCellValueFactory(new PropertyValueFactory<>("pedido"));
        horaMesaOcuped.setCellValueFactory(new PropertyValueFactory<>("hora_entrada"));

        mesas.getItems().setAll(m);

    }

    void limpar(){
        numMesa.clear();
        pedidosTf.clear();
        hChegada.clear();
        clienteMesa.clear();
    }

    public static Mesa getIsMesa() {
        return isMesa;
    }

    public static void setIsMesa(Mesa isMesa) {
        ControllerMesas.isMesa = isMesa;
    }
}