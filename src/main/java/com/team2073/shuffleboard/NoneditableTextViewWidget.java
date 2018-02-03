package com.team2073.shuffleboard;

import org.fxmisc.easybind.EasyBind;

import edu.wpi.first.shuffleboard.api.components.NumberField;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

@Description(
	name = "Noneditable Text View",
	summary = "Display a value as noneditable text",
	dataTypes = {
		String.class, Number.class, Boolean.class
	})
@ParametrizedController("NoneditableTextViewWidget.fxml")
public class NoneditableTextViewWidget extends SimpleAnnotatedWidget<Object> {

	@FXML
	private Pane root;
	@FXML
	private TextField textField;
	@FXML
	private NumberField numberField;

	@FXML
	private void initialize() {
		dataProperty().addListener((__, prev, cur) -> {
			if (cur != null) {
				if (cur instanceof Number) {
					numberField.setNumber(((Number) cur).doubleValue());
				} else if (cur instanceof String || cur instanceof Boolean) {
					textField.setText(cur.toString());
				} else {
					throw new UnsupportedOperationException("Unsupported type: " + cur.getClass().getName());
				}
			}
		});
		numberField.visibleProperty().bind(EasyBind.map(dataProperty(), d -> d instanceof Number).orElse(false));
		textField.visibleProperty().bind(numberField.visibleProperty().not());

		textField.setDisable(true);
		numberField.setDisable(true);
	}

	@Override
	public Pane getView() {
		return root;
	}
}
