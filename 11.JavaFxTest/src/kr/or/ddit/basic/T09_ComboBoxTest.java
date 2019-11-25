package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T09_ComboBoxTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();
		HBox hBox = new HBox();
		TextArea txtArea = new TextArea();
		
		ComboBox<String> combo = new ComboBox<>();
		combo.getItems().addAll("한강", "금강", "영산강", "낙동강");
			// ObservableList 를 많이 쓰게 될 것. 후 ObservableList에 추가를 더 하면 위 4개 데이터에 추가로 더해진다.  
		combo.setValue("한강");	// 처음 보이는 부분 세팅
		
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
		
		// 방법1) ComboBox의 값이 변경될 때의 처리. 즉, change 이벤트 처리
		
		combo.setOnAction(new EventHandler<ActionEvent>() { // 람다식을 사용하지 않았을 때
			@Override
			public void handle(ActionEvent e) {
				txtArea.setText((String)((ComboBox<?>)e.getSource()).getSelectionModel().getSelectedItem());
			}
		});
		
		
		combo.setOnAction(e -> {
			
//			System.out.println(((ComboBox<String>)e.getSource()).getSelectionModel().getSelectedItem());
			
//			txtArea.setText(((ComboBox<String>)e.getSource()).getSelectionModel().getSelectedItem());
			// 노란줄이 나오는 이유는 String이라고 우리가 강제적으로 지정해줬기 때문.
			
			txtArea.setText((String)((ComboBox<?>)e.getSource()).getSelectionModel().getSelectedItem());
			// 와일드카드로 바꿔준 후 캐스팅 작업
			// getSelectionModel: 데이터에 접근하는 방식. 데이터를 구현하는 모델.
			// getSelectedItem: 콤보박스는 하나의 아이템으로 보기 때문. 선택한 아이템을 가져온다.
			
		});
		
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
		
		// 방법2)
		combo.valueProperty().addListener(new ChangeListener<String>() {
			// valueProperty: value를 관리
			// addListener: event를 듣고 있음. 듣고 있다가 이벤트가 실행이 되면 보여준다.
			// ChangeListener: 값이 변경됐는지 확인
			// combo의 내용이 바뀔 때마다 addListener를 써줬기 때문에 아래가 실행된다.  

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// oldValue, newValue: 값이 변경되기 전, 후가 필요할 경우를 대비한 변수.
				txtArea.setText(newValue);
			}
			
		});
		
		ObservableList<String> fruitList = FXCollections.observableArrayList(
				"사과", "배", "복숭아", "포도", "김"
				);
		
		
		// 객체 생성 및 데이터 초기화를 동시에
		ComboBox<String> combo2 = new ComboBox<>(fruitList);
		
		// 데이터를 초기화 후에 추가하기
		combo2.getItems().addAll("대추", "호두");
		
		combo2.setValue("포도");
		
		Button button = new Button("확인");
		
		button.setOnAction(e -> {
			
			if(combo.getValue() != null && combo2.getValue() != null) {
				txtArea.setText(combo.getValue() + " 지역에는 " + combo2.getValue() + "(이)가 유명합니다.");
			}
			
		});
		
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		hBox.getChildren().addAll(combo, combo2, button);
		
		root.setTop(hBox);
		root.setCenter(txtArea);
		
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setTitle("ComboBox 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}





























