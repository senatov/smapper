package com.senatov.smapperApp.parts.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class FileTreeLabelProvider implements ILabelProvider {
	private final List listeners;

	private Image file;

	private Image dir;

	public FileTreeLabelProvider() {
		listeners = new ArrayList();

		try {
			file = new Image(null, new FileInputStream("images/file.gif"));
			dir = new Image(null, new FileInputStream("images/directory.gif"));
		} catch (FileNotFoundException e) {
		}
	}

	@Override
	public Image getImage(Object arg0) {
		return ((File) arg0).isDirectory() ? dir : file;
	}

	@Override
	public String getText(Object arg0) {
		String text = ((File) arg0).getName();

		if (((File) arg0).getName().length() == 0) {
			text = ((File) arg0).getPath();
		}
		return text;
	}

	@Override
	public void addListener(ILabelProviderListener arg0) {
		listeners.add(arg0);
	}

	@Override
	public void dispose() {
		// Dispose the images
		if (dir != null)
			dir.dispose();
		if (file != null)
			file.dispose();
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// Auto-generated method stub

	}
}