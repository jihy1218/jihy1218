module java__2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires mail;				// mail관련 라이브러리
	requires activation;		// mail관련 라이브러리
	// requires 사용할 모듈명
	// opens 패키지명 to 모듈명 
	
	opens Day01 to javafx.graphics, javafx.fxml;
	opens Day02 to javafx.graphics, javafx.fxml;

	opens App to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml;
	opens dao to java.sql;
	opens domain to mail, activation, javafx.base;
}
