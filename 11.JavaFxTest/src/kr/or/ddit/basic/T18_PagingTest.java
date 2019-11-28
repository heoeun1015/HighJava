package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class T18_PagingTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PagingTest.fxml"));
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("PagingTest.css").toString());
		
		primaryStage.setTitle("페이징 테스트");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}















