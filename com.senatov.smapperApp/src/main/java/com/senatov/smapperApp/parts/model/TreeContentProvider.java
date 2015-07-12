/*
 * JDK: 1.8.0_45
 * @author I. Senatov (Iakov)
 * DATE: 12.07.2015 22:36:11
 * PRJ: com.senatov.smapperApp
 * PACKAGE:com.senatov.smapperApp.parts.model
 * FILE: TreeContentProvider.java
 */


package com.senatov.smapperApp.parts.model;



import java.io.File;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;



// TODO: Auto-generated Javadoc
public class TreeContentProvider implements ITreeContentProvider {
	
	private static final Logger LOG = Logger.getLogger(TreeContentProvider.class );
	
	
	
	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object arg0 ) {
		
		return ((File ) arg0 ).listFiles();
	}
	
	
	
	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object arg0 ) {
		
		return ((File ) arg0 ).getParentFile();
	}
	
	
	
	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object arg0 ) {
		
		Object[] obj = getChildren(arg0 );
		return obj == null ? false : obj.length > 0;
	}
	
	
	
	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object arg0 ) {
		
		return File.listRoots();
	}
	
	
	
	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
	
	}
	
	
	
	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2 ) {
	
	}
}
