
package com.senatov.smapperApp.handlers;



import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;



public class FindHandler {

	@Inject
	private static Logger LOG;


	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		LOG.debug("execute()");
		MessageDialog.openInformation(shell, "Find command info:", "Find is clicked");
	}

}
