package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    Entry<String> root;

    public CustomTree() {
        root = new Entry<>("0");
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        String s = (String) o;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                if (currentElement.leftChild.elementName.equals(s)) {
                    currentElement.leftChild = null;
                    currentElement.checkChildren();
                    return true;
                } else {
                    queue.add(currentElement.leftChild);
                }
            }
            if (currentElement.rightChild != null) {
                if (currentElement.rightChild.elementName.equals(s)) {
                    currentElement.rightChild = null;
                    currentElement.checkChildren();
                    return true;
                } else {
                    queue.add(currentElement.rightChild);
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        if (root == null) {
            root = new Entry<>("");
            root.lineNumber = 0;
        }
        queue.add(root);
        int maxLine = 0;
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.lineNumber > maxLine) {
                maxLine = currentElement.lineNumber;
            }
            if (currentElement.leftChild != null) {
                queue.add(currentElement.leftChild);
            }
            if (currentElement.rightChild != null) {
                queue.add(currentElement.rightChild);
            }
        }
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.lineNumber >= maxLine - 1) {
                Entry<String> entry = new Entry<>(s);
                entry.lineNumber = currentElement.lineNumber + 1;
                if (currentElement.leftChild == null) {
                    currentElement.leftChild = entry;
                    currentElement.checkChildren();
                    return true;
                } else if (currentElement.rightChild == null) {
                    currentElement.rightChild = entry;
                    currentElement.checkChildren();
                    return true;
                }
            }
            if (currentElement.leftChild != null) {
                queue.add(currentElement.leftChild);
            }
            if (currentElement.rightChild != null) {
                queue.add(currentElement.rightChild);
            }
        }
        return false;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                if (currentElement.leftChild.elementName.equals(s)) {
                    return currentElement== root ? null : currentElement.elementName;
                } else {
                    queue.add(currentElement.leftChild);
                }
            }
            if (currentElement.rightChild != null) {
                if (currentElement.rightChild.elementName.equals(s)) {
                    return currentElement== root ? null : currentElement.elementName;
                } else {
                    queue.add(currentElement.rightChild);
                }
            }
        }
        return null;
    }


    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }
        public void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }
        public boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }
    }




    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
        //return null;
    }

    @Override
    public int size() {
        int size = 0;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (queue.size() != 0) {
            Entry<String> currentElement = queue.remove();
            if (currentElement.leftChild != null) {
                size++;
                queue.add(currentElement.leftChild);
            }
            if (currentElement.rightChild != null) {
                size++;
                queue.add(currentElement.rightChild);
            }
        }
        return size;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
        //return super.set(index, element);
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
        //super.add(index, element);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
        //return super.remove(index);
    }
}
