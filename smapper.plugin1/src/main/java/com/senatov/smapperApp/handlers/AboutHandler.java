/*************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 * @author Iakov
 * @since Feb 4, 2016 - 4:49:35 AM
 * PRJ: smapper.plugin1
 * PACKAGE:  com.senatov.smapperApp.handlers
 * FILE: AboutHandler.java / AboutHandler
 *************************************************/
/*
 * JDK: 1.8.0_45
 * @author I. Senatov (Iakov)
 * DATE: 15.07.2015 01:22:01
 * PRJ: com.senatov.smapperApp
 * PACKAGE:com.senatov.smapperApp.handlers
 * FILE: AboutHandler.java
 */

package com.senatov.smapperApp.handlers;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

import com.senatov.smapper.dialogs.AboutDialogE4;

public class AboutHandler {

	private static final Logger LOG = Logger.getLogger(AboutHandler.class);

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		LOG.debug("execute()");
		AboutDialogE4 aboutDialog = new AboutDialogE4(shell);
		aboutDialog.open();
	}
}
