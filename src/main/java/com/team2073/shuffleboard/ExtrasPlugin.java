package com.team2073.shuffleboard;

import java.util.Arrays;
import java.util.List;

import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.plugin.Requires;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

@Description(
	group = "com.team2073.shuffleboard",
	name = "Extras",
	version = "1.0.0",
	summary = "Defines extra widgets"
)
@Requires(group = "edu.wpi.first.shuffleboard", name = "Base", minVersion = "1.0.0")
public class ExtrasPlugin extends Plugin {
	@Override
	public List<ComponentType> getComponents() {
		return Arrays.asList(
			WidgetType.forAnnotatedWidget(NoneditableTextViewWidget.class),
			WidgetType.forAnnotatedWidget(RadioButtonChooserWidget.class)
		);
	}
}
