/*************************************************
 * Developed under: 1.8.0_60/Windows 10 amd64
 * @author Iakov
 * @since Jan 17, 2016 - 11:58:09 AM
 * PRJ: smapper.plugin1
 * PACKAGE:  com.senatov.smapperApp
 * FILE: Activator.java / Activator
 *************************************************/

package com.senatov.smapperApp;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.senatov.smapper.util.Utl;

/**
 * The Class Activator.
 */
public class Activator extends AbstractUIPlugin implements BundleActivator {

	private static final Logger LOG = Logger.getLogger(Activator.class);

	public static final String PLUGIN_ID = "com.senatov.smapperApp";
	private static Activator plugin;

	/**
	 * The constructor.
	 */
	public Activator() {
		super();
		Utl.initLog4j();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		LOG.debug("start()");
		super.start(context);
		plugin = this;
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
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {

		LOG.debug("getDefault()");
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
	public static ImageDescriptor getImageDescriptor(String path) {

		LOG.debug("getImageDescriptor()");
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Creates the controls.
	 *
	 * @param parent the parent
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		System.out.println(this.getClass().getSimpleName() + " @PostConstruct method called.");
	}

}
