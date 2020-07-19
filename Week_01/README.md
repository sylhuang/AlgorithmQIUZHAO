# 学习笔记

以前写题爱死磕，经常卡在一道题上很久，不仅题刷不了几道，还特别打击积极性，基本上坚持不了几天就开始摸鱼。自从学习了五毒神掌，刷题效率明显变高了，也有时间去看优秀的题解，学习了很多自己以前并不知道的解题思路，力扣的每日一题也能坚持下来了。拿这周的hard题来说，发现自己看到题目不再完全头脑发空还是很高兴的，感觉劲用对了方向。加上7天训练营的时间，两周的努力稍稍看到了些回报，之后还得继续加油！


## Priority Queue源码分析

Priority Queue的核心是Heap，是一个完全二叉树，它的构建使用了heapify()函数，由一个n/2的非叶子节点循环和一个约为树高的logn遍历组成，所以时间复杂度为O(nlogn)。增加一个元素和删除一个已知数组下标的元素都是遍历最大为树高的路径，O(logn)；而删除一个未知下标的元素则需要首先循环整个数组找到下标 O(n)，然后再删除这个已知下标的元素。

## 本周刷题记录
|  题目   | 编号 |
|---| ---|
|两数之和 | LeetCode 1|
|合并两个有序链表 | LeetCode 21|
|接雨水 | LeetCode 42|
|合并两个有序数组 | LeetCode 88|
|旋转数组 | LeetCode 189|
|设计循环双端队列 | LeetCode 641|
|两个数组的交集 II | LeetCode 350|
|三角形最小路径和 | LeetCode 120|
|不同的二叉搜索树 | LeetCode 96|
|判断二分图 | LeetCode 785|
|搜索插入位置 | LeetCode 35|
|交错字符串 | LeetCode 97|
|string sorting | LintCode 1153|
|Chess piece rotation | LintCode 1146|
|Associated Query | LintCode 1145|
|The month's days | LintCode 1141|
|Drop Eggs | LintCode 254|
|Final Discounted Price | LintCode 1852|
|Work Plan | LintCode 1147|
|Find Peak Element | LintCode 75|
|Grouping Options | LintCode 1834|
|good transfer | LintCode 1161|
|Longest Common Prefix III | LintCode 1159|
|Sliding Window Median | LintCode 360|
|Give change | LintCode 1503|
|Feature extraction | LintCode 1135|
|Automatic Proofreading Program | LintCode 1531|
|Majsoul on! | LintCode 1527|
|Triplet Subarray With Absolute Diff Less Than or Equal to Limit | LintCode 1529|