package de.beyondjava.dynamicTree;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.TreeNode;

@Named
@SessionScoped
public class FolderBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private TreeNode root;

	public FolderBean() {
		PathBean path = new PathBean("/");
		root = new LazyLoadingTreeNode(path, (folder) -> listFoldersInFolder(folder));
	}

	public TreeNode getTreeNode() {
		return root;
	}

	public static List<PathBean> listFoldersInFolder(String parentFolder) {
		File[] folders = new File(parentFolder).listFiles(f -> f.isDirectory());
		if (null == folders) {
			return new ArrayList<PathBean>();
		}
		List<PathBean> result = new ArrayList<>();
		for (File f : folders) {
			result.add(new PathBean(f.getAbsolutePath()));
		}
		return result;
	}

	public void onNodeSelect() {
	}
}
