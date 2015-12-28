package com.ichir.eclipse.logger.impl;

import org.slf4j.Logger;

import com.ichir.eclipse.logger.api.ILogger;

/**
 * slf4j logger delegate.
 * 
 * @author mahieddine.ichir@free.fr
 * @version 1.0.0
 */
public class Slf4jLogger implements ILogger {

	/**
	 * slf4j logger.
	 */
	private Logger logger;
	
	/**
	 * @param logger
	 */
	public Slf4jLogger(Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void debug(String message) {
		logger.debug(message);
	}

	@Override
	public void trace(String message) {
		logger.trace(message);
	}

	@Override
	public void info(String message) {
		logger.info(message);
	}

	@Override
	public void warn(String message) {
		logger.warn(message);
	}

	@Override
	public void error(String message) {
		logger.error(message);
	}

	@Override
	public void error(String message, Throwable e) {
		logger.error(message, e);
	}
}
