package com.team2073.shuffleboard;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

@Description(name = "Text Area", dataTypes = String.class)
@ParametrizedController("TextAreaWidget.fxml")
public class TextAreaWidget extends SimpleAnnotatedWidget<String> {

	@FXML
	private Pane root;
	@FXML
	private TextArea textArea;

	private final StringProperty fontSizeProperty = new SimpleStringProperty(this, "fontSize", "100%");

	@FXML
	private void initialize() {
		textArea.textProperty().bindBidirectional(dataProperty());
		textArea.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSizeProperty));
		exportProperties(textArea.wrapTextProperty(), fontSizeProperty);
	}

	@Override
	public Pane getView() {
		return root;
	}
}
