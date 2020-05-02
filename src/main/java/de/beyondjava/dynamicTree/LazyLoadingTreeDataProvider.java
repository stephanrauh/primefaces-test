package de.beyondjava.dynamicTree;


import java.util.List;

public interface LazyLoadingTreeDataProvider {
    List<PathBean> findWithParent(String parentId);
}