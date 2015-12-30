package org.eclipse.ui.navigator;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class CommonNavigator extends ViewPart {

	private static final Logger LOG = Logger.getLogger(CommonNavigator.class);

	public CommonNavigator() {
		LOG.debug("CommonNavigator ()");
	}

	@Override
	public void createPartControl(Composite parent) {
		LOG.debug("createPartControl ()");

	}

	@Override
	public void setFocus() {
		LOG.debug("setFocus ()");

	}

}
