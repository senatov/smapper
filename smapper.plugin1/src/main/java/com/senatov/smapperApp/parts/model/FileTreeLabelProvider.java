/***********************************************************************************
 * Developed under: 1.8.0_72/Windows 10 amd64
 *
 * @author Iakov
 * @since Feb 8, 2016 - 12:46:39 AM
 * @project smapper.plugin1
 * @package com.senatov.smapperApp.parts.model
 * @file FileTreeLabelProvider.java / FileTreeLabelProvider
 ***********************************************************************************/

package com.senatov.smapperApp.parts.model;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * The Class FileTreeLabelProvider.
 */
public class FileTreeLabelProvider implements ILabelProvider {

	private static final Logger LOG = Logger.getLogger(FileTreeLabelProvider.class);

	private final List<ILabelProviderListener> listeners;
	private Image file;
	private Image dir;



	/**
	 * Instantiates a new file tree label provider.
	 */
	public FileTreeLabelProvider() {
		LOG.debug("FileTreeLabelProvider ()");
		listeners = new ArrayList<ILabelProviderListener>();
		try {
			file = new Image(null, new FileInputStream(getPath("file.gif")));
			dir = new Image(null, new FileInputStream(getPath("directory.gif")));
		}
		catch (final FileNotFoundException e) {
			LOG.error(e.getMessage());
		}
	}



	/**
	 * create path to gif file. <br>
	 * <br>
	 * <b>author</b> iase27698054 2015-03-16
	 *
	 * @param strPath
	 * @return
	 */
	private String getPath(String strGifFileName) {

		LOG.debug("getPath ()");
		StringBuffer sbBuff = new StringBuffer(0x50);
		sbBuff.append(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
		sbBuff.append(File.separator);
		sbBuff.append("images");
		sbBuff.append(File.separator);
		sbBuff.append(strGifFileName);
		return sbBuff.toString();
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object arg0) {

		LOG.debug("getImage )");
		return ((File) arg0).isDirectory() ? dir : file;
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object arg0) {

		LOG.debug("getText");
		String text = ((File) arg0).getName();
		if (((File) arg0).getName().length() == 0) {
			text = ((File) arg0).getPath();
		}
		return text;
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.
	 * jface.viewers. ILabelProviderListener)
	 */
	@Override
	public void addListener(ILabelProviderListener arg0) {

		listeners.add(arg0);
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {

		// Dispose the images
		if (dir != null) {
			dir.dispose();
		}
		if (file != null) {
			file.dispose();
		}
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.
	 * Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {

		return false;
	}



	/*
	 * <br><br><b>author</b> iase27698054 2015-03-15
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.
	 * jface.viewers. ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
		// Auto-generated method stub

	}
}
