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

