package hashTables;

import hashFuntions.HashFunction;

import java.util.*;

public class SeparateChainingHashTable<T> extends HashTable<T> {

    private LinkedList<T>[] array;

    public SeparateChainingHashTable(double maxLoadFactor, Comparator<? super T> comparator,
                                     HashFunction<T> hashFunction) {
        super(maxLoadFactor, comparator, hashFunction);
        array = new LinkedList[10];
        for(int i = 0; i < 10; i++) {
            array[i] = new LinkedList<>();
        }
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @Override
    public void insert(T object) {
        size++;
        if (loadFactor() >= maxLoadFactor) {
            extendArray();
        }

        counter.incrementhashFunctionEvaluations();
        int hashCode = hashFunction.hashCode(object) % array.length;

        if (!array[hashCode].isEmpty()) {
            counter.incrementCollisions();
        }

        boolean t = true;
        Iterator<T> iterator = array[hashCode].iterator();
        while (iterator.hasNext() && t) {
            counter.incrementInsertComparisons();
            if(comparator.compare(object, iterator.next()) == 0) {
                return;
            }
        }
        array[hashCode].add(object);
    }

    public void extendArray() {
        LinkedList<T>[] oldArray = array;
        array = new LinkedList[oldArray.length * 2];

        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedList<>();
        }
        for (LinkedList<T> list : oldArray) {
            for (T element : list) {
                insert(element);
                size--;
            }
        }
    }

    @Override
    public boolean lookUp(T object) {
        counter.incrementhashFunctionEvaluations();
        int hashCode = hashFunction.hashCode(object) % array.length;

        Iterator<T> iterator = array[hashCode].iterator();
        while (iterator.hasNext()) {
            counter.incrementLookUpComparisons();
            if(comparator.compare(object, iterator.next()) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        for(int i = 0; i < array.length; i++) {
            text.append(" | ");
            for(int j = 0; j < array[i].size(); j++) {
                text.append(array[i].get(j));
                if(j != array[i].size() - 1) {
                    text.append(", ");
                }
            }
            text.append(" |");
        }
        text.append(" ]");
        return text.toString();
    }
}
