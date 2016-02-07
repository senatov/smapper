/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 8, 2016 - 12:45:03 AM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp.handlers
 * @file QuitHandler.java / QuitHandler
 ***********************************************************************************/

package com.senatov.smapperApp.handlers;



import javax.inject.Named;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class QuitHandler {

	private static final Logger LOG = Logger.getLogger(QuitHandler.class);



	@Execute
	public void execute(org.eclipse.ui.IWorkbench workbench, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		LOG.debug("execute()");
		if (MessageDialog.openConfirm(shell, "Confirmation", "Do you want to exit?")) {
			workbench.close();
		}
	}
}
