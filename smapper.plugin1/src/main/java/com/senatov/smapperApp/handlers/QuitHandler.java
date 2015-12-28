/*
 * JDK: 1.8.0_45
 * @author I. Senatov (Iakov)
 * DATE: 15.07.2015 01:22:01
 * PRJ: com.senatov.smapperApp
 * PACKAGE:com.senatov.smapperApp.handlers
 * FILE: QuitHandler.java
 */

package com.senatov.smapperApp.handlers;



import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.ichir.eclipse.logger.api.ILogger;
import com.ichir.eclipse.logger.api.LoggerFactory;


public class QuitHandler {

	private static final ILogger LOG = LoggerFactory.getLogger(QuitHandler.class);


	@Execute
	public void execute(org.eclipse.ui.IWorkbench workbench, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		LOG.debug("execute()");
		if (MessageDialog.openConfirm(shell, "Confirmation", "Do you want to exit?")) {
			workbench.close();
		}
	}
}
