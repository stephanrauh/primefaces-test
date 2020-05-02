package de.beyondjava.dynamicTree;


import java.util.List;
import java.util.stream.Collectors;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

public class LazyLoadingTreeNode extends DefaultTreeNode {
	
	private static final long serialVersionUID = 1L;
	
	private LazyLoadingTreeDataProvider service;
	private boolean childrenFetched;
	
	private static int DEBUG_COUNTER = 0;

	public LazyLoadingTreeNode(PathBean data, LazyLoadingTreeDataProvider service) {
		super(data);
		this.service = service;
	}

	@Override
	public List<TreeNode> getChildren() {
		ensureChildrenFetched();
		return super.getChildren();
	}

	@Override
	public int getChildCount() {
		ensureChildrenFetched();
		return super.getChildCount();
	}

	@Override
	public boolean isLeaf() {
		ensureChildrenFetched();
		return super.isLeaf();
	}

	private void ensureChildrenFetched() {
		if (!childrenFetched) {
			childrenFetched = true;
			String parentId = ((PathBean) getData()).getIdentifier();
			System.out.println(String.valueOf(DEBUG_COUNTER++) + parentId);
			List<LazyLoadingTreeNode> childNodes = service.findWithParent(parentId).stream()
					.map(PathBean -> new LazyLoadingTreeNode(PathBean, service)).collect(Collectors.toList());
			super.getChildren().addAll(childNodes);
		}
	}
}