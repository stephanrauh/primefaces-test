package de.beyondjava.dynamicTree;


public class PathBean {
	
	private String path;
	
	private String name;
	
	public PathBean(String path) {
		this.path = path;
		if (this.path.equals("/")) {
			this.name = this.path;
		} else {
			String[] breadcrumbs = path.split("/");
			this.name = breadcrumbs[breadcrumbs.length-1];
		}
		
 	}
	
	public String getIdentifier() {
		return path;
	}

	public String getName() {
		return name;
	}
		
	public String toString() {
		return path + " / " + name;
	}
}
