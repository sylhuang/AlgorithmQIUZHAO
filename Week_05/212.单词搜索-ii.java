import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Trie {
    private Trie[] link;
    boolean isEnd;

    public Trie() {
        this.link = new Trie[26];
        this.isEnd = false;
    }

    public void buildTrie(String s) {
        Trie tmp = this;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!tmp.hasLink(c)) tmp.setLink(c);

            tmp = tmp.getLink(c);
        }

        tmp.isEnd = true;
    }

    public Trie getLink(char c) {
        return this.link[c - 'a'];
    }

    public void setLink(char c) {
        this.link[c - 'a'] = new Trie();
    }

    public boolean hasLink(char c) {
        return this.getLink(c) != null;
    }
}

class Solution {
    Trie wordTrie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        if (board.length == 0 || board[0].length == 0) return res;

        for (String s : words) {
            wordTrie.buildTrie(s);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, new StringBuilder(), res, wordTrie);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, StringBuilder sb, List<String> res, Trie node) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || !node.hasLink(board[i][j])) return;

        char tmp = board[i][j];
        board[i][j] = '#';
        sb.append(tmp);
        
        Trie newNode = node.getLink(tmp);
        if (newNode.isEnd) {
            res.add(sb.toString());
            newNode.isEnd = false;
        }

        dfs(board, i + 1, j, sb, res, newNode);
        dfs(board, i - 1, j, sb, res, newNode);
        dfs(board, i, j + 1, sb, res, newNode);
        dfs(board,i, j - 1, sb, res, newNode);

        board[i][j] = tmp;
        sb.deleteCharAt(sb.length() - 1);
    }
}
// @lc code=end

