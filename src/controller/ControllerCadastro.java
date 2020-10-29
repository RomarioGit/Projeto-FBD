package controller;

import exception.ExceptionGeral;
import facade.Facade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.Main;
import model.*;
import view.Mensagem;

import java.io.IOException;

public class ControllerCadastro {
    static String cadastro = "/view/TelaCadastro.fxml";
    boolean selectGarcon;
    boolean selectGerente;
    boolean selectMan;
    boolean selectWoman;
    boolean selectOther;
    Usuario usuario;
    Contato contato;
    Endereco endereco;
    Pessoa pessoa;
    Gerente gerente;
    Garcon garcon;
    Facade facade = new Facade();

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
    private ToggleGroup sexoTG;

    @FXML
    private TextField bairroTf;

    @FXML
    private TextField estadoTf;

    @FXML
    private TextField emailTf;

    @FXML
    private TextField foneTf;

    @FXML
    private TextField cepTf;

    @FXML
    private TextField complementoTf;

    @FXML
    private TextField senhaTfDefine;

    @FXML
    private ToggleGroup funcaoTG;

    public static String getCadastro() {
        return cadastro;
    }

    public static void setCadastro(String cadastro) {
        ControllerCadastro.cadastro = cadastro;
    }

    public TextField getNomeTf() {
        return nomeTf;
    }

    public void setNomeTf(TextField nomeTf) {
        this.nomeTf = nomeTf;
    }

    public TextField getCpfTf() {
        return cpfTf;
    }

    public void setCpfTf(TextField cpfTf) {
        this.cpfTf = cpfTf;
    }

    public TextField getCidadeTf() {
        return cidadeTf;
    }

    public void setCidadeTf(TextField cidadeTf) {
        this.cidadeTf = cidadeTf;
    }

    public TextField getRuaTf() {
        return ruaTf;
    }

    public void setRuaTf(TextField ruaTf) {
        this.ruaTf = ruaTf;
    }

    public DatePicker getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(DatePicker dataNasc) {
        this.dataNasc = dataNasc;
    }

    public TextField getBairroTf() {
        return bairroTf;
    }

    public void setBairroTf(TextField bairroTf) {
        this.bairroTf = bairroTf;
    }

    public TextField getEmailTf() {
        return emailTf;
    }

    public void setEmailTf(TextField emailTf) {
        this.emailTf = emailTf;
    }

    public TextField getFoneTf() {
        return foneTf;
    }

    public void setFoneTf(TextField foneTf) {
        this.foneTf = foneTf;
    }

    public TextField getComplementoTf() {
        return complementoTf;
    }

    public void setComplementoTf(TextField complementoTf) {
        this.complementoTf = complementoTf;
    }

    public TextField getSenhaTfDefine() {
        return senhaTfDefine;
    }

    public void setSenhaTfDefine(TextField senhaTfDefine) {
        this.senhaTfDefine = senhaTfDefine;
    }

    @FXML
    void cadastrarBt(ActionEvent event) throws ExceptionGeral, IOException {
        if(nomeTf.getText().isEmpty() || cpfTf.getText().isEmpty()|| ruaTf.getText().isEmpty()||
                bairroTf.getText().isEmpty() || cidadeTf.getText().isEmpty() || estadoTf.getText().isEmpty() ||
        cepTf.getText().isEmpty() || foneTf.getText().isEmpty() || complementoTf.getText().isEmpty() ||
        emailTf.getText().isEmpty() || senhaTfDefine.getText().isEmpty()){

            Mensagem.mensagem("Preencha todos os campos!");
        }
        else{
            cadastrar();
        }
    }

    @FXML
    void cancelarBt(ActionEvent event) throws IOException {
        Main.stageGenerico(cadastro).close();
    }

    void limpar(){
        nomeTf.clear();
        emailTf.clear();
        ruaTf.clear();
        bairroTf.clear();
        cidadeTf.clear();
        complementoTf.clear();
        senhaTfDefine.clear();
        foneTf.clear();
        cpfTf.clear();
        cepTf.clear();
        estadoTf.clear();

    }

    void cadastrar() throws ExceptionGeral, IOException {
        usuario = new Usuario();
        contato = new Contato();
        endereco = new Endereco();
        pessoa = new Pessoa();
        if(selectGerente) {
            gerente = new Gerente();
            usuario.setLogin(emailTf.getText());
            usuario.setSenha(senhaTfDefine.getText());
            facade.salvarUsuario(usuario);

            contato.setEmail(emailTf.getText());
            contato.setTelefone(foneTf.getText());
            facade.salvarContato(contato);

            endereco.setBairro(bairroTf.getText());
            endereco.setComplemento(complementoTf.getText());
            endereco.setCep(cepTf.getText());
            endereco.setRua(ruaTf.getText());
            endereco.setCidade(cidadeTf.getText());
            endereco.setEstado(estadoTf.getText());
            facade.salvarEndereco(endereco);

            pessoa.setCpf(cpfTf.getText());
            facade.salvarPessoa(pessoa);

            gerente.setNome(nomeTf.getText());
            gerente.setData_nasc(dataNasc.getValue().toString());
            gerente.setContato(contato);
            gerente.setEndereco(endereco);
            gerente.setPessoa(pessoa);
            gerente.setUsuario(usuario);
            if (selectMan){
                gerente.setSexo("Masculino");
            }
            else if (selectWoman){
                gerente.setSexo("Feminino");
            }
            else{
                gerente.setSexo("Outro");
            }
            facade.salvarGerente(gerente);
            limpar();
        }
        else {
            garcon = new Garcon();
            usuario.setLogin(emailTf.getText());
            usuario.setSenha(senhaTfDefine.getText());
            facade.salvarUsuario(usuario);

            contato.setEmail(emailTf.getText());
            contato.setTelefone(foneTf.getText());
            facade.salvarContato(contato);

            endereco.setBairro(bairroTf.getText());
            endereco.setComplemento(complementoTf.getText());
            endereco.setCep(cepTf.getText());
            endereco.setRua(ruaTf.getText());
            endereco.setCidade(cidadeTf.getText());
            endereco.setEstado(estadoTf.getText());
            facade.salvarEndereco(endereco);

            pessoa.setCpf(cpfTf.getText());
            facade.salvarPessoa(pessoa);

            garcon.setNome(nomeTf.getText());
            garcon.setData_nasc(dataNasc.getValue().toString());
            garcon.setContato(contato);
            garcon.setEndereco(endereco);
            garcon.setPessoa(pessoa);
            garcon.setUsuario(usuario);
            if (selectMan){
                garcon.setSexo("Masculino");
            }
            else if (selectWoman){
                garcon.setSexo("Feminino");
            }
            else{
                garcon.setSexo("Outro");
            }
            facade.salvarGarcon(garcon);
            limpar();
        }
        Main.stageGenerico(cadastro).close();
    }
    @FXML
    void isGarcon(ActionEvent event) {
        selectGarcon = true;
        selectGerente = false;
    }

    @FXML
    void isGerente(ActionEvent event) {
        selectGerente = true;
        selectGarcon = false;
    }

    @FXML
    void isMan(ActionEvent event) {
        selectMan = true;
        selectWoman = false;
        selectOther = false;
    }

    @FXML
    void isOther(ActionEvent event) {
        selectMan = false;
        selectWoman = false;
        selectOther = true;
    }

    @FXML
    void isWoman(ActionEvent event) {
        selectMan = false;
        selectWoman = true;
        selectOther = false;
    }
}
