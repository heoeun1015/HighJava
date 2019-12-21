package kr.or.ddit.member;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class MemberAdminController implements Initializable{

	@FXML private TextField memId;
	@FXML private TextField memNm;
	@FXML private TextField memTel;
	@FXML private TextField memAddr;
	@FXML private Button memAdd;
	@FXML private Button memMdf;
	@FXML private Button memDel;
	@FXML private Button memCheck;
	@FXML private Button memCac;
	@FXML private TableView<String> memTb;
	@FXML private TableColumn idTb;
	@FXML private TableColumn nameTb;
	@FXML private TableColumn telTb;
	@FXML private TableColumn addrTb;
	
	private ObservableList<MemberVO> data;
	
	private TableView<MemberVO> table;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		data = FXCollections.observableArrayList(
					new MemberVO("홍길동", "gildong", "2222-2222", "대전"),	
					new MemberVO("홍길서", "gilseo", "3333-3333", "서울"),	
					new MemberVO("홍길남", "gilnam", "4444-4444", "원주"),
					new MemberVO("홍길북", "gilbook", "5555-5555", "제주")	
				);
		
		table = new TableView<>(data);
		
	}

	@FXML public void btnAdd(ActionEvent event) {
		
		if(memId.getText().isEmpty() || memNm.getText().isEmpty() || memTel.getText().isEmpty() ||
				memAddr.getText().isEmpty()) {
					//System.out.println("빈 항목이 있습니다.");
					errMsg("작업 오류", "빈 항목이 있습니다.");	// Alert 타입
					return;
				}
				
				data.add(new MemberVO(memId.getText(),
						memNm.getText(), 
						memTel.getText(), 
						memAddr.getText()));
				infoMsg("작업결과", memNm.getText() + "님 정보를 추가했습니다.");
				
				idTb.setCellValueFactory(new PropertyValueFactory<MemberVO,String>("id"));
				nameTb.setCellValueFactory(new PropertyValueFactory<MemberVO,String>("name"));
				telTb.setCellValueFactory(new PropertyValueFactory<MemberVO,String>("tel"));
				addrTb.setCellValueFactory(new PropertyValueFactory<MemberVO,String>("addr"));
				
				
				memId.clear();
				memNm.clear();
				memTel.clear();
				memAddr.clear();
	}

	@FXML public void btnMdf(ActionEvent event) {
		
		if(memId.getText().isEmpty() || memNm.getText().isEmpty() || memTel.getText().isEmpty() ||
				   memAddr.getText().isEmpty()) {
					//System.out.println("빈 항목이 있습니다.");
					errMsg("작업 오류", "빈 항목이 있습니다.");
					return;
				}
				
				if(!Pattern.matches("^[0-9]+$", memTel.getText())) {
					errMsg("데이터 오류","나이는 정수형으로 입력하세요");
					memTel.requestFocus();  // 해당 객체에 Focus주기
					return;
				}
				
				// ObservableList에 추가
				// set: 수정할 때
				data.set(
					table.getSelectionModel().getSelectedIndex(),	// getSelectedItem: 선택돼있는 VO객체를 가져옴
																	// getSelectedIndex: 선택돼있는 인덱스를 가져옴
					// 수정하고자 하는 데이터
					new MemberVO(memId.getText(),
							memNm.getText(), 
							memTel.getText(),	// 정수형 바꿔주기 
							memAddr.getText() 
					)
				);
				
				infoMsg("작업결과", memId.getText() + "님 정보를 수정했습니다.");
				
				// 넣어준 후 textField 초기화
				memId.clear();
				memNm.clear();
				memTel.clear();
				memAddr.clear();
		
	}

	@FXML public void btnDel(ActionEvent event) {
		
		if(table.getSelectionModel().isEmpty()) {
			errMsg("작업 오류", "삭제할 자료를 선택한 후 삭제하세요.");
			return;
		}
		
		data.remove(table.getSelectionModel().getSelectedIndex());
		
		infoMsg("작업결과", memId.getText() + "님 정보를 삭제했습니다.");
		
		memId.clear();
		memNm.clear();
		memTel.clear();
		memAddr.clear();
		
	}

	@FXML public void btnCheck(ActionEvent event) {
		
	}

	@FXML public void btnCac(ActionEvent event) {
		
	}
	
	
	public void errMsg(String headerText, String msg) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류");
		errAlert.setHeaderText(headerText);
		errAlert.setContentText(msg);
		errAlert.showAndWait();
	}
	
	public void infoMsg(String headerText, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("정보 확인");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}

}







