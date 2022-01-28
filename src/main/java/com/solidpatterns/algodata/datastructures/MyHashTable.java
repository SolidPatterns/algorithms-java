package com.solidpatterns.algodata.datastructures;

import java.util.LinkedList;

public class MyHashTable<K extends Object, V extends Object> {

    private LinkedList<MyEntry<K, V>>[] hashArray;

    public MyHashTable() {
        this(100);
    }

    public MyHashTable(int size) {
        this.hashArray = new LinkedList[size];
    }

    public void add(K key, V value) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");

        int index = getHashArrayIndex(key);
        var entryLinkedList = hashArray[index];

        if (entryLinkedList == null) {
            entryLinkedList = initializeEntryLinkedList(index);
        }

        int entryIndex = getEntryIndex(entryLinkedList, key);

        MyEntry<K, V> newEntry = new MyEntry<>(key, value);
        if (entryIndex >= 0) {
            //found an existing entry, replace it with the new entry
            entryLinkedList.set(entryIndex, newEntry);
        } else {
            entryLinkedList.add(newEntry);
        }
    }

    private LinkedList<MyEntry<K, V>> initializeEntryLinkedList(int index) {
        LinkedList<MyEntry<K, V>> entryLinkedList;
        entryLinkedList = new LinkedList<>();
        hashArray[index] = entryLinkedList;
        return entryLinkedList;
    }

    public V get(K key) {
        LinkedList<MyEntry<K, V>> entryLinkedList = getEntryLinkedList(key);
        if (entryLinkedList == null) return null;

        var entry = entryLinkedList.stream().filter(x -> x.getKey() == key).findFirst().orElse(null);
        if (entry == null) return null;
        return entry.getValue();
    }

    public boolean remove(K key) {
        LinkedList<MyEntry<K, V>> entryLinkedList = getEntryLinkedList(key);
        if (entryLinkedList == null) return false;
        return entryLinkedList.removeIf(x -> x.getKey().equals(key));
    }

    private LinkedList<MyEntry<K, V>> getEntryLinkedList(K key) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");

        int index = getHashArrayIndex(key);
        var entryLinkedList = hashArray[index];

        if (entryLinkedList == null) return null;
        return entryLinkedList;
    }

    private int getEntryIndex(LinkedList<MyEntry<K, V>> entryLinkedList, K key) {
        for (int i = 0, entryLinkedListSize = entryLinkedList.size(); i < entryLinkedListSize; i++) {
            MyEntry<K, V> entry = entryLinkedList.get(i);
            if (entry.getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    private int getHashArrayIndex(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % hashArray.length;
    }

    private class MyEntry<K extends Object, V extends Object> {

        private final K key;
        private final V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
