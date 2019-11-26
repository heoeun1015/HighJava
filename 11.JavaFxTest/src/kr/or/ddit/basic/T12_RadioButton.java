package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T12_RadioButton extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		// 라디오 버튼을 묶음으로 처리할 객체 생성
		ToggleGroup group = new ToggleGroup();
		ImageView icon = new ImageView();
		RadioButton rb1 = new RadioButton("HOME");

		rb1.setToggleGroup(group);	// 라디오 버튼을 그룹에 추가
		rb1.setUserData("HOME");	// 선택했을 대의 값을 나타내기 위한 데이터 설정

		RadioButton rb2 = new RadioButton("CALENDAR");
		rb2.setToggleGroup(group);
		rb2.setUserData("CALENDAR");
		
		RadioButton rb3 = new RadioButton("Contacts");
		rb3.setToggleGroup(group);
		rb3.setUserData("Contacts");


		// 그룹 내에서 RadioButton 중 하나가 선택되었을 떄 처리하기
		group.selectedToggleProperty().addListener( new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, 
					Toggle oldValue, Toggle newValue) {
				// 선택된 항목(라디오버튼)이 있는지 검사
				if(group.getSelectedToggle().getUserData() != null) {
					String url = group.getSelectedToggle().getUserData().toString();

					Image img  = new Image(getClass().getResourceAsStream("images/" + url + ".jpg"));
					icon.setImage(img);
				}
				}
			});
		
		rb1.setSelected(true);		// 선택된 상태로 설정하기
		
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		
		vBox.getChildren().addAll(rb1, rb2, rb3);
		vBox.setSpacing(10);
		
		hBox.getChildren().addAll(vBox, icon);
		hBox.setPadding(new Insets(10));
		hBox.setSpacing(50);
		
		Scene scene = new Scene(hBox, 250, 150);
		primaryStage.setTitle("라디오버튼 예제");
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}























