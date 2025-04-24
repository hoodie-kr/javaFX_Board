package com.team3.Controller;

import java.io.IOException;

import com.team3.Util.SceneUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;

public class MainController {

    @FXML
    void toList(ActionEvent event) throws IOException {
        Parent root = SceneUtil.getInstance().getRoot();
        SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
    }

}
