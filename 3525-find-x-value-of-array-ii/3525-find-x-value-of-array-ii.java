class Solution {
    class Node {
        int prod; 
        int[] freq; 
        
        Node(int k) {
            freq = new int[k];
            prod = 1;
        }
    }

    private Node[] tree;
    private int k;
    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        
        Node res = new Node(k);
        
        res.prod = (left.prod * right.prod) % k;
        for (int i = 0; i < k; i++) {
            res.freq[i] += left.freq[i];
        }
        for (int i = 0; i < k; i++) {
            if (right.freq[i] > 0) {
                int new_mod = (left.prod * i) % k;
                res.freq[new_mod] += right.freq[i];
            }
        }
        
        return res;
    }

    private void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            tree[node] = new Node(k);
            int modVal = nums[start] % k;
            tree[node].prod = modVal;
            tree[node].freq[modVal] = 1;
            return;
        }
        
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int modVal = val % k;
            tree[node].prod = modVal;
            for (int i = 0; i < k; i++) {
                tree[node].freq[i] = 0;
            }
            tree[node].freq[modVal] = 1;
            return;
        }
        
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return null; 
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        
        int mid = start + (end - start) / 2;
        Node left = query(2 * node, start, mid, l, r);
        Node right = query(2 * node + 1, mid + 1, end, l, r);
        
        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        this.k = k;

        tree = new Node[4 * n + 1];
        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int st = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);

            if (st >= n) {
                ans[i] = 0;
            } else {
                Node res = query(1, 0, n - 1, st, n - 1);
                ans[i] = (res == null) ? 0 : res.freq[x];
            }
        }
        
        return ans;
    }
}