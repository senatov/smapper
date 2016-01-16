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
package com.senatov.smapperApp;

import org.apache.log4j.Logger;
import org.eclipse.ui.application.WorkbenchAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final Logger LOG = Logger.getLogger(ApplicationWorkbenchAdvisor.class);

	@Override
	public String getInitialWindowPerspectiveId() {
		LOG.debug("getInitialWindowPerspectiveId()");
		return null;
	}

}

