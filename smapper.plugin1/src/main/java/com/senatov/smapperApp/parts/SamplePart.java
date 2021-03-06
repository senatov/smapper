/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 8, 2016 - 12:46:39 AM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp.parts
 * @file SamplePart.java / SamplePart
 ***********************************************************************************/

package com.senatov.smapperApp.parts;



import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.senatov.smapperApp.parts.model.FileTreeLabelProvider;
import com.senatov.smapperApp.parts.model.TreeContentProvider;

/**
 * The Class SamplePart.
 */
public class SamplePart {

	private static final Logger LOG = Logger.getLogger(SamplePart.class);



	/**
	 * Creates the composite.
	 *
	 * @param parent the parent
	 * @throws IOException
	 */
	@PostConstruct
	public void createComposite(Composite parent) {

		LOG.debug("createComposite()");
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		// 1
		createLTree(parent);
		// 2
		createRTree(parent);
		parent.setLayout(gridLayout);
	}



	/**
	 * Creates the first tree.
	 *
	 * @param pParent the parent
	 */
	private void createLTree(Composite pParent) {
		LOG.debug("createTree()");
		final Composite composite = new Composite(pParent, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		composite.setLayout(new GridLayout(1, false));
		final CheckboxTreeViewer pTreeViewer = new CheckboxTreeViewer(composite);
		pTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		pTreeViewer.setContentProvider(new TreeContentProvider());
		pTreeViewer.setLabelProvider(new FileTreeLabelProvider());
		pTreeViewer.setInput("root"); // pass a non-null that will be ignored
		// When user checks a checkbox in the tree, check all its children
		pTreeViewer.addCheckStateListener(event -> {
			if (event.getChecked()) {
				pTreeViewer.setSubtreeChecked(event.getElement(), true);
			}
		});
	}



	/**
	 * Creates the first tree.
	 *
	 * @param pParent the parent
	 */
	private void createRTree(Composite pParent) {

		LOG.debug("createRTree()");
		final Composite composite = new Composite(pParent, SWT.BAR);
		composite.setLayout(new GridLayout(1, false));
		final CheckboxTreeViewer pTreeViewer = new CheckboxTreeViewer(composite);
		pTreeViewer.setAutoExpandLevel(2);
		pTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		pTreeViewer.setContentProvider(new TreeContentProvider());
		pTreeViewer.setLabelProvider(new FileTreeLabelProvider());
		pTreeViewer.setInput("root"); // pass a non-null that will be ignored
		// When user checks a checkbox in the tree, check all its children
		pTreeViewer.addCheckStateListener(event -> {
			if (event.getChecked()) {
				pTreeViewer.setSubtreeChecked(event.getElement(), true);
			}
		});
	}



	/**
	 * Sets the focus.
	 */
	@Focus
	public void setFocus() {

		LOG.debug("setFocus()");
	}
}
