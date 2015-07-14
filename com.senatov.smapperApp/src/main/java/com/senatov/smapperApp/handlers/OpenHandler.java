/*
 * JDK: 1.8.0_45
 * @author I. Senatov (Iakov)
 * DATE: 15.07.2015 01:22:01
 * PRJ: com.senatov.smapperApp
 * PACKAGE:com.senatov.smapperApp.handlers
 * FILE: OpenHandler.java
 */


package com.senatov.smapperApp.handlers;



import javax.inject.Named;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;



public class OpenHandler {
	
	private static final Logger LOG = Logger.getLogger(OpenHandler.class );
	
	
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL ) Shell shell) {
		
		LOG.debug("execute()" );
		FileDialog dialog = new FileDialog(shell );
		dialog.open();
	}
}
