import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Trie {
    Trie[] link;
    boolean isEnd;
    String str;

    public Trie() {
        this.link = new Trie[4];
        this.isEnd = false;
        this.str = "";
    }

    public void buildTrie(String s) {
        Trie tmp = this;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!tmp.hasLink(c)) tmp.setLink(c);

            tmp = tmp.getLink(c);
        }

        tmp.isEnd = true;
        tmp.str = s;
    }

    public void setLink(char c) {
        this.link[this.getLinkIndex(c)] = new Trie();
    }

    public Trie getLink(char c) {
        return this.link[this.getLinkIndex(c)];
    }

    public boolean hasLink(char c) {
        return this.getLink(c) != null;
    }

    public int getLinkIndex(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        if (c == 'T') return 3;

        return -1;
    }
}

class Solution {
    char[] gene = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Trie bankTrie = new Trie();

        for (String b : bank) {
            bankTrie.buildTrie(b);
        }

        Queue<String> q = new LinkedList<>();
        q.offer(start);

        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(end)) return count;

                findMutation(q, bankTrie, cur, 0, 0);
            }

            count++;
        }

        return -1;
    }

    private void findMutation(Queue<String> q, Trie node, String cur, int idx, int diff) {
        if (idx == cur.length()) {
            if (node.isEnd) {
                q.offer(node.str);
                node.isEnd = false;
            }

            return;
        }

        char c = cur.charAt(idx);

        if (node.hasLink(c)) {
            findMutation(q, node.getLink(c), cur, idx + 1, diff);
        }

        if (diff < 1) {
            for (char g : gene) {
                if (g != c && node.hasLink(g)) findMutation(q, node.getLink(g), cur, idx + 1, diff + 1);
            }
        }
    }
}
// @lc code=end

