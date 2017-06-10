package eplhello.preferences;

//import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
//import org.osgi.service.prefs.Preferences;

public class BadWordsPreferencePage extends PreferencePage 
	implements IWorkbenchPreferencePage {

	@Override
	public void init(IWorkbench arg0) {
		
		///Initialize the preference store we wish to use
		
		//String text = Platform.getPreferencesService()
		//		.getString("org.eclipse.core.resources", "version", "", null);
		//System.out.println(text);
		//Preferences pr = org.eclipse.core.runtime.preferences.InstanceScope.INSTANCE.getNode("org.eclipse.m2e.core");
		//pr.get("eclipse.m2.defaultRuntime", "");
		setPreferenceStore(BadWordCheckerPlugin.getDefault().getPreferenceStore());

	}

	@Override
	protected Control createContents(Composite arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
