package eplhello.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class TestToolbarHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {

		System.out.println("Toolbar action!");
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(arg0);
		MessageDialog.openInformation(
				window.getShell(),
				"E-pl-hello",
				"Hello, Eclipse world");
		
		return null;
	}
}
