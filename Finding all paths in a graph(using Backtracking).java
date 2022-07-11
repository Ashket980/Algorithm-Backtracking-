
import java.util.ArrayList;
import java.util.List;

public class all_paths {
	private int v;
	private ArrayList<Integer>[] adjList;

	public all_paths(int vertices) {
		this.v = vertices;
		initAdjList();
	}

	private void initAdjList() {
		adjList = new ArrayList[v];

		for (int i = 0; i < v; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
	}

	public void is_a_solution(int s, int d) {
		boolean[] isVisited = new boolean[v];
		ArrayList<Integer> pathList = new ArrayList<>();
		pathList.add(s);
		construct_candidate(s, d, isVisited, pathList);
	}

	private void construct_candidate(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {

		if (u.equals(d)) {
			System.out.println(localPathList);
			return;
		}
		isVisited[u] = true;
		for (Integer i : adjList[u]) {
			if (!isVisited[i]) {
				localPathList.add(i);
				construct_candidate(i, d, isVisited, localPathList);
				localPathList.remove(i);
			}
		}
		isVisited[u] = false;
	}

	public static void main(String[] args) {
		all_paths g = new all_paths(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);

		int s = 2;
		int d = 3;

		System.out.println("Following are all different paths from " + s + " to " + d);
		g.is_a_solution(s, d);
	}
}

//Output
//Following are all different paths from 2 to 3
//[2, 0, 1, 3]
//[2, 0, 3]
//[2, 1, 3]
