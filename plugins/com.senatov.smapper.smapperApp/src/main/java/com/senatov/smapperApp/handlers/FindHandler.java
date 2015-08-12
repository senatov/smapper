
package com.senatov.smapperApp.handlers;



import javax.inject.Named;


import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;



public class FindHandler {

	private static final Logger LOG = Logger.getLogger(OpenHandler.class);


	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		LOG.debug("execute()");
		MessageDialog.openInformation(shell, "Find command info:", "Find is clicked");
	}

}
