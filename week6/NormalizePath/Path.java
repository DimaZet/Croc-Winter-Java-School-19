import java.util.LinkedList;
import java.util.Iterator;

public class Path extends LinkedList<String> {

	private int dotdot = 0;
	private String start;
	private String path;

	private boolean isDirName(String checkme) {
		return !(checkme.equals(".") || checkme.equals(".."));
	}

	private String filter (String[] parsed) {
		int j = 0;
		if (isDirName(parsed[0])) {
			start = parsed[0]; 
		} else {
			start = null;
		}

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
				if (size() == 0 && dotdot == 1 && start != null && start.equals(p)) {
					dotdot = 0;
				}
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

