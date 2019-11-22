package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// 프로그래밍 레이아웃 방식 : 자바 코드 기반으로만 만든 형식
public class T03_ProgrammingLayout extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// HBox 컨테이너 생성
			// HBox = 수평 박스
		HBox hBox = new HBox();
		
		
		// 안쪽 여백 설정하기
		// Insets 객체는 값을 주는 순서가 위, 오른쪽, 아래, 왼쪽 순으로 설정한다.
		hBox.setPadding(new Insets(10, 10, 10, 10));	// insets: 끼워넣다, 삽입하다. 객체로 만들어 Padding에 설정해줌. 
		hBox.setSpacing(50);							// 컨트롤과 컨트롤 사이의 간격
															// 버튼 하나의 안쪽 여백은 패딩, 버튼과 버튼 두 개가 있으면 그 사이 여백은 spacing
		
		
		// 한 줄의 데이터를 입력하는 컨트롤
		TextField txtField = new TextField();	// html의 inputText와 같다.
		txtField.setPrefWidth(200);				// TextField의 너비 크기 설정
		
		
		Button btn = new Button("확 인");			// 버튼 객체 생성
		
		
		// HBox에 추가하기
		hBox.getChildren().addAll(txtField, btn);	// 순서가 중요. 먼저 들어간 쪽이 먼저 표시된다.
		
		// Scene 객체 생성
		Scene scene = new Scene(hBox);
		
		primaryStage.setTitle("자바코드를 이용한 레이아웃 설정하기");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}


































