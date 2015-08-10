/*
 * JDK: 1.8.0_45
 * @author I. Senatov (Iakov)
 * DATE: 15.07.2015 01:22:01
 * PRJ: com.senatov.smapperapp
 * PACKAGE:com.senatov.smapperapp.handlers
 * FILE: QuitHandler.java
 */


package com.senatov.smapperapp.handlers;



import javax.inject.Named;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;



public class QuitHandler {
	
	private static final Logger LOG = Logger.getLogger(QuitHandler.class );
	
	
	
	@Execute
	public void execute(IWorkbench workbench, @Named(IServiceConstants.ACTIVE_SHELL ) Shell shell) {
		
		LOG.debug("execute()" );
		if(MessageDialog.openConfirm(shell, "Confirmation",
		    "Do you want to exit?" ) ) {
			workbench.close();
		}
	}
}
