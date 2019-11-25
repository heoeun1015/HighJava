package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T11_ComboGugudanTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// 뭘로 넣어주든 상관이 없다.
		Parent root = FXMLLoader.load(getClass().getResource("ComboGugudan.fxml"));
//		BorderPane ROOT = FXMLLoader.load(getClass().getResource("ComboGugudan.fxml"));
		
		/*
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 300);
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10));
		hBox.setSpacing(10);
		
		TextArea txtResult = new TextArea();
		txtResult.setPrefSize(200, 200);
		
		Button btnDan = new Button("출력");
		
		ComboBox<Integer> cmdDan = new ComboBox<>();
		cmdDan.setPrefWidth(150);
		*/
		
		/*─────────────────────────────────────────────────────────────────────*/
		
		/*
		ObservableList<Integer> list =
				FXCollections.observableArrayList(
						1, 2, 3, 4, 5, 6, 7, 8, 9
						);
		cmdDan.setItems(list);
		
		
		btnDan.setOnAction(e ->{
			int dan = cmdDan.getSelectionModel().getSelectedItem();
			
			txtResult.setText(dan + "단\n\n");
			for(int i = 1; i <= 9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");
				// 처음을 제외하곤 append로 추가해준다. 
			}
		});
		*/
		
		/*─────────────────────────────────────────────────────────────────────*/
		
		/*
		hBox.getChildren().addAll(cmdDan, btnDan);
		
		root.setTop(hBox);
		root.setCenter(txtResult);
		*/
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("콤보박스 구구단");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}








