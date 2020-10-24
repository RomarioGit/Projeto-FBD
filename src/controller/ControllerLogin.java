package controller;

import exception.ExceptionGeral;
import facade.Facade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;
import model.Usuario;
import view.Mensagem;

import javax.swing.*;
import java.io.IOException;

public class ControllerLogin {
    Facade facade = new Facade();
    @FXML
    private TextField loginTf;

    @FXML
    private PasswordField senhaPf;

    @FXML
    void loginBt(ActionEvent e) throws IOException {

        if (loginTf.getText().isEmpty() || senhaPf.getText().isEmpty()){
            Mensagem.mensagem("Todos os campos devem ser preenchidos!");
        }
        else if(efetuarLogin()){
            Mensagem.mensagem("Bem vindo!");
            Main.stagePrincipal().show();
            Main.stagePrincipal().setResizable(false);
            Main.stagePrincipal().setTitle("Sistema Bar da Fava");
            Main.stageLogin().close();
            loginTf.clear();
            senhaPf.clear();
        }

        else if (loginTf.getText().equalsIgnoreCase("admin")){
            if(senhaPf.getText().equalsIgnoreCase("admin")){
                Mensagem.mensagem("Bem vindo!");
                Main.stagePrincipal().show();
                Main.stagePrincipal().setResizable(false);
                Main.stagePrincipal().setTitle("Sistema Bar da Fava");
                Main.stageLogin().close();
                loginTf.clear();
                senhaPf.clear();
            }
        }
        else{
            Mensagem.mensagem("Usuário não cadastrado no sistema!");
            loginTf.clear();
            senhaPf.clear();
        }
    }

    @FXML
    void sairBt(ActionEvent event) {
        System.exit(0);
    }

    public boolean efetuarLogin(){
        try {
            Usuario usuario = facade.buscarLogin(loginTf.getText(),senhaPf.getText());
            if(usuario == null){
                return false;
            }
            return true;
        } catch (ExceptionGeral exceptionGeral) {
            exceptionGeral.printStackTrace();
            loginTf.clear();
            senhaPf.clear();
            return false;
        }
    }
}
