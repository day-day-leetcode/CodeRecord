package com.liyzzz.leetcode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述
 *
 * @author Analyze
 * @version 1.0
 * @date 2024/03/14 21:05:21
 * @description lru 最近最少使用
 */
public class Day_240314_146 {
    /**
     * lru 最近最少使用
     */
    public static class LRUCache {
        /**
         * 双端链表节点
         */
        public static class DLinkNode {
            /**
             * 上一个节点
             */
            private DLinkNode prev;
            /**
             * 下一个节点
             */
            private DLinkNode next;
            /**
             * 缓存value
             */
            private int value;
            /**
             * 存key是为了上层删除节点时能删除key
             */
            private int key;

            public DLinkNode() {

            }

            public DLinkNode(DLinkNode prev, DLinkNode next, int key, int value) {
                this.key = key;
                this.prev = prev;
                this.next = next;
                this.value = value;
            }

        }

        private Map<Integer, DLinkNode> cache = new ConcurrentHashMap<>();
        private int capacity;
        private DLinkNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new DLinkNode();
            tail = new DLinkNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkNode dLinkNode = cache.get(key);
            if (dLinkNode == null) {
                return -1;
            }
            moveToHead(dLinkNode);
            return dLinkNode.value;
        }

        public void put(int key, int value) {
            DLinkNode dLinkNode = cache.get(key);
            if (dLinkNode == null) {
                //添加
                DLinkNode node = addToHead(new DLinkNode(null, null, key, value));
                cache.put(key, node);
                //检查是否超过
                checkAndTail();
            } else {
                //修改
                dLinkNode.value = value;
                DLinkNode node = moveToHead(dLinkNode);
                cache.put(key, node);
            }
        }

        private void checkAndTail() {
            if (cache.size() <= capacity) {
                return;
            }
            //超过需要移除
            DLinkNode last = tail.prev;
            remove(last);
            cache.remove(last.key);
        }

        public void remove(DLinkNode dLinkNode) {
            dLinkNode.prev.next = dLinkNode.next;
            dLinkNode.next.prev = dLinkNode.prev;
        }

        public DLinkNode addToHead(DLinkNode dLinkNode) {
            dLinkNode.next = head.next;
            dLinkNode.next.prev=dLinkNode;
            dLinkNode.prev = head;
            head.next = dLinkNode;
            return dLinkNode;
        }

        public DLinkNode moveToHead(DLinkNode dLinkNode) {
            remove(dLinkNode);
            return addToHead(dLinkNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 1);
        lruCache.put(3, 2);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        lruCache.put(4, 3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}
