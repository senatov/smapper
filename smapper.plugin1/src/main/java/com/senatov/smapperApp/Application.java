/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 11, 2016 - 12:45:41 AM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file Application.java / Application
 ***********************************************************************************/
package com.senatov.smapperApp;



import org.apache.log4j.Logger;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	private static final Logger LOG = Logger.getLogger(Application.class);



	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	@Override
	public Object start(IApplicationContext context) throws Exception {
		LOG.debug("start()");
		Integer ret = -1;
		Display display = PlatformUI.createDisplay();
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display, new SmapperWorkbenchAdvisor());
			switch (returnCode) {
			case PlatformUI.RETURN_RESTART: {
				ret = IApplication.EXIT_RESTART;
				break;
			}
			default: {
				ret = IApplication.EXIT_OK;
			}
			}
		}
		finally {
			display.dispose();
		}
		return ret;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	@Override
	public void stop() {
		LOG.debug("stop()");
		if (!PlatformUI.isWorkbenchRunning()) {
			return;
		}
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();
		display.syncExec(() -> {
			if (!display.isDisposed()) {
				workbench.close();
			}
		});
	}
}