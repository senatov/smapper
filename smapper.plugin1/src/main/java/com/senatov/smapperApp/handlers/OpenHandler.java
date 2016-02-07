/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 8, 2016 - 12:44:50 AM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp.handlers
 * @file OpenHandler.java / OpenHandler
 ***********************************************************************************/

package com.senatov.smapperApp.handlers;



import javax.inject.Named;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * The Class OpenHandler.
 */
public class OpenHandler {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(OpenHandler.class);



	/**
	 * Execute.
	 *
	 * @param shell the shell
	 */
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		LOG.debug("execute()");
		MessageDialog.openInformation(shell, "Open info:", "Open is clicked");
	}
}
