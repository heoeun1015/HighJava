package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class T04_FxmlLayout extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// fxml 파일을 일겅와 현재 Stage에 적용하기
		
		// Parent 객체는 모든 컨테이너의 조상 객체
		
		// 방법1
		// FXMLLoad의 static 메서드를 이용하여 Fxml 파일을 로딩하는 방법
//		Parent root = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml"));
//		Parent root = FXMLLoader.load(getClass().getResource("example.fxml"));
				// T04_FxmlLayout 가 제공해주는 리소스. 이 클래스 위치 정보에 있는 리소스를 불러오는 방법.
				// 같은 패키지(디렉토리) 안에 있기 때문에 그냥 파일명만 써줘도 된다.
				// Fxml 안에 있는 컨테이너로 HBox에 만들어주는 작업과 똑같다.
				// 프로그래밍 레이아웃에서 작성한 /hBox.getChildren().addAll(txtField, btn);/ 와 똑같다.
		
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/		
		
		// 방법2
		// FXMLLoad의 instance 메서드를 이용하여 Fxml 파일을 로딩하는 방법
		// → 나중에 인스턴스를 이용하여 해당 Fxml의 컨트롤러 객체를 가져올 수 있다.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlLayout.fxml"));
		
		Parent root = loader.load();		// 인스턴스 객체에 대한 노드 메서드
		// 스태틱으로 하냐, 인스턴스로 하냐의 차이
		
//		loader.getController();	// 나중에 배우게 될 거
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Fxml 문서를 이요한 레이아웃 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
