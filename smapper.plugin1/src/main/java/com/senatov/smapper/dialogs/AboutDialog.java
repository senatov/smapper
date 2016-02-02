/*************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 * @author Iakov
 * @since Feb 2, 2016 - 1:16:54 AM
 * PRJ: smapper.plugin1
 * PACKAGE:  com.senatov.smapper.dialogs
 * FILE: AboutDialog.java / AboutDialog
 *************************************************/
package com.senatov.smapper.dialogs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

import com.senatov.smapper.utils.RcpUtils;

import static java.lang.String.format;

public class AboutDialog extends Dialog {
	private static final String V_POINT = "v.";

	private static final String INSTALLED_ON = "Installed on:";

	private static final String ABOUT_SMAPPER = "About Smapper";

	private static final String VISIT_STR = "Visit our web site at: ";

	private static final int IMG_SCALED_TO = 64;

	private static final int FONT_SIZE = 17;

	private static final String PRG_NAME = "Smapper";

	public static final String SMAPPER_URL = "https://github.com/senatov/smapper/wiki";

	private static final String FONT_NAME = "Helvetica";

	private Image image = null;

	private static final Logger LOG = Logger.getLogger(AboutDialog.class);

	public AboutDialog(Shell _parentShell) {
		super(_parentShell);
		LOG.debug("AboutDialog()");
		try {
			URL url = new URL("platform:/plugin/smapper.plugin1/icons/128x128.gif");
			InputStream inputStream = url.openConnection().getInputStream();
			image = new Image(Display.getDefault(), inputStream);
			ImageData imgData = image.getImageData();
			imgData = imgData.scaledTo(IMG_SCALED_TO, IMG_SCALED_TO);
			image = new Image(Display.getDefault(), imgData);
		} catch (IOException e) {
			LOG.error("error " + e.getMessage());
		}

	}

	@Override
	public boolean close() {
		if (image != null) {
			image.dispose();
		}
		return super.close();
	}

	@Override
	protected Control createDialogArea(Composite parentComposite) {
		LOG.debug("createDialogArea()");
		final Composite parent = parentComposite;
		parent.setLayout(new GridLayout(1, false));
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout grid = new GridLayout(3, true);
		container.setLayout(grid);

		// picture-logo
		Label label = getLabel(container);
		label.setImage(image);
		label.setSize(label.computeSize(image.getImageData().height, image.getImageData().width));
		label.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, true, false, 0, 1));

		// programm name
		label = getLabel(container);
		label.setText(PRG_NAME);
		label.setFont(new Font(container.getDisplay(), FONT_NAME, FONT_SIZE, SWT.BOLD));
		label.setLayoutData(new GridData(GridData.END, GridData.BEGINNING, true, false, 1, 0));

		// ver.
		label = getLabel(container);
		label.setText(format("%s %s ", V_POINT, getProductVersion()));
		label.setFont(new Font(container.getDisplay(), FONT_NAME, FONT_SIZE - 1, SWT.NORMAL));
		label.setLayoutData(new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false, 1, 1));

		// path
		label = getLabel(container);
		label.setText(format("%s %s", INSTALLED_ON, getPath()));
		label.setFont(new Font(container.getDisplay(), FONT_NAME, 10, SWT.NORMAL));
		label.setLayoutData(new GridData(GridData.BEGINNING, GridData.END, true, true, 2, 0));

		Link link = new Link(container, SWT.NONE);
		link.setText(VISIT_STR + "<a href=\"" + SMAPPER_URL + "\">" + SMAPPER_URL + "</a>");
		link.setSize(link.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		link.setLayoutData(new GridData(GridData.BEGINNING, GridData.END, true, true, 3, 0));
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					RcpUtils.openInBrowser(new URL(e.text));
				} catch (IOException ex) {
					ex.printStackTrace();
					MessageDialog.openError(parent.getShell(), "Error", "Unable to open URL: " + SMAPPER_URL);
				}
			}
		});
		return container;
	}

	private Label getLabel(Composite container) {
		return new Label(container, SWT.NONE);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		LOG.debug("configureShell()");
		newShell.setText(format("%s %s %s", ABOUT_SMAPPER, V_POINT, getProductVersion()));
	}

	/**
	 * This method returns the bundleversion as a String
	 *
	 * @return version
	 */
	public static String getProductVersion() {
		LOG.debug("getProductVersion()");
		final IProduct product = Platform.getProduct();
		final Bundle bundle = product.getDefiningBundle();
		final Version version = bundle.getVersion();
		return version.toString();
	}

	/**
	 * This method returns the bundleversion as a String.
	 *
	 * @return version
	 */
	public static String getPath() {
		LOG.debug("getPath()");
		URL url = Platform.getInstanceLocation().getURL();
		try {
			url = FileLocator.resolve(url);
		} catch (IOException e) {
			LOG.error("error " + e.getMessage());
		}
		return new File(url.getFile()).getAbsolutePath();
	}

}