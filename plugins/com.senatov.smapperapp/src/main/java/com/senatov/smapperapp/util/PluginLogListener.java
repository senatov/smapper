package com.senatov.smapperapp.util;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;



/**
 * PluginLogListener This class is responsible for adding itself to the plug-in
 * logging framework and translating plug-in log requests to Logger events.
 *
 * @author Manoel Marques
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
	public PluginLogListener(ILog log, Logger logger ) {
		this.log = log;
		this.logger = logger;
		log.addLogListener(this );
	}



	/**
	 * Removes itself from the plug-in log, reset instance variables.
	 */
	void dispose() {
		if(this.log != null ) {
			this.log.removeLogListener(this );
			this.log = null;
			this.logger = null;
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
	public void logging(IStatus status, String plugin ) {
		if(null == this.logger || null == status ) return;
		int severity = status.getSeverity();
		Level level = Level.DEBUG;
		if(severity == IStatus.ERROR ) {
			level = Level.ERROR;
		}
		else if(severity == IStatus.WARNING ) {
			level = Level.WARN;
		}
		else if(severity == IStatus.INFO ) {
			level = Level.INFO;
		}
		else if(severity == IStatus.CANCEL ) {
			level = Level.FATAL;
		}
		else {
			level = Level.DEBUG;
		}
		plugin = formatText(plugin );
		String statusPlugin = formatText(status.getPlugin() );
		String statusMessage = formatText(status.getMessage() );
		StringBuffer message = new StringBuffer();
		if(plugin != null ) {
			message.append(plugin );
			message.append(" - " );
		}
		if(statusPlugin != null && (plugin == null || !statusPlugin.equals(plugin ) ) ) {
			message.append(statusPlugin );
			message.append(" - " );
		}
		message.append(status.getCode() );
		if(statusMessage != null ) {
			message.append(" - " );
			message.append(statusMessage );
		}
		this.logger.log(level, message.toString(), status.getException() );
	}



	/**
	 * Format text.
	 *
	 * @param text the text
	 * @return the string
	 */
	static private String formatText(String text ) {
		if(text != null ) {
			text = text.trim();
			if(text.length() == 0 ) return null;
		}
		return text;
	}
}
