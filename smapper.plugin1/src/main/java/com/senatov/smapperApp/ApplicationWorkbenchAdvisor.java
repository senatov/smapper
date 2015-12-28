package com.senatov.smapperApp;

import org.eclipse.ui.application.WorkbenchAdvisor;

import com.ichir.eclipse.logger.api.ILogger;
import com.ichir.eclipse.logger.api.LoggerFactory;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final ILogger LOG = LoggerFactory.getLogger(ApplicationWorkbenchAdvisor.class);

	@Override
	public String getInitialWindowPerspectiveId() {
		LOG.debug("getInitialWindowPerspectiveId()");
		return null;
	}

}

