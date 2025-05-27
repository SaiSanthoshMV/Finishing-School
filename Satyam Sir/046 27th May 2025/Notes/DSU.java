class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;
       if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
    }


    public void printParents() {
        for (int i = 0; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    public void printRanks() {
        for (int i = 0; i < rank.length; i++) {
            System.out.print(rank[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(10);

        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(4, 5);
        dsu.union(6, 7);
        dsu.union(5, 6);
        dsu.union(3, 7);

        System.out.println("Find(3): " + dsu.find(3));
        System.out.println("Find(6): " + dsu.find(6));

        System.out.print("Parents: ");
        dsu.printParents();
        System.out.print("Ranks: ");
        dsu.printRanks();
    }
}
