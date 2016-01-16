/*******************************************************************************
 * Copyright (c) 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*************************************************
 * Developed under: 1.8.0_60/Windows 10 amd64
 * @author Iakov
 * @since Dec 30, 2015 - 2:31:28 AM
 * PRJ: smapper.plugin1
 * PACKAGE:  com.senatov.smapperApp.handlers
 * FILE: OpenHandler.java / OpenHandler
 *************************************************/

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
	 * @param shell
	 *            the shell
	 */
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		LOG.debug("execute()");
		MessageDialog.openInformation(shell, "Open info:", "Open is clicked");
	}
}
