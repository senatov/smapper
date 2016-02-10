/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 10, 2016 - 3:31:39 PM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp
 * @file PerspectiveFactory1.java / PerspectiveFactory1
 ***********************************************************************************/
package com.senatov.smapperApp;



import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory1 implements IPerspectiveFactory {

	public static final String ID = "Perspective1";



	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);

		// IFolderLayout administrationFolder =
		// layout.createFolder("Administration",
		// IPageLayout.LEFT, 0.25f, editorArea); // Anderes Layout
		// IFolderLayout trainingFolder =
		// layout.createFolder("Administration", IPageLayout.LEFT, 0.5f,
		// editorArea);
		//
		// trainingFolder.addPlaceholder(VocabularyView.ID + ":*");
		// trainingFolder.addView(VocabularyView.ID);
		//
		// trainingFolder.addPlaceholder(ImportFileEditor.ID + ":*");
		// trainingFolder.addView(ImportFileEditor.ID);

	}

}
