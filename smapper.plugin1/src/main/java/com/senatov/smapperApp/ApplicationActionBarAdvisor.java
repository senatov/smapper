/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 10, 2016 - 11:34:07 PM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file ApplicationActionBarAdvisor.java / ApplicationActionBarAdvisor
 ***********************************************************************************/
package com.senatov.smapperApp;



import org.apache.log4j.Logger;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * The Class ApplicationActionBarAdvisor.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction introAction;
	private static final Logger LOG = Logger.getLogger(ApplicationActionBarAdvisor.class);



	/**
	 * Instantiates a new application action bar advisor.
	 *
	 * @param configurer the configurer
	 */
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
		LOG.debug("ApplicationActionBarAdvisor()");
	}



	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.ActionBarAdvisor#makeActions(org.eclipse.ui.IWorkbenchWindow)
	 */
	@Override
	protected void makeActions(IWorkbenchWindow window) {
		LOG.debug("makeActions()");
		introAction = ActionFactory.INTRO.create(window);
		register(introAction);
	}



	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.ActionBarAdvisor#fillMenuBar(org.eclipse.jface.action.IMenuManager)
	 */
	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		LOG.debug("fillMenuBar()");
		MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
		menuBar.add(helpMenu);
		helpMenu.add(introAction);
	}

}
