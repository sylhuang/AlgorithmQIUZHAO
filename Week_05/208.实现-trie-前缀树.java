/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
    Trie[] trieSet;
    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        this.trieSet = new Trie[26];
        this.isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (cur.trieSet[c - 'a'] == null) {
                cur.trieSet[c - 'a'] = new Trie();
            }

            cur = cur.trieSet[c - 'a'];
        }

        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (cur.trieSet[c - 'a'] == null) {
                return false;
            }

            cur = cur.trieSet[c - 'a'];
        }

        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (cur.trieSet[c - 'a'] == null) {
                return false;
            }

            cur = cur.trieSet[c - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

