package com.team3.Controller;

/**
 * .fxml 파일 경로를 미리 지정하여 사용할 수 있도록 UI enum 정의
 */
public enum UI {
	
	LIST("UI/List.fxml"),
	INSERT("UI/Insert.fxml"),
	READ("UI/Read.fxml"),
	UPDATE("UI/Update.fxml");
	
	private final String path;
	
	UI(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

}