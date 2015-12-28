
package com.senatov.smapperApp.handlers;



import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.ichir.eclipse.logger.api.ILogger;
import com.ichir.eclipse.logger.api.LoggerFactory;


public class FindHandler {

	private static final ILogger LOG = LoggerFactory.getLogger(FindHandler.class);


	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		LOG.debug("execute()");
		MessageDialog.openInformation(shell, "Find command info:", "Find is clicked");
	}

}
