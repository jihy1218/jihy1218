module java__2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires mail;				// mail���� ���̺귯��
	requires activation;		// mail���� ���̺귯��
	// requires ����� ����
	// opens ��Ű���� to ���� 
	
	opens Day01 to javafx.graphics, javafx.fxml;
	opens Day02 to javafx.graphics, javafx.fxml;

	opens App to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml;
	opens dao to java.sql;
	opens domain to mail, activation, javafx.base;
}
