package com.senatov.smapperApp.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
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
	/**
	 * Creates the composite.
	 *
	 * @param parent
	 *            the parent
	 */
	@PostConstruct
	public void createComposite(Composite parent) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		parent.setLayout(gridLayout);
		// 1
		createTree(parent);
		// 2
		createTree(parent);
	}

	/**
	 * Creates the first tree.
	 *
	 * @param pParent
	 *            the parent
	 */
	private void createTree(Composite pParent) {
		Composite composite = new Composite(pParent, SWT.BAR);
		composite.setLayout(new GridLayout(1, false));
		final CheckboxTreeViewer pTreeViewer = new CheckboxTreeViewer(composite);
		pTreeViewer.setAutoExpandLevel(2);
		pTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		pTreeViewer.setContentProvider(new TreeContentProvider());
		pTreeViewer.setLabelProvider(new FileTreeLabelProvider());
		pTreeViewer.setInput("root"); // pass a non-null that will be ignored
		// When user checks a checkbox in the tree, check all its children
		pTreeViewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					pTreeViewer.setSubtreeChecked(event.getElement(), true);
				}
			}
		});
	}

	/**
	 * Sets the focus.
	 */
	@Focus
	public void setFocus() {
//		treeViewer_right.getTree().setFocus();
//		treeViewer_right.getTree().setFocus();
	}
}
