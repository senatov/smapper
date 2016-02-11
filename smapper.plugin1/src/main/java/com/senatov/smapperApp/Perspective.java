/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 11, 2016 - 1:06:43 AM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file Perspective.java / Perspective
 ***********************************************************************************/
package com.senatov.smapperApp;



import org.apache.log4j.Logger;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	private static final Logger LOG = Logger.getLogger(Perspective.class);



	@Override
	public void createInitialLayout(IPageLayout layout) {
		LOG.debug("createInitialLayout()");
	}
}
