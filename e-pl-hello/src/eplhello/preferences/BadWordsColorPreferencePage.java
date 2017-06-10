package eplhello.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class BadWordsColorPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	@Override
	public void init(IWorkbench arg0) {
		///Initialize the preference store we wish to use
		setPreferenceStore(BadWordCheckerPlugin.getDefault().getPreferenceStore());

	}

	@Override
	protected Control createContents(Composite arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
