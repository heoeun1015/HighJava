package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class T13_CheckBoxTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Rectangle rect = new Rectangle(90, 30);	// 4각형 그리기
		rect.setArcHeight(10);		// 둥근 4각형을 만들기 위한 꼭지점 모따기
		rect.setArcWidth(10);
		rect.setFill(Color.rgb(41, 41, 41));	// 4각형 내부 색칠하기
		
		
		String[] names = new String[] {"Security", "Project", "Chart"};
		
		Image[] images = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];
		
		CheckBox[] chkBoxs = new CheckBox[names.length];
		
		
		for(int i = 0; i < names.length; i++) {
			//출력할 이미지 읽어오기
			final Image img = images[i] = new Image(getClass().getResourceAsStream("images/" + names[i] + ".png"));
					// 따로 써도 되고 같이 써도 되고.. 그건 자기 마음대로. 맨 오른쪽부터 순서대로 왼쪽으로 들어간다.
			
			// 이미지를 출력하는 객체 생성
			final ImageView icon = icons[i] = new ImageView();
			final CheckBox cb = chkBoxs[i] = new CheckBox(names[i]);
			
			
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
				// 계속 눌리기 때문에 ChangeListener로 등록을 해준다.

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					// 이 ChangeListener의 제너릭이 달라지면 changed의 제너릭, 변수타입도 같이 정해진다. 이번엔 Boolean이라 이렇게 선언됨.
					
					// ImageView의 setImage()메서드는 보여줄 이미지를 셋팅하는 메서드
//					icon.setImage(newValue ? img : null);
					
					if(newValue) {
						icon.setImage(img);		// 체크를 했으면 이미지를 넣어라
//						icon.setImage(images[i]);	// final이 아니기 때문에 들어갈 수 없다.
													// 람다식 내부에서 사용하기 img 변수를 선언해준 것.
					}else {
						icon.setImage(null);	// ImageView에서 이미지 삭제
												// 체크를 하지 않았으면 이미지를 없애라
					}
				}
			});
		}
		
		
		Button btnOk = new Button("확인");
		btnOk.setOnAction(e ->{
			// CheckBox의 check 여부를 확인하는 방법
			if(chkBoxs[1].isSelected()) {
				showInfo(chkBoxs[1].getText() + "체크");
			}else {
				showInfo(chkBoxs[1].getText() + "체크 해제");
			}
			
			// CheckBox의 chcke 여부 셋팅하기
//			chkBoxs[0].setSelected(true);		// 체크하기
//			chkBoxs[0].setSelected(false);		// 해제하기
			
			chkBoxs[0].setSelected(!chkBoxs[1].isSelected());
				// 체크박스의 첫번째가 선택되어 있을 때, 두 번째가 선택되어 있으면 not으로 만든다.
				// 두 번째가 선택됐는지 안됐는지를 판단해 첫 번째 값을 설정함. 두 번째 값에 의존하게 만들어놨다.
			
		});
		
		
		// 가장 왼쪽의 체크박스 모아두는 박스
		VBox vBox = new VBox(5);	// spacing 처리
		vBox.getChildren().addAll(chkBoxs);
		vBox.getChildren().add(btnOk);
		
		HBox hBox = new HBox();	// 아이콘 세 개 있는 박스
		hBox.getChildren().addAll(icons);
		hBox.setPadding(new Insets(0, 0, 0, 5));	// 아이콘 가장 왼쪽(left): 5
		
		
		// StackPane은 컨트롤들을 쌓아놓는 방식으로 배치하는 컨테이너이다.
		StackPane stack = new StackPane();	// 최종적으로 가장 맨 마지막만 보이게 화면을 쌓는 형식
											// 예를 들어 로그인 화면을 구현할 때 메인화면 위 로그인 화면을 보여주는 식
		
		stack.getChildren().addAll(rect, hBox);
		StackPane.setAlignment(rect, Pos.TOP_CENTER);
		// rect 백그라운드, hBox 그 위에 얹어놨다.
		
		
		HBox root = new HBox();	// 전체 창 설정
		root.setSpacing(40);
		root.setPadding(new Insets(20, 10, 10, 20));
		root.getChildren().addAll(vBox, stack);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("CheckBox연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	private void showInfo(String msg) {
		Alert alertInfo = new Alert(AlertType.INFORMATION);
		
		alertInfo.setTitle("INFORMATION");
		alertInfo.setContentText(msg);
		alertInfo.showAndWait();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
}







