module java__2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	// requires ����� ����
	// opens ��Ű���� to ���� 
	
	opens Day01 to javafx.graphics, javafx.fxml;
	opens App to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml;
	opens Day02 to javafx.graphics, javafx.fxml;
	opens dao to java.sql;

}
