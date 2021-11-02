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
		// ��Ʈ�Ҿ����
		Font.loadFont(getClass().getResourceAsStream("KOTRA_TTF"), 14);
		// *{
		//	-fx-font-family:"KOTRA_TTF";
		//} ��Ÿ�Ͻ�Ʈ�� �̷��� �����ϸ��
		Scene scene = new Scene(parent);
		// �ܺ� ��Ÿ�Ͻ�Ʈ ����
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
			stage.setResizable(false); // �������� ���������
			stage.setTitle("�α���"); // �������� �̸�
			// �������� ������
				// 1. �̹��� �ҷ�����
				Image image = new Image("file:D:/JavaWeb/jihy1218/java__2/src/fxml/icon2.png");
				stage.getIcons().add(image);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
