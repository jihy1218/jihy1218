package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Appstart extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
		// 폰트불어오기
		Font.loadFont(getClass().getResourceAsStream("KOTRA_TTF"), 14);
		// *{
		//	-fx-font-family:"KOTRA_TTF";
		//} 스타일시트에 이렇게 적용하면됨
		Scene scene = new Scene(parent);
		// 외부 스타일시트 적용
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
			stage.setResizable(false); // 스테이지 사이즈고정
			stage.setTitle("로그인"); // 스테이지 이름
			// 스테이지 아이콘
				// 1. 이미지 불러오기
				Image image = new Image("file:D:/JavaWeb/jihy1218/java__2/src/fxml/icon2.png");
				stage.getIcons().add(image);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
