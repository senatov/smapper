/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 8, 2016 - 12:46:39 AM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp.handlers
 * @file SaveHandler.java / SaveHandler
 ***********************************************************************************/

package com.senatov.smapperApp.handlers;



import java.lang.reflect.InvocationTargetException;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Shell;

public class SaveHandler {

	private static final Logger LOG = Logger.getLogger(SaveHandler.class);



	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {

		LOG.info("execute()");
		if (dirtyable == null) {
			return false;
		}
		return dirtyable.isDirty();
	}



	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		LOG.debug("execute()");
		MessageDialog.openInformation(shell, "Save command info:", "Save is clicked");
	}



	@Execute
	public void execute(IEclipseContext context, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named(IServiceConstants.ACTIVE_PART) final MContribution contribution)
					throws InvocationTargetException, InterruptedException {
		LOG.debug("execute()");
		final IEclipseContext pmContext = context.createChild();
		final ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		dialog.open();
		dialog.run(true, true, monitor -> {
			pmContext.set(IProgressMonitor.class.getName(), monitor);
			if (contribution != null) {
				final Object clientObject = contribution.getObject();
				ContextInjectionFactory.invoke(clientObject, Persist.class, pmContext, null);
			}
		});
		pmContext.dispose();
	}
}
