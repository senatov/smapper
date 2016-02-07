/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 8, 2016 - 12:46:38 AM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp.parts.model
 * @file TreeContentProvider.java / TreeContentProvider
 ***********************************************************************************/

package com.senatov.smapperApp.parts.model;



import java.io.File;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * The Class TreeContentProvider.
 */

public class TreeContentProvider implements ITreeContentProvider {

	private static final Logger LOG = Logger.getLogger(TreeContentProvider.class);



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 * Object)
	 */
	@Override
	public Object[] getChildren(Object arg0) {
		LOG.debug("getChildren ()");
		return ((File) arg0).listFiles();
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.
	 * Object)
	 */
	@Override
	public Object getParent(Object arg0) {
		LOG.debug("getParent ()");
		return ((File) arg0).getParentFile();
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 * Object)
	 */
	@Override
	public boolean hasChildren(Object arg0) {

		LOG.debug("hasChildren ()");
		boolean bRet = false;
		Object[] obj = getChildren(arg0);
		if (obj != null && obj.length > 0) {
			bRet = true;
		}
		return bRet;
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.
	 * Object)
	 */
	@Override
	public Object[] getElements(Object arg0) {

		LOG.debug("getElements ()");
		return File.listRoots();
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		LOG.debug("dispose ()");
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		LOG.debug("inputChanged ()");
	}
}
