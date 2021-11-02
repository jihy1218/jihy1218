package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardviewcontroller {

    @FXML
    private Button btnback;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnreplywrite;

    @FXML
    private Button btnupdate;

    @FXML
    private TableView<?> replylist;

    @FXML
    private TextArea txtcontents;

    @FXML
    private TextField txttitle;

    @FXML
    void back(ActionEvent event) {
    	Mainpagecontroller.getinstance().loadpage("boardlist");
    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void replywrite(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

}
