package eplhello.preferences;

import org.eclipse.core.runtime.IPluginDescriptor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;

@SuppressWarnings({ "deprecation", "unused" })
public class BadWordCheckerPlugin extends AbstractUIPlugin {

	// The shared instance.
	private static BadWordCheckerPlugin plugin;

	// The identifiers for the preferences
	public static final String BAD_WORDS_PREFERENCE = "badwords";
	public static final String HIGHLIGHT_PREFERENCE = "highlight";

	// The default values for the preferences
	public static final String DEFAULT_BAD_WORDS = "bug;bogus;hack;";
	public static final int DEFAULT_HIGHLIGHT = SWT.COLOR_BLUE;

	public BadWordCheckerPlugin() {
		plugin = this;
	}

	public static BadWordCheckerPlugin getDefault() {
		if (plugin == null) {
			new BadWordCheckerPlugin();
		}
		return plugin;
	}

	/**
	 * Initializes a preference store with default preference values for this
	 * plug-in.
	 */
	protected void initializeDefaultPreferences(IPreferenceStore store) {
		store.setDefault(BAD_WORDS_PREFERENCE, DEFAULT_BAD_WORDS);
		Color color = Display.getDefault().getSystemColor(DEFAULT_HIGHLIGHT);
		PreferenceConverter.setDefault(store, HIGHLIGHT_PREFERENCE, color.getRGB());

	}
}
