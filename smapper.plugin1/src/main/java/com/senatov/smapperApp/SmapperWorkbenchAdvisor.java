/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 10, 2016 - 3:36:35 PM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file SmapperWorkbenchAdvisor.java / SmapperWorkbenchAdvisor
 ***********************************************************************************/
package com.senatov.smapperApp;



import org.apache.log4j.Logger;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class SmapperWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final Logger LOG = Logger.getLogger(SmapperWorkbenchAdvisor.class);



	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		LOG.debug("createWorkbenchWindowAdvisor()");
		return new SmapperWorkbenchWindowAdvisor(configurer);
	}



	@Override
	public String getInitialWindowPerspectiveId() {
		LOG.debug("getInitialWindowPerspectiveId()");
		return PerspectiveFactory1.ID;
	}
}
