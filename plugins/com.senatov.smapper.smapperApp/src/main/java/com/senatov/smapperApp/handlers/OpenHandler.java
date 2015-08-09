/*
 * JDK: 1.8.0_45
 * @author I. Senatov (Iakov)
 * DATE: 25.07.2015 13:14:34
 * PRJ: com.senatov.smapperApp
 * PACKAGE:com.senatov.smapperApp.handlers
 * FILE: OpenHandler.java
 */


package com.senatov.smapperApp.handlers;



import javax.inject.Named;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;



public class OpenHandler {
	
	private static final Logger LOG = Logger.getLogger(OpenHandler.class );
	
	
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL ) Shell shell) {
		
		LOG.debug("execute()" );
		MessageDialog.openInformation(shell, "Open info:", "Open is clicked" );
	}
}
