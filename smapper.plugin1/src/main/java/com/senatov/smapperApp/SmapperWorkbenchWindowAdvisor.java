/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 10, 2016 - 3:35:43 PM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file SmapperWorkbenchWindowAdvisor.java / SmapperWorkbenchWindowAdvisor
 ***********************************************************************************/
package com.senatov.smapperApp;



import org.apache.log4j.Logger;
import org.eclipse.swt.graphics.Point;
// import org.eclipse.ui.application.ActionBarAdvisor;
// import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * The Class SmapperWorkbenchWindowAdvisor.
 */
public class SmapperWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	private static final Logger LOG = Logger.getLogger(SmapperWorkbenchWindowAdvisor.class);



	public SmapperWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
		LOG.debug("SmapperWorkbenchWindowAdvisor()");
	}



	/**
	 * Die Methode legt die Ausgangsgroesse fest und bestimmt, ob eine CoolBar,
	 * eine Statusleiste und eine Perspektiven- leiste angezeigt werden sollen.
	 */
	@Override
	public void preWindowOpen() {
		LOG.debug("preWindowOpen()");
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		// Startgroesse des Fensters festlegen:
		configurer.setInitialSize(new Point(1024, 768));
		// CoolBar anzeigen:
		configurer.setShowCoolBar(true);
		// Fuer den Updater P2:
		configurer.setShowStatusLine(true);
		configurer.setShowProgressIndicator(true);
		// Perspektiven umschalten via Symbolleiste
		configurer.setShowPerspectiveBar(true);
		// Titel setzen (kommt sonst aus der plugin.xml)
		configurer.setTitle("Smapper I");
	}

}
