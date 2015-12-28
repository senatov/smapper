package org.eclipse.ui.navigator;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.ichir.eclipse.logger.api.ILogger;
import com.ichir.eclipse.logger.api.LoggerFactory;

public class CommonNavigator extends ViewPart {

	private static final ILogger LOG = LoggerFactory.getLogger(CommonNavigator.class);

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
