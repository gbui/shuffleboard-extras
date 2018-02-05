package com.team2073.shuffleboard;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;
import javafx.scene.layout.Pane;

@Description(name = "Spinner", dataTypes = Number.class)
@ParametrizedController("SpinnerWidget.fxml")
public class SpinnerWidget extends SimpleAnnotatedWidget<Number> {

	@FXML
	private Pane root;
	@FXML
	private Spinner<Double> spinner;

	private final DoubleSpinnerValueFactory spinnerValueFactory = new DoubleSpinnerValueFactory(0, 10, 0, 1);

	@FXML
	private void initialize() {
		spinner.setValueFactory(spinnerValueFactory);
		dataProperty().addListener((__, prev, cur) -> spinnerValueFactory.setValue(cur.doubleValue()));
		spinnerValueFactory.valueProperty().addListener((__, oldNumber, newNumber) -> setData(newNumber));
		exportProperties(
			spinnerValueFactory.minProperty(),
			spinnerValueFactory.maxProperty(),
			spinnerValueFactory.amountToStepByProperty(),
			spinnerValueFactory.wrapAroundProperty()
		);
	}

	@Override
	public Pane getView() {
		return root;
	}
}
