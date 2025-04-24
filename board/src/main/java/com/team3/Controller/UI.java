package com.team3.Controller;

/**
 * .fxml 파일 경로를 미리 지정하여 사용할 수 있도록 UI enum 정의
 */
public enum UI {
	
	LIST("/resources/com/team3/UI/List.fxml"),
	INSERT("/resources/com/team3/UI/UI/Insert.fxml"),
	READ("/resources/com/team3/UI/UI/Read.fxml"),
	UPDATE("/resources/com/team3/UI/UI/Update.fxml");
	
	private final String path;
	
	UI(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

}