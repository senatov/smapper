/*************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 * @author Iakov
 * @since Feb 1, 2016 - 3:30:15 AM
 * PRJ: smapper.plugin1
 * PACKAGE:  com.senatov.smapper.dialogs
 * FILE: AboutDialog.java / AboutDialog
 *************************************************/
package com.senatov.smapper.dialogs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
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

public class AboutDialog extends Dialog {

	private static final String ABOUT_SMAPPER = "About Smapper";

	private static final String VISIT_STR = "Visit our web site at";

	private static final int IMG_SCALED_TO = 60;

	private static final int FONT_SIZE = 18;

	private static final String PRG_NAME = "Smapper";

	public static final String SMAPPER_URL = "https://github.com/senatov/smapper/wiki";

	private static final String FONT_NAME = "Helvetica";

	private Image image = null;

	@Inject
	IWorkbench workbench;

	public AboutDialog(Shell parentShell) {
		super(parentShell);

		try {
			URL url = new URL("platform:/plugin/smapper.plugin1/icons/128x128.gif");
			InputStream inputStream = url.openConnection().getInputStream();
			image = new Image(Display.getDefault(), inputStream);

			ImageData imgData = image.getImageData();
			imgData = imgData.scaledTo(IMG_SCALED_TO, IMG_SCALED_TO);
			image = new Image(Display.getDefault(), imgData);
		} catch (IOException e) {
			e.printStackTrace();
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
		final Composite parent = parentComposite;
		parent.setLayout(new GridLayout(1, false));
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, true));
		Composite composite = new Composite(container, SWT.NONE);

		FormLayout layout = new FormLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		composite.setLayout(layout);

		Label label1 = new Label(composite, SWT.NONE);
		label1.setImage(image);
		label1.setSize(label1.computeSize(10, 10));

		FormData formData = new FormData();
		formData.top = new FormAttachment(20, 0);
		label1.setLayoutData(formData);

		Label label2 = new Label(composite, SWT.NONE);
		label2.setText(PRG_NAME);
		label2.setFont(new Font(composite.getDisplay(), FONT_NAME, FONT_SIZE, SWT.BOLD));

		FormData formData2 = new FormData();
		formData2.left = new FormAttachment(label1, 10);
		formData2.bottom = new FormAttachment(label1, 0, SWT.BOTTOM);
		label2.setLayoutData(formData2);

		Label label3 = new Label(composite, SWT.NONE);
		label3.setText(getProductVersion());
		label3.setFont(new Font(composite.getDisplay(), FONT_NAME, FONT_SIZE, SWT.BOLD));

		FormData formData3 = new FormData();
		formData3.left = new FormAttachment(label2, 5);
		formData3.bottom = new FormAttachment(label1, -5, SWT.BOTTOM);
		label3.setLayoutData(formData3);

		Composite lower = new Composite(container, SWT.NONE);
		GridData gridData1;
		gridData1 = new GridData();
		gridData1.horizontalAlignment = SWT.FILL;
		lower.setLayout(new GridLayout(1, false));

		FormData formData4 = new FormData();
		formData4.left = new FormAttachment(label3, 5);
		formData4.bottom = new FormAttachment(label3, -5, SWT.BOTTOM);

		Label label4 = new Label(composite, SWT.NONE);
		label4.setText(getPath());
		label4.setFont(new Font(composite.getDisplay(), FONT_NAME, 11, SWT.NONE));
		label4.setLayoutData(formData4);

		Link link = new Link(lower, SWT.NONE);
		link.setText(VISIT_STR + "<a href=\"" + SMAPPER_URL + "\">" + SMAPPER_URL + "</a>");
		link.setSize(link.computeSize(SWT.DEFAULT, SWT.DEFAULT));
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

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(ABOUT_SMAPPER);
	}

	/**
	 * This method returns the bundleversion as a String
	 *
	 * @return version
	 */
	public static String getProductVersion() {
		final IProduct product = Platform.getProduct();
		final Bundle bundle = product.getDefiningBundle();
		final Version version = bundle.getVersion();
		return version.toString();
	}

	/**
	 * This method returns the bundleversion as a String
	 *
	 * @return version
	 */
	public static String getPath() {
		final URL url = Platform.getInstanceLocation().getURL();
		return url.getPath();
	}

}