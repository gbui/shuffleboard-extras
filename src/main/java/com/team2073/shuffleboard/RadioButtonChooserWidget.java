package com.team2073.shuffleboard;

import java.util.Map;

import edu.wpi.first.shuffleboard.api.widget.ComplexAnnotatedWidget;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.plugin.base.data.SendableChooserData;
import edu.wpi.first.shuffleboard.plugin.base.data.types.SendableChooserType;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

@Description(name = "RadioButton Chooser", dataTypes = SendableChooserType.class)
@ParametrizedController("RadioButtonChooserWidget.fxml")
public class RadioButtonChooserWidget extends ComplexAnnotatedWidget<SendableChooserData> {

	private final ToggleGroup group = new ToggleGroup();

	@FXML
	private Pane root;
	@FXML
	private VBox vbox;

	@FXML
	private void initialize() {
		dataOrDefault.addListener((__, oldData, newData) -> {
			Map<String, Object> changes = newData.changesFrom(oldData);
			if (changes.containsKey(SendableChooserData.OPTIONS_KEY)) {
				updateOptions(newData.getOptions());
			}
			if (changes.containsKey(SendableChooserData.DEFAULT_OPTION_KEY)) {
				updateDefaultValue(newData.getDefaultOption());
			}
			if (changes.containsKey(SendableChooserData.SELECTED_OPTION_KEY)) {
				updateSelectedValue(newData.getSelectedOption());
			}
		});
		group.selectedToggleProperty().addListener((__, oldToggle, newToggle) -> {
			RadioButton newButton = (RadioButton) newToggle;
			if (newButton != null) {
				setData(getData().withSelectedOption(newButton.getText()));
			}
		});
	}

	private void updateOptions(String... options) {
		group.getToggles().clear();
		vbox.getChildren().clear();
		for (String option : options) {
			RadioButton button = new RadioButton(option);
			button.setToggleGroup(group);
			vbox.getChildren().add(button);
		}
	}

	private void updateDefaultValue(String defaultValue) {
		if (group.getSelectedToggle() == null) {
			updateSelectedValue(defaultValue);
		}
	}

	private void updateSelectedValue(String selectedValue) {
		for (Toggle toggle : group.getToggles()) {
			RadioButton button = (RadioButton) toggle;
			if (button.getText().equals(selectedValue)) {
				button.setSelected(true);
				return;
			}
		}
	}

	@Override
	public Pane getView() {
		return root;
	}
}
