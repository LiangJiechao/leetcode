package offer.merituan2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        UnionFind uf = new UnionFind(n);
        String[] strs = br.readLine().split(" ");
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(strs[i]);
            uf.sz[i] = weights[i];
        }
        strs = br.readLine().split(" ");
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Integer.parseInt(strs[i]) - 1;
        }
        int[] res = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = uf.max;
            int k = rank[i];
            uf.max = Math.max(uf.max, weights[k]);
            if (k + 1 < n && flag[k + 1]) {
                uf.union(k, k + 1);
            }
            if (k > 0 && flag[k - 1]) {
                uf.union(k - 1, k);
            }
            flag[k] = true;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
}

class UnionFind {
    public int[] sz;
    public int[] parent;
    public int max = 0;

    public UnionFind(int n) {
        sz = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            sz[rootX] += sz[rootY];
            max = Math.max(max, sz[rootX]);
        }
    }
}