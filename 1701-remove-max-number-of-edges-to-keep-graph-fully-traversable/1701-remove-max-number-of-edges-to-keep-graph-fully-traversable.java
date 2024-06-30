public class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceUnionFind = new UnionFind(n);
        UnionFind bobUnionFind = new UnionFind(n);

        int edgesUsed = 0;

        // Process type 3 edges first (both Alice and Bob can use)
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (aliceUnionFind.union(edge[1] - 1, edge[2] - 1)) {
                    bobUnionFind.union(edge[1] - 1, edge[2] - 1);
                    edgesUsed++;
                }
            }
        }

        // Process type 1 edges (only Alice can use)
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (aliceUnionFind.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            }
        }

        // Process type 2 edges (only Bob can use)
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (bobUnionFind.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            }
        }

        // Check if both Alice and Bob can traverse the entire graph
        if (aliceUnionFind.getComponentCount() != 1 || bobUnionFind.getComponentCount() != 1) {
            return -1;
        }

        // Maximum number of edges to remove is total edges minus the ones we used
        return edges.length - edgesUsed;
    }

    // Union-Find (Disjoint Set Union) class
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int componentCount;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            componentCount = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            componentCount--;
            return true;
        }

        public int getComponentCount() {
            return componentCount;
        }
    }
}
