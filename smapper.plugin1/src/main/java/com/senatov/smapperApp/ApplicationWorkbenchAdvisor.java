/*************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64




 * 
 * @author Iakov
 * @since Feb 7, 2016 - 4:13:02 PM PRJ: smapper.plugin1 PACKAGE:
 *        com.senatov.smapperApp FILE: ApplicationWorkbenchAdvisor.java /
 *        ApplicationWorkbenchAdvisor
 *************************************************/
package com.senatov.smapperApp;



import org.apache.log4j.Logger;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;

/**
 * The Class ApplicationWorkbenchAdvisor.
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final Logger LOG = Logger.getLogger(ApplicationWorkbenchAdvisor.class);
	private static final String PERSPECTIVE_ID = "com.senatov.smapperApp.parts.SamplePart";



	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId
	 * ()
	 */
	@Override
	public String getInitialWindowPerspectiveId() {
		LOG.debug("getInitialWindowPerspectiveId()");
		return PERSPECTIVE_ID;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.
	 * application.IWorkbenchConfigurer)
	 */
	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		LOG.debug("initialize()");
		configurer.setSaveAndRestore(true);
	}
}
