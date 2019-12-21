package kr.or.ddit.addr;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;

public class AddrSearchController implements Initializable{

	@FXML private ComboBox<String> addrCm;
	@FXML private TextField addrTxt;
	@FXML private Button addrBtn;
	@FXML private TableView<String> addrTb;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		addrTxt.setStyle("-fx-text-fill:white; -fx-background-color:#96d4ff;");
		
	}

	@FXML private void Searchbtn(ActionEvent event) {
		
		
		
		
	}	

}
