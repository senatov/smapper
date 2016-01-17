/*******************************************************************************
 * Copyright (c) 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.senatov.smapper.util;

import java.io.File;
import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.internal.registry.osgi.OSGIUtils;

import static java.lang.String.format;


public class Utl {

	private static final String LOG4J_CNF = "log4j.properties";

	public static void initLog4j() {
		URL prefix = OSGIUtils.getDefault().getConfigurationLocation().getURL();
		String filePath = format("%s/%s", prefix.getPath(), LOG4J_CNF);
		File f = new File(filePath);
		if (f != null) {
			PropertyConfigurator.configure(f.getAbsolutePath());
		}

	}

}
