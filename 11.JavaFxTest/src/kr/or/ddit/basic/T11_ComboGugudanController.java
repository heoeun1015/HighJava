package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class T11_ComboGugudanController implements Initializable{

	// 필드값 or 멤버변수 or 속성.
	// FXML에서 만들어진 객체가 이미 들어가 있기 때문에 이 변수들을 참조해서 아래 initialize에서 사용할 수 있다.
	@FXML
//	private ComboBox cmdDan;	// 제너릭으로 지정을 안 해줘서 노란줄이 뜬다.
	private ComboBox<Integer> cmdDan;	// FXML 파일에서(JAVAFx에서 만들어준) 찾은 필드를 여기다 넣어준다.
	@FXML
	private Button btnDan;
	@FXML
	private TextArea txtResult;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 가장 첫 번째로 시작이 된다. 실행할 내용을 나열해주면 됨.
		// FXML 하나로 두 개의 컨트롤러가 있으면 안 된다. 그럼 나중에 정상적으로 작동하지 않음.
		// 실행할 때엔 위 필드(멤버변수)가 실행되어 있음. 이미 만들어져 있기 때문에 그냥 쓰면 된다.
		
		ObservableList<Integer> list =
				FXCollections.observableArrayList(
						1, 2, 3, 4, 5, 6, 7, 8, 9
						);
		cmdDan.setItems(list);
		
		
//		btnDan.setOnAction(e ->{
//
//		int dan = cmdDan.getSelectionModel().getSelectedItem();
//		
//		txtResult.setText(dan + "단\n\n");
//		for(int i = 1; i <= 9; i++) {
//			int r = dan * i;
//			txtResult.appendText(dan + " * " + i + " = " + r + "\n");
//		}
//		
//		});
		
	}

	
	/**
	 * 단 버튼이 클릭되었을 때 처리하는 메서드
	 * @param e
	 */
	@FXML // 객체 주입의 역할도 하지만 핸들링 역할도 한다.
	void btnDanClick(ActionEvent e) {
		
		int dan = cmdDan.getSelectionModel().getSelectedItem();
		
		txtResult.setText(dan + "단\n\n");
		for(int i = 1; i <= 9; i++) {
			int r = dan * i;
			txtResult.appendText(dan + " * " + i + " = " + r + "\n");
		}
	}
	
	
}




















