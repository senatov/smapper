/*
 * JDK: 1.8.0_45
 * @author I. Senatov (Iakov)
 * DATE: 26.07.2015 19:06:50
 * PRJ: com.senatov.smapper.app
 * PACKAGE:com.senatov.smapper.app
 * FILE: Activator.java
 */


package com.senatov.smapper.app;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.senatov.smapper.app.util.PluginLogListener;



/**
 * The Class Activator.
 */
public class Activator extends AbstractUIPlugin implements BundleActivator {
	
	private static final String LOG2 = ".log";
	private static final String LOGS = "logs";
	private static final String LOG4J_FILE_PATTTERN = "%d{ISO8601} [%t] %-5p %c %x - %m%n";
	private static final String LOG4J_PROPERTIES = "META-INF/log4j.properties";
	private static final Logger LOG = Logger.getLogger(Activator.class );
	public static final String PLUGIN_ID = "com.senatov.smapper.app";
	final private List<PluginLogListener> pluginLogHooks = new ArrayList<PluginLogListener>();
	private static Activator plugin;
	
	
	
	/**
	 * The constructor
	 */
	public Activator() {
		super();
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context ) throws Exception {
		
		initLog4j(context );
		LOG.debug("start()" );
		super.start(context );
		plugin = this;
	}
	
	
	
	/**
	 * Inits the log4j.
	 *
	 * @throws IOException
	 */
	private void initLog4j(BundleContext context ) throws IOException {
		
		final String log4jfile = LOG4J_PROPERTIES;
		final URL confURL = getBundle().getEntry(log4jfile );
		String strConfigFile = FileLocator.toFileURL(confURL ).getFile();
		PropertyConfigurator.configure(strConfigFile );
		String strLogPath = getLoggingFileFullPath(getBundle().getSymbolicName() );
		final PatternLayout layout = new PatternLayout(LOG4J_FILE_PATTTERN );
		final RollingFileAppender fileAppender = new RollingFileAppender(layout, strLogPath );
		Logger.getRootLogger().addAppender(fileAppender );
		// Location resolvedURL = Platform.getLocation();
		LOG.info("contextInitialized()" );
		LOG.info("Log4j initialized with " + confURL );
		hookPluginLoggers(context ); // You need to add this method to hook other plugins, described later...
	}
	
	
	
	/**
	 * <b>author</b> iase27698054 2015-03-16
	 *
	 * @param strLogFileName
	 * @return
	 * @throws IOException
	 */
	private String getLoggingFileFullPath(String strLogFileName ) throws IOException {
		
		StringBuffer sbRet = new StringBuffer(0xFF );
		sbRet.append(getRootPath() );
		sbRet.append(LOGS );
		sbRet.append(File.separator );
		sbRet.append(strLogFileName );
		sbRet.append(LOG2 );
		return sbRet.toString();
	}
	
	
	
	/**
	 * <br>
	 * <br>
	 * <b>author</b> iase27698054 2015-03-16
	 *
	 * @return
	 * @throws IOException
	 */
	private String getRootPath() throws IOException {
		
		return FileLocator.toFileURL(getBundle().getEntry("/" ) ).getPath();
	}
	
	
	
	/**
	 * Hook all loaded bundles into the log4j framework.
	 *
	 * @param context the context
	 */
	private void hookPluginLoggers(final BundleContext context ) {
		
		for(final Bundle bundle : context.getBundles() ) {
			final ILog pluginLogger = Platform.getLog(bundle );
			pluginLogHooks.add(new PluginLogListener(pluginLogger, Logger.getLogger(bundle.getSymbolicName() ) ) );
			LOG.info("Added logging hook for bundle: " + bundle.getSymbolicName() );
		}
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context ) throws Exception {
		
		LOG.debug("stop()" );
		plugin = null;
		super.stop(context );
	}
	
	
	
	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		
		LOG.debug("getDefault()" );
		return plugin;
	}
	
	
	
	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 *
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path ) {
		
		LOG.debug("getImageDescriptor()" );
		return imageDescriptorFromPlugin(PLUGIN_ID, path );
	}
}
