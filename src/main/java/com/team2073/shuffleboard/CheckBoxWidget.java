package com.team2073.shuffleboard;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;

@Description(name = "Check Box", dataTypes = Boolean.class)
@ParametrizedController("CheckBoxWidget.fxml")
public class CheckBoxWidget extends SimpleAnnotatedWidget<Boolean> {

	@FXML
	private Pane root;
	@FXML
	private CheckBox checkBox;

	@FXML
	private void initialize() {
		checkBox.selectedProperty().bindBidirectional(dataProperty());
	}

	@Override
	public Pane getView() {
		return root;
	}
}
