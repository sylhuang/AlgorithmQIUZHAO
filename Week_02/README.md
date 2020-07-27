# 学习笔记
这周刷题的最大感受就是对递归模板的生疏，经常想不明白如何协调结束条件与本层递归要处理的内容之间的关系，尤其体现在写完结束条件后却总得回头修改结束条件（比如树的叶子节点到底是应该结束于叶子节点本身，还是在null上返回等等）。这种小问题导致写题不能一气呵成，同时容易在细节地方出现bug。还得多练习。

在一些细节处理方面，比如如何通过backtrace反复利用同一个array或是list，还得多记忆优秀的代码。不然递归中总是要开新数组的操作看着十分冗余。

**！重点提醒自己！** 对于含end index的递归，初始化end是arr.length - 1不是arr.length。太傻了，老写同一个bug可还行。

## 本周刷题记录
|  题目   | 编号 |
|---| ---|
|组合 | LeetCode 77|
|二叉树的中序遍历 | LeetCode 94|
|从前序与中序遍历序列构造二叉树 | LeetCode 105|
|丑数 II | LeetCode 264|
|前k个高频元素 | LeetCode 347|
|n叉树的层序遍历 | LeetCode 429|
|矩阵中的最长递增路径 | LeetCode 329|
|分割数组的最大值 | LeetCode 410|
|除数博弈 | LeetCode 1025|
|最小路径和 | LeetCode 64|
|旋转数组的最小数字 | 剑指 Offer 11|
|不同的二叉搜索树 II | LeetCode 95|
|两数之和 II - 输入有序数组 | LeetCode 167|
|戳气球 | LeetCode 312|
|Recommended Results are Scattered | LintCode 1166|
|Reverse Words in a String | LintCode 53|
|Longest Substring Without Repeating Characters | LintCode 384|
