package kr.or.ddit.basic;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class T14_ListViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ListView<String> list = new ListView<>();
		
		Label label = new Label();
		label.setFont(new Font(20));
		
		//ListView에 들어갈 데이터 구성하기
		ObservableList<String> data =FXCollections.observableArrayList("green", "gold", "red", "blue",
				"black", "brown", "blueviolet", "pink", "yellow", "chocolate");
		
		//list.setItems(data); // ListView에 데이터 셋팅하기 1
		
		
		// 데이터셋팅방법 2
		list.getItems().addAll("green", "gold", "red", "blue", "black", "brown", "blueviolet",
				"pink", "yellow", "chocolate");
		
		
		//ListView에 값이 선택되었을 때 처리
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				label.setText(newValue);		// 현재 선택된 값 → newValue
												// 이전 선택된 값 → oldValue
				label.setTextFill(Color.web(newValue));	// 글자색 변경. 페인트객체가 만들어진다.
			}
		
		});
		
		
		// ListView 의 내용은 변경되지 않고 화면에 보이는 부분만 변경하는 방법
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
				// setCellFactory: 기존 데이터는 변경하지 않고 보이는 뷰만 변경
				// 이 아래는 Callback 객체를 적어준 것. 
			
			@Override
			public ListCell<String> call(ListView<String> param) { 	// call: 익명객체
																	// List Cell: 셀을 하나씩 지정해주는 방식 
				
				return new ListCell<String>(){
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);	// 기본 셀 생성
						
						// 변경된 데이터가 문자열이면 setText()사용함
						// setText(item);
						
						Rectangle rect = new Rectangle(100,20);
						if(item != null) { // 또는 !empty
							rect.setFill(Color.web(item)); //색칠하기
														  // 배열 색
							
							Label lalTxt = new Label(item);	// 아이템으로 받은 글자 모양
							lalTxt.setTextFill(Color.web(item));
							
							// 셀 안에 들어가는 내용
							HBox hb2 = new HBox(10);
							
							hb2.getChildren().addAll(rect, lalTxt,
									new ImageView(new Image(getClass().getResourceAsStream("images/Security.png"))));
							// setImage를 해도 되고, Image 생성자로 바로 넣어줘도 된다.
						
						setGraphic(hb2);
						// 노드: 컨트롤, 컨테이너, 랙탱글 전부 다 노드. 상위 개념 객체. 오브젝트 바로 아래.
						// 셀 하나에 생기게끔 정해준다.
						
						}
					}
				};
				
			}
		});
		
		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(list, label);
		
		Scene scene = new Scene(vbox);
		primaryStage.setTitle("ListView 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
