/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    ListNode head;
    ListNode tail;
    int capacity;
    int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new ListNode();
        this.tail = new ListNode();

        this.head.prev = this.tail;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.tail.next = this.head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (!isFull()) {
            ListNode node = new ListNode(value);
            node.prev = this.head;
            node.next = this.head.next;
            node.next.prev = node;
            this.head.next = node;
            size++;
            return true;
        } else {
            return false;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (!isFull()) {
            ListNode node = new ListNode(value);
            node.prev = this.tail.prev;
            node.next = this.tail;
            node.prev.next = node;
            this.tail.prev = node;
            size++;
            return true;
        } else {
            return false;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (!isEmpty()) {
            this.head.next = this.head.next.next;
            this.head.next.prev = this.head;
            size--;
            return true;
        } else {
            return false;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (!isEmpty()) {
            this.tail.prev = this.tail.prev.prev;
            this.tail.prev.next = this.tail;
            size--;
            return true;
        } else {
            return false;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;

        return head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;

        return tail.prev.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

class ListNode {
    ListNode next;
    ListNode prev;
    int val;

    public ListNode() {
        this.next = null;
        this.prev = null;
    }

    public ListNode(int val) {
        this.next = null;
        this.prev = null;
        this.val = val;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

