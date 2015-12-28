package com.ichir.eclipse.logger.api;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import com.ichir.eclipse.logger.Activator;
import com.ichir.eclipse.logger.impl.Slf4jLogger;

/**
 * {@link ILogger} factory.
 *
 * @author mahieddine.ichir@free.fr
 * @version 1.0.0
 */
@SuppressWarnings("rawtypes")
public abstract class LoggerFactory {

	/**
	 * Configured flag.
	 */
	private static boolean isConfigured;

	/**
	 * loggers repo/cache.
	 */
	private static Map<Class, ILogger> loggersRepository;

	/**
	 * Log4j filename.
	 */
	private static final String LOG4J_FILENAME = "log4j.properties";

	/**
	 * @param classname class name (typically caller class)
	 * @return logger
	 */
	public static ILogger getLogger(Class classname) {
		configure();
		if (loggersRepository.containsKey(classname)) {
			return loggersRepository.get(classname);
		} else {
			ILogger slf4jLogger = new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(classname));
			loggersRepository.put(classname, slf4jLogger);
			return slf4jLogger;
		}
	}

	/**
	 * Configure logger.
	 * @throws IOException
	 */
	private synchronized static void configure() {
		if (isConfigured) {
			return;
		}
		isConfigured = true;
		// initialize MAP (cache)
		loggersRepository = new HashMap<Class, ILogger>();
		// configure logger
		File file = new File(LOG4J_FILENAME);
		if (file.exists()) {
			PropertyConfigurator.configure(file.getAbsolutePath());
		} else {
			// configure from default: local resources
			URL entry = Activator.getDefault().getBundle().getEntry(LOG4J_FILENAME);
			PropertyConfigurator.configure(entry);
		}
	}
}
