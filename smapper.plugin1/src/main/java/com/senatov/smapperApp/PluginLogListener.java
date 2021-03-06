/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 10, 2016 - 11:38:34 PM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file PluginLogListener.java / PluginLogListener
 ***********************************************************************************/
package com.senatov.smapperApp;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;

/**
 * The listener interface for receiving pluginLog events. The class that is
 * interested in processing a pluginLog event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addPluginLogListener<code> method. When the pluginLog event
 * occurs, that object's appropriate method is invoked.
 *
 * @see PluginLogEvent
 */
public class PluginLogListener implements ILogListener {
	private ILog log;
	private Logger logger;



	/**
	 * Creates a new PluginLogListener. Saves the plug-in log and logger
	 * instance. Adds itself to the plug-in log.
	 *
	 * @param log the log
	 * @param logger logger instance
	 */
	public PluginLogListener(ILog log, Logger logger) {
		this.log = log;
		this.logger = logger;
		log.addLogListener(this);
	}



	/**
	 * Removes itself from the plug-in log, reset instance variables.
	 */
	void dispose() {
		if (log != null) {
			log.removeLogListener(this);
			log = null;
			logger = null;
		}
	}



	/**
	 * Log event happened. Translates status instance to Logger level and
	 * message. Status.ERROR - Level.ERROR Status.WARNING - Level.WARN
	 * Status.INFO - Level.INFO Status.CANCEL - Level.FATAL default -
	 * Level.DEBUG
	 *
	 * @param status Log Status
	 * @param plugin plug-in id
	 */
	@Override
	public void logging(IStatus status, String plugin) {
		if (null == logger || null == status) {
			return;
		}
		int severity = status.getSeverity();
		Level level = Level.DEBUG;
		if (severity == IStatus.ERROR) {
			level = Level.ERROR;
		}
		else if (severity == IStatus.WARNING) {
			level = Level.WARN;
		}
		else if (severity == IStatus.INFO) {
			level = Level.INFO;
		}
		else if (severity == IStatus.CANCEL) {
			level = Level.FATAL;
		}
		else {
			level = Level.DEBUG;
		}
		plugin = formatText(plugin);
		String statusPlugin = formatText(status.getPlugin());
		String statusMessage = formatText(status.getMessage());
		StringBuffer message = new StringBuffer();
		if (plugin != null) {
			message.append(plugin);
			message.append(" - ");
		}
		if (statusPlugin != null && (plugin == null || !statusPlugin.equals(plugin))) {
			message.append(statusPlugin);
			message.append(" - ");
		}
		message.append(status.getCode());
		if (statusMessage != null) {
			message.append(" - ");
			message.append(statusMessage);
		}
		logger.log(level, message.toString(), status.getException());
	}



	/**
	 * Format text.
	 *
	 * @param text the text
	 * @return the string
	 */
	static private String formatText(String text) {
		if (text != null) {
			text = text.trim();
			if (text.length() == 0) {
				return null;
			}
		}
		return text;
	}
}