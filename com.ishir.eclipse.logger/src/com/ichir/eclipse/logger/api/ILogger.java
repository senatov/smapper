package com.ichir.eclipse.logger.api;

/**
 * Logger API.
 * 
 * @author mahieddine.ichir@free.fr
 * @version 1.0.0
 */
public interface ILogger {

	/**
	 * log debug messages.
	 * @param message
	 */
	void debug(String message);

	/**
	 * log trace messages.
	 * @param message
	 */
	void trace(String message);

	/**
	 * log info messages.
	 * @param message
	 */
	void info(String message);

	/**
	 * log warn messages.
	 */
	void warn(String message);

	/**
	 * log error messages.
	 * @param message
	 */
	void error(String message);

	/**
	 * log Throwable objects (typically exceptions). 
	 * @param message
	 * @param e
	 */
	void error(String message, Throwable e);
}
