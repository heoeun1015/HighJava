package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		StackPane pane = new StackPane();
		
		Image image = new Image("지도_00.png");
		
		ImageView iv = new ImageView();
		
		iv.setImage(image);
		
		pane.getChildren().add(iv);
		
		
		Scene scene = new Scene(pane);
		
		primaryStage.setTitle("ㅇㅇ");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
