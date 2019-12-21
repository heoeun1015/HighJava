package kr.or.ddit.controll;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class ControlController implements Initializable{

	@FXML private TextField nameTxt;
	@FXML private RadioButton gender1;
	@FXML private RadioButton gender2;
	@FXML private CheckBox hobby1;
	@FXML private CheckBox hobby2;
	@FXML private CheckBox hobby3;
	@FXML private CheckBox hobby4;
	@FXML private CheckBox hobby5;
	@FXML private CheckBox hobby6;
	@FXML private CheckBox hobby7;
	@FXML private CheckBox hobby8;
	@FXML private Button btn;
	@FXML private TextArea txtArea;
	
	private String name;
	private String gender;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML public void btn1(ActionEvent event) {
		
		String hobby ="";
		
		name = nameTxt.getText();
		
		if(gender1.isSelected()) {
			gender = "남자";
		}else {
			gender = "여자";
		}
		
		boolean chk = false;
		
		if(hobby1.isSelected()) {
			hobby += ", 여행";
			chk = true;
		}
		if(hobby2.isSelected()){
			hobby += ", 등산";
			chk = true;
		}
		if(hobby3.isSelected()){
			hobby += ", 독서";
			chk = true;
		}
		if(hobby4.isSelected()){
			hobby += ", 바둑";
			chk = true;
		}
		if(hobby5.isSelected()){
			hobby += ", 장기";
			chk = true;
		}
		if(hobby6.isSelected()){
			hobby += ", 게임";
			chk = true;
		}
		if(hobby7.isSelected()){
			hobby += ", 테니스";
			chk = true;
		}
		if(hobby8.isSelected()){
			hobby += ", 배드민턴";
			chk = true;
		}
		
		if(chk == false) {
			hobby = " 선택되지 않았습니다.";
		}else {
			hobby = hobby.substring(1, hobby.length()) + "입니다.";
		}
		
		txtArea.setText("이름은 " + name + "이고, 성별은 " + gender + "입니다.\n취미는" + hobby);
		
	}

}
