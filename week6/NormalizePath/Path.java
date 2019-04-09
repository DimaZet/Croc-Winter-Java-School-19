import java.util.LinkedList;
import java.util.Iterator;

public class Path extends LinkedList<String> {

	private int dotdot = 0;
	private String path;

	private String filter (String[] parsed) {
		int j = 0;
		for (String p : parsed) {
			if (p.equals("..")) {
				if (size() > 0) {
					removeLast();
				} else {
					dotdot++;
				}
			} else if (p.equals(".")) {
				continue;
			} else {
				addLast(p);
			}
		}
		String ans = "";
		for (int i = 0; i < dotdot; i++) {
			addFirst("..");
		}
		Iterator<String> it = iterator();
		while (it.hasNext()) {
			ans += it.next();
			if (it.hasNext()) {
				ans += "/";
			}
		}
		return ans;
	}
	
	public Path(String path) {
		this.path = filter(path.split("/"));
	}

	public String toString() {
		return path;
	}
}

