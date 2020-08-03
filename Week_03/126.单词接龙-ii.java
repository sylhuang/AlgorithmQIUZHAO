import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    Map<String, Boolean> visited = new HashMap<>();
    Map<String, List<String>> wordTree = new HashMap<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        buildTree(wordList);

        if (!visited.containsKey(endWord)) return res;

        Queue<List<String>> solutions = new LinkedList<>();
        List<String> sol = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        q.add(beginWord);
        sol.add(beginWord);
        solutions.add(sol);

        while (!q.isEmpty()) {
            String curWord = q.poll();
            List<String> solution = solutions.poll();

            if (curWord.equals(endWord)) {
                if (solution.size() > minLength) {
                    break;
                }

                res.add(solution);
                minLength = solution.size();
            }

            visited.put(curWord, true);

            for (String child : wordTree.get(curWord)) {

                if (!visited.get(child)) {
                    q.add(child);
                    solution.add(child);
                    solutions.add(new ArrayList<>(solution));
                    solution.remove(solution.size() - 1);
                }
            }
        }

        return res;
    }

    private void buildTree(List<String> wordList) {
        for (String from : wordList) {
            List<String> children = new ArrayList<>();

            for (String to : wordList) {
                if (!from.equals(to)) {
                    int count = 0;

                    for (int i = 0; i < from.length() && count <= 1; i++) {
                        if (from.charAt(i) != to.charAt(i)) {
                            count++;
                        }
                    }

                    if (count == 1) {
                        children.add(to);
                    }
                }
            }

            wordTree.put(from, children);
            visited.put(from, false);
        }
    }
}
// @lc code=end

