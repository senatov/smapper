package com.senatov.smapperApp.parts.model;

import java.io.File;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider implements ITreeContentProvider {
	@Override
	public Object[] getChildren(Object arg0) {
		return ((File) arg0).listFiles();
	}

	@Override
	public Object getParent(Object arg0) {
		return ((File) arg0).getParentFile();
	}

	@Override
	public boolean hasChildren(Object arg0) {
		Object[] obj = getChildren(arg0);
		return obj == null ? false : obj.length > 0;
	}

	@Override
	public Object[] getElements(Object arg0) {
		return File.listRoots();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
	}

}