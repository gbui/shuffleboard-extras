package com.team2073.shuffleboard;

import org.fxmisc.easybind.EasyBind;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

@Description(name = "Progress Bar", dataTypes = Number.class)
@ParametrizedController("ProgressBarWidget.fxml")
public class ProgressBarWidget extends SimpleAnnotatedWidget<Number> {

	@FXML
	private Pane root;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Label label;

	private final BooleanProperty showText = new SimpleBooleanProperty(this, "showText", true);

	@FXML
	private void initialize() {
		progressBar.progressProperty().bind(dataOrDefault);
		label.textProperty().bind(EasyBind.map(dataOrDefault, this::generateLabelText));
		exportProperties(showText);
	}

	private String generateLabelText(Number data) {
		return String.format("%.0f", data.doubleValue() * 100) + "%";
	}

	@Override
	public Pane getView() {
		return root;
	}
}
