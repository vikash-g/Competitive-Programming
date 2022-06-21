/**
 * Union-Find (Disjoin Set) data structure implementation.
 *
 * @author Vikash Gupta <vikashgupta.1908@gmail.com>
 */
public class UnionFind {
    // The number of elements in Union-Find
    private int size;

    // The number of components in the Union-Find.
    private int numComponents;

    // id[i] points to the parent of i. If id[i] = i, then i is a root node.
    private int[] id;

    // Weight of each component (Weight can be anything, size or rank etc.)
    private int[] weight;

    UnionFind(int size) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("Size can't be less than or equal to 0.");
        }

        this.size = numComponents = size;
        id = new int[size];
        weight = new int[size];

        for (int i = 0; i < size; ++i) {
            id[i] = i; // Link to itself (self root)
            weight[i] = 1; // Each component is initially of size one.
        }
    }

    // Find which component 'p' belongs to.
    public int find(int p) {
        // Find the root of the component containing given node p.
        // Compress the path where each node points to its grandparent.
        // It reduces the component height by half which gives the better run time complexity.
        int root  = p;
        while (root != id[root]) {
            id[root] = id[id[root]];
            root = id[root];
        }
        return root;
    }

    // Connect components containing nodes u and v.
    public void union(int u, int v) {
        int root1 = find(p);
        int root2 = find(q);

        // Both nodes are in same component.
        if (root1 == root2) {
            return;
        }

        // Merge two components together.
        // Merge smaller component into the larger one.
        if (weight[root1] < weight[root2]) {
            weight[root2] += weight[root1];
            id[root1] = root2;
        } else {
            weight[root1] += weight[root2];
            id[root2] = root1;
        }

        // Since both the nodes are part of different components,
        // the number of components will decrease after merging both components.
        --numComponents;
    }

    // Returns whether or not the elements 'p' and 'q' are in the same component.
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Return the weight of the component 'p' belongs to.
    public int componentWeight(int p) {
        return weight[find(p)];
    }

    // Return the number of elements in this Union-Find object.
    public int size() {
        return size;
    }

    // Return the number of components in this Union-Find object.
    public int components() {
        return numComponents;
    }
}
