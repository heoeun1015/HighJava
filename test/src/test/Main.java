package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("main1.fxml"));
		
		HBox hBox = new HBox();
		ImageView icon = new ImageView();
		
		primaryStage.setTitle("image view");
		
		Image img = new Image(getClass().getResourceAsStream("images/지도_0.png")); // 상대경로
		
		icon.setImage(img);
		
		hBox.getChildren().add(icon);
		
		Scene scene = new Scene(hBox, 250, 150);
		primaryStage.setTitle("지도 test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
