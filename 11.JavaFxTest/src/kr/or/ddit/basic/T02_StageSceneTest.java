package kr.or.ddit.basic;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class T02_StageSceneTest extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// JavaFxApplication 쓰레드가 실행해준다.
		
		VBox root = new VBox();		// 컨트롤들을 세로로 배치해주는 컨테이너
		root.setPrefWidth(650);		// VBox의 높이
		root.setPrefHeight(150);	// VBox의 너비
		root.setAlignment(Pos.CENTER);	// 컨트롤들을 가운데로 정렬
		root.setSpacing(20);		// 컨트롤과 컨트롤 사이의 간격
		
		
		
		// awt 말고 꼭 javaFx로 임포트해줄 것
		Label label = new Label();	// Label 객체 생성
		label.setText("안녕하세요. JavaFX입니다.");
		
		Label label2 = new Label();
		label2.setText("안녕하세요?");
		Label label3 = new Label();
		label3.setText("이러면 추가가 어떻게 되지?");
		Label label4 = new Label();
		label4.setText("뚜루뚜뚜");
		Label label5 = new Label();
		label5.setText("추가가 되었다!");
		
		label.setFont(new Font(50));	// Font 객체를 이용하여 글자 크기 설정
		
		Button btn = new Button();
		btn.setText("확인");
		Button btn2 = new Button();
		btn2.setText("확인2");
		Button btn3 = new Button();
		btn3.setText("확인3");
		Button btn4 = new Button();
		btn4.setText("확인4");
		Button btn5 = new Button();
		btn5.setText("확인5");
		
		
		
		// 버튼에 대한 클릭 이벤트 처리
		// 방법1 → 람다식을 사용하지 않는 경우
		btn.setOnAction(new EventHandler<ActionEvent>() {
				// 처리 = Handling. 이벤트 처리하는 객체를 만들어줬다.
				// 등록된 EventHandler가 있다면, 하고 아래를 실행한다.
			
			@Override
			public void handle(ActionEvent event) {
				// 처리할 내용을 기술하는 영역
				Platform.exit();	// 프로그램 종료. JavaFx에서 지원해준다.
			}
		});
		
		
		
		// 방법2. 람다식을 이용
		btn.setOnAction(e -> Platform.exit());
			// btn.setOnAction((ActionEvent event) -> {Platform.exit();});
			// 변수명이기 때문에 e로 줄이고, 뒤 내용도 하나라서 중괄호 생략 가능.
			// e의 경우 파라미터이기 때문에 아무거나 와도 상관이 없다.
		
		
		// VBox에 컨트롤들 추가하기
		root.getChildren().add(label);	// toot = VBox
		root.getChildren().add(label2);
		root.getChildren().add(label3);
		root.getChildren().add(label4);
		root.getChildren().add(label5);
		
		root.getChildren().add(btn);
		root.getChildren().add(btn2);
		root.getChildren().add(btn3);
		root.getChildren().add(btn4);
		root.getChildren().add(btn5);
		
//		root.getChildren().add(label, btn);	// 방법2. 이건 한꺼번에 담는 방법
			// Java에서 Node 객체는 parent, control, labeled를 전부 담을 수 있다.
			// Node = ObserbleList
		
		
		// VBox를 루트 컨테이너로 하는 Scene 객체 생성
		Scene scene = new Scene(root);
			// 컨테이너를 Scene에 배치. 씬을 하나 만들어서 구성한 컨테이너를 넣어 한 장면을 만들었다.
			
		
		primaryStage.setTitle("Stage와 Scene연습");	// 창 제목
		primaryStage.setScene(scene);		// Stage에 Scene 설정
		primaryStage.show();		// 창(Stage) 보이기. 이걸 하지 않으면 보이지 않음.
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}












