/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 10, 2016 - 11:00:11 PM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file Activator.java / Activator
 ***********************************************************************************/

package com.senatov.smapperApp;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The Class Activator.
 */
public class Activator extends AbstractUIPlugin implements BundleActivator {
	private static final String LOG2 = ".log";
	private static final String LOGS = "logs";
	private static final String LOG4J_FILE_PATTTERN = "%d{ISO8601} [%t] %-5p %c %x - %m%n";
	private static final String LOG4J_PROPERTIES = "log4j.properties";
	public static final String PLUGIN_ID = "com.senatov.smapperApp";
	final private List<PluginLogListener> pluginLogHooks = new ArrayList<PluginLogListener>();
	private static final Logger LOG = Logger.getLogger(Activator.class);
	private static BundleContext context = null;
	private static Activator plugin;



	/**
	 * The constructor.
	 */
	public Activator() {
		super();
		LOG.debug("Activator()");
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext )
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		LOG.debug("start()");
		Activator.context = bundleContext;
		plugin = this;
		initLog4j(context);
		LOG.debug("start()");
		super.start(context);
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		LOG.debug("stop()");
		Activator.context = null;
		plugin = null;
		super.stop(context);
	}



	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}



	/**
	 * Inits the log4j.
	 *
	 * @param context the context
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void initLog4j(BundleContext context) throws IOException {
		LOG.info("initLog4j()");
		final String log4jfile = LOG4J_PROPERTIES;
		final URL confURL = getBundle().getResource(log4jfile);
		String strConfigFile = FileLocator.toFileURL(confURL).getFile();
		BasicConfigurator.configure();
		PropertyConfigurator.configure(strConfigFile);
		String strLogPath = getLoggingFileFullPath(getBundle().getSymbolicName());
		final PatternLayout layout = new PatternLayout(LOG4J_FILE_PATTTERN);
		final RollingFileAppender fileAppender = new RollingFileAppender(layout, strLogPath);
		Logger.getRootLogger().addAppender(fileAppender);
		IPath resolvedURL = Platform.getLocation();
		LOG.info("Resolved URL " + resolvedURL.toOSString());
		LOG.info("Log4j initialized with " + confURL);
		hookPluginLoggers(context); // You need to add this method to hook other
									// plugins, described later...
	}



	/**
	 * <b>author</b> iase27698054 2015-03-16.
	 *
	 * @param strLogFileName the str log file name
	 * @return the logging file full path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private String getLoggingFileFullPath(String strLogFileName) throws IOException {
		LOG.info("getLoggingFileFullPath()");
		StringBuffer sbRet = new StringBuffer(0xFF);
		sbRet.append(getRootPath());
		sbRet.append(LOGS);
		sbRet.append(File.separator);
		sbRet.append(strLogFileName);
		sbRet.append(LOG2);
		return sbRet.toString();
	}



	/**
	 * <b>author</b> iase27698054 2015-03-16
	 *
	 * @return
	 * @throws IOException
	 */
	private String getRootPath() throws IOException {

		LOG.info("getRootPath()");
		return FileLocator.toFileURL(getBundle().getEntry("/")).getPath();
	}



	/**
	 * Hook all loaded bundles into the log4j framework.
	 *
	 * @param context the context
	 */
	private void hookPluginLoggers(final BundleContext context) {

		LOG.info("hookPluginLoggers()");
		for (final Bundle bundle : context.getBundles()) {
			final ILog pluginLogger = Platform.getLog(bundle);
			pluginLogHooks.add(new PluginLogListener(pluginLogger, Logger.getLogger(bundle.getSymbolicName())));
			LOG.info("Added logging hook for bundle: " + bundle.getSymbolicName());
		}
	}



	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {

		LOG.debug("getImageDescriptor()");
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}