/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 8, 2016 - 12:37:14 AM PRJ: smapper.plugin1 PACKAGE:
 *        com.senatov.smapper.utils FILE: RcpUtils.java / RcpUtils
 ***********************************************************************************/
package com.senatov.smapper.utils;



import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * This class provides methods generally useful within the context of RCP user
 * infaces.
 *
 * @author slutters
 */
public class RcpUtils {
	private static final Logger LOG = Logger.getLogger(RcpUtils.class);



	/**
	 * This method opens the provided URI with the native system's default
	 * browser if supported.
	 *
	 * @param uri the URI to open
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void openInBrowser(URI uri) throws IOException {
		LOG.debug("openInBrowser()");
		Desktop desktop = null;

		if (Desktop.isDesktopSupported()) {
			desktop = Desktop.getDesktop();
		}

		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			desktop.browse(uri);
		}
	}



	/**
	 * This method opens the provided URL with the native system's default
	 * browser if supported.
	 *
	 * @param url the url
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void openInBrowser(URL url) throws IOException {
		try {
			openInBrowser(url.toURI());
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}