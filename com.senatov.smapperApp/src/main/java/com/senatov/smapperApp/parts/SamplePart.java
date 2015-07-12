/*
 * JDK: 1.8.0_45
 * @author I. Senatov (Iakov)
 * DATE: 12.07.2015 23:03:21
 * PRJ: com.senatov.smapperApp
 * PACKAGE:com.senatov.smapperApp.parts
 * FILE: SamplePart.java
 */


package com.senatov.smapperApp.parts;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.senatov.smapperApp.parts.model.FileTreeLabelProvider;
import com.senatov.smapperApp.parts.model.TreeContentProvider;
import com.senatov.smapperApp.util.PluginLogListener;



/**
 * The Class SamplePart.
 */
public class SamplePart {
	
	private static final String LOG4J_PROPERTIES = "META-INF/log4j.properties";
	private static final String LOG4J_FILE_PATTTERN = "%d{ISO8601} [%t] %-5p %c %x - %m%n";
	private static final Logger LOG = Logger.getLogger(SamplePart.class );
	public static final String PLUGIN_ID = "com.senatov.smapperApp.SamplePart";
	private Composite parent = null;
	final private List<PluginLogListener> pluginLogHooks = new ArrayList<PluginLogListener>();
	
	
	
	/**
	 * Creates the composite.
	 *
	 * @param parent
	 *            the parent
	 * @throws IOException
	 */
	@PostConstruct
	public void createComposite(Composite parent ) {
		
		try {
			initLog4j(null );
		}
		catch(final IOException e ) {
			System.out.println("Error:" + e.getMessage() );
		}
		LOG.debug("start()" );
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		parent.setLayout(gridLayout );
		// 1
		createTree(parent );
		// 2
		createTree(parent );
	}
	
	
	
	/**
	 * Creates the first tree.
	 *
	 * @param pParent
	 *            the parent
	 */
	private void createTree(Composite pParent ) {
		
		parent = pParent;
		final Composite composite = new Composite(pParent, SWT.BAR );
		composite.setLayout(new GridLayout(1, false ) );
		final CheckboxTreeViewer pTreeViewer = new CheckboxTreeViewer(composite );
		pTreeViewer.setAutoExpandLevel(2 );
		pTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH ) );
		pTreeViewer.setContentProvider(new TreeContentProvider() );
		pTreeViewer.setLabelProvider(new FileTreeLabelProvider() );
		pTreeViewer.setInput("root" ); // pass a non-null that will be ignored
		// When user checks a checkbox in the tree, check all its children
		pTreeViewer.addCheckStateListener(event -> {
			if(event.getChecked() ) {
				pTreeViewer.setSubtreeChecked(event.getElement(), true );
			}
		} );
	}
	
	
	
	/**
	 * Sets the focus.
	 */
	@Focus
	public void setFocus() {
		
		// treeViewer_right.getTree().setFocus();
		// treeViewer_right.getTree().setFocus();
	}
	
	
	
	/**
	 * Inits the log4j.
	 *
	 * @param context
	 *            the context
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void initLog4j(BundleContext context ) throws IOException {
		
		final String log4jfile = LOG4J_PROPERTIES;
		final URL confURL = getBundle().getEntry(log4jfile );
		// Define file appender with layout and output log file name
		final PatternLayout layout = new PatternLayout(LOG4J_FILE_PATTTERN );
		final String logPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "logs"
		                + File.separator + "addtBook.log";
		final RollingFileAppender fileAppender = new RollingFileAppender(layout, logPath );
		PropertyConfigurator.configure(FileLocator.toFileURL(confURL ).getFile() );
		LOG.debug("Logging using log4j and configuration " + FileLocator.toFileURL(confURL ).getFile() );
		Logger.getRootLogger().addAppender(fileAppender );
		hookPluginLoggers(context );
		LOG.info("contextInitialized()" );
		LOG.info("Log4j initialized with " + confURL );
	}
	
	
	
	/**
	 * <br>
	 * <br>
	 * <b>author</b> iase27698054 2015-03-16.
	 *
	 * @return the bundle
	 */
	private Bundle getBundle() {
		
		final Bundle bundle = Platform.getBundle(PLUGIN_ID );
		return bundle;
	}
	
	
	
	/**
	 * Hook plugin loggers.
	 *
	 * @param context
	 *            the context
	 */
	private void hookPluginLoggers(final BundleContext context ) {
		
		for(final Bundle bundle : context.getBundles() ) {
			final ILog pluginLogger = Platform.getLog(bundle );
			pluginLogHooks.add(new PluginLogListener(pluginLogger, Logger.getLogger(bundle.getSymbolicName() ) ) );
			LOG.info("Added logging hook for bundle: " + bundle.getSymbolicName() );
		}
	}
}
