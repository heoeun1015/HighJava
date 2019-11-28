package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class T17_DialoglTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		HBox root = new HBox(10);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		
		// 파일열기 창
		Button btnFileOpen = new Button("Open FileChooser 실행");
		btnFileOpen.setOnAction(e -> {
			FileChooser chooser = new FileChooser();
			
			// 확장별로 파일 구분하는 필터 등록하기
			chooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text Files", "*.txt"), 
					new ExtensionFilter("Text Files", "*.png", "*.jpg", "*.gif"),	
					new ExtensionFilter("Audio Files", "*.wav", "*.mp3"),
					new ExtensionFilter("All Files", "*.*")
			);
			
			// Dialog 창에서 '열기'버튼을 누르면 선택한 파일 정보가 반환되고 '취소'버튼을 누르면 null이 반환된다.
			File selectFile = chooser.showOpenDialog(primaryStage);
			if(selectFile != null) {
				// 이 영역에서 파일 내용을 읽어오는 작업을 수행한다.
				System.out.println("OPEN: " + selectFile.getPath());
			}
			
		});
		
		Button btnFileSave = new Button("SAVE FileChooser 실행");
		btnFileSave.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().addAll((new ExtensionFilter("All Files", "*.*")));
			
			File selFile = fileChooser.showSaveDialog(primaryStage);
			
			if(selFile != null) {
				// 이곳에서 선택한 파일을 이용한 저장 작업을 수행한다.
				System.out.println("SAVE: " + selFile.getPath());
			}
		});
		
		
		// 폴더(디렉토리)만 선택하는 Dialog 창
		Button btnDirectory = new Button("DirectoryChooser 실행");
		btnDirectory.setOnAction(e -> {
			DirectoryChooser dirChooser = new DirectoryChooser();
			File selDir = dirChooser.showDialog(primaryStage);
			
			if(selDir != null) {
				System.out.println("Directory: " + selDir);
			}
		});
		
		
		Button btnPopup = new Button("Popup 실행");
		btnPopup.setOnAction(e -> {
			
			// Popup 창에 나타낼 컨트롤들 구성 시작
			HBox popRoot = new HBox();
			
			ImageView imgView = new ImageView();
			imgView.setImage(new Image(getClass().getResource("./images/ok.png").toString()));
			
			imgView.setFitWidth(30);
			imgView.setFitHeight(30);
			
			Label lblMsg = new Label("메세지가 왔습니다.");
			HBox.setMargin(lblMsg, new Insets(0, 5, 0, 5));
			
			popRoot.getChildren().addAll(imgView, lblMsg);
			// 구성 끝
			
			// Popup 객체 생성 후 위에서 구성한 컨트롤들 추가 후 보이기
			Popup popup = new Popup();
			popup.setX(1000);
			popup.setY(500);
			popup.getContent().add(popRoot);
			popup.setAutoHide(true);		 
			popup.setAutoHide(true);	// false로 바뀌면 다른 곳을 눌러도 없어지지 않는다. 
			popup.show(primaryStage);
			
		});
		
		
		// 사용자가 만든 임의의 창 나타내기
		Button btnCustom = new Button("사용자 정의 창 실행");
		btnCustom.setOnAction(e -> {
			
			// 새창 띄우기
			
			// 1. Stage 객체 생성
			Stage dialog = new Stage(StageStyle.UTILITY);
			
			// 2. 모달창 여부 설정
			// 모달창은 자식창이 나타나면 부모창을 사용할 수 없다.
			dialog.initModality(Modality.APPLICATION_MODAL);
			
			// 3. 부모창 지정
			dialog.initOwner(primaryStage);
			
			dialog.setTitle("사용자 정의 창");
			
			// 4. 자식창에 나타날 컨테이너 객체 생성
			Parent parent = null;	// 상위 객체이기 때문에 어떤 컨테이너든 담을 수 있다.
			try {
				parent = FXMLLoader.load(getClass().getResource("myDialog.fxml"));
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
			
			// 부모창에서 fxml로 만든 자식창의 컨트롤 객체 얻기
			TextField txtName = (TextField) parent.lookup("#txtName");	// 원하는 동작이 있을 때 지정
			PasswordField pass = (PasswordField) parent.lookup("#pass");
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(evt -> {
				dialog.close();
			});
			
			
			// 5. Scene 객체를 생성해서 컨테이너 객체 추가
			Scene scene = new Scene(parent);
			
			// 6. Stage 객체에 Scene 객체 추가
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			
		});

		
		root.getChildren().addAll(btnFileOpen, btnFileSave, btnDirectory, btnPopup, btnCustom);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Dialog 창 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}


