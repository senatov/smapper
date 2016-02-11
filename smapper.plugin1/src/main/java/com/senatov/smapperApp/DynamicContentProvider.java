/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 10, 2016 - 11:37:50 PM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file DynamicContentProvider.java / DynamicContentProvider
 ***********************************************************************************/
package com.senatov.smapperApp;



import java.io.PrintWriter;
import java.util.Date;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.intro.config.IIntroContentProviderSite;
import org.eclipse.ui.intro.config.IIntroXHTMLContentProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * The Class DynamicContentProvider.
 */
public class DynamicContentProvider implements IIntroXHTMLContentProvider {

	private static final Logger LOG = Logger.getLogger(DynamicContentProvider.class);



	/* (non-Javadoc)
	 * @see org.eclipse.ui.intro.config.IIntroContentProvider#init(org.eclipse.ui.intro.config.IIntroContentProviderSite)
	 */
	@Override
	public void init(IIntroContentProviderSite site) {
		LOG.debug("init()");
	}



	/* (non-Javadoc)
	 * @see org.eclipse.ui.intro.config.IIntroContentProvider#createContent(java.lang.String, java.io.PrintWriter)
	 */
	@Override
	public void createContent(String id, PrintWriter out) {
		LOG.debug("createContent(2)");
	}



	/* (non-Javadoc)
	 * @see org.eclipse.ui.intro.config.IIntroContentProvider#createContent(java.lang.String, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	@Override
	public void createContent(String id, Composite parent, FormToolkit toolkit) {
		LOG.debug("createContent(3)");
	}



	private String getCurrentTimeString() {
		LOG.debug("getCurrentTimeString()");
		StringBuffer content = new StringBuffer("Dynamic content from Intro ContentProvider: ");
		content.append("Current time is: ");
		content.append(new Date(System.currentTimeMillis()));
		return content.toString();
	}



	/* (non-Javadoc)
	 * @see org.eclipse.ui.intro.config.IIntroXHTMLContentProvider#createContent(java.lang.String, org.w3c.dom.Element)
	 */
	@Override
	public void createContent(String id, Element parent) {
		LOG.debug("createContent(2)");
		Document dom = parent.getOwnerDocument();
		Element para = dom.createElement("p");
		para.setAttribute("id", "someDynamicContentId");
		para.appendChild(dom.createTextNode(getCurrentTimeString()));
		parent.appendChild(para);

	}



	/* (non-Javadoc)
	 * @see org.eclipse.ui.intro.config.IIntroContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		LOG.debug("dispose()");
	}

}
