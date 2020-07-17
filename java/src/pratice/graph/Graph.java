package pratice.graph;

import java.util.Set;

public interface Graph<T> {
	public boolean addVertex(T vertex);

	public boolean removeVertex(T vertex);

	public boolean connect(T vertex1, T vertex2);

	public boolean disconnect(T vertex1, T vertex2);

	public void traverse(T startVertex);

	public int size();

	public Set<T> getAllConnectedVertex(T vertex);

	interface Vertex<T> {
		public void setValue();

		public T getValue();

		public boolean isVisited();

		public void setVisited();
	}

}
