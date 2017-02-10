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
package org.eclipse.ui.navigator;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class CommonNavigator extends ViewPart {

	private static final Logger LOG = Logger.getLogger(CommonNavigator.class);

	public CommonNavigator() {
		LOG.debug("CommonNavigator ()");
	}

	@Override
	public void createPartControl(Composite parent) {
		LOG.debug("createPartControl ()");

	}

	@Override
	public void setFocus() {
		LOG.debug("setFocus ()");

	}

}
