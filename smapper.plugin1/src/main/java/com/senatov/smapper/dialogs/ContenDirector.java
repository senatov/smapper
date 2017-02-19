package com.senatov.smapper.dialogs;

import org.apache.log4j.Logger;
import org.eclipse.ui.intro.IntroContentDetector;


public class ContenDirector extends IntroContentDetector {
	private static final Logger LOG = Logger.getLogger(ContenDirector.class);
	public ContenDirector() {
		LOG.debug("ContenDirector()");
	}



	@Override
	public boolean isNewContentAvailable() {
		LOG.debug("isNewContentAvailable()");
		return false;
	}
}
