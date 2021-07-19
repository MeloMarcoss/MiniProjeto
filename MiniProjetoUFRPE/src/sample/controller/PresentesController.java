package sample.controller;

import controllers.Facade;
import dados.IRepositorioPresente;
import dados.RepositorioPresente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Presente;

public class PresentesController {

    Facade fachada = Facade.getInstance();

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtPreco;

    @FXML
    void limpar(ActionEvent event) {
        txtCategoria.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
    }


    @FXML
    void salvar(ActionEvent event) {

        int codigoMensagem = fachada.salvarPresente(txtDescricao.getText(), txtCategoria.getText(), txtPreco.getText());

        if (codigoMensagem == 1){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirma��o");
            alert.setHeaderText("Sucesso!");
            alert.setContentText(txtDescricao.getText() + " foi registrado com sucesso com a categoria " + txtCategoria.getText() + " e pre�o de R$" + Float.parseFloat(txtPreco.getText()));
            alert.showAndWait();

        }
        else if (codigoMensagem == 2){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Preencha todos os campos");
            alert.setContentText("Campo Descri��o n�o foi preenchido");
            alert.showAndWait();

        } else if (codigoMensagem == 3){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Preencha todos os campos");
            alert.setContentText("Campo Pre�o n�o foi preenchido");
            alert.showAndWait();

        } else if (codigoMensagem == 4){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Preencha todos os campos");
            alert.setContentText("Campo categoria n�o foi preenchido");
            alert.showAndWait();

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro n�o esperado");
            alert.setContentText("Contatar o programador para saber mais");
            alert.showAndWait();

        }

    }
}
