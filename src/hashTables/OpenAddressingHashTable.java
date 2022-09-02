package hashTables;

import hashFuntions.HashFunction;
import incrementalFunctions.IncrementalFunction;

import java.util.Comparator;

public class OpenAddressingHashTable<T> extends HashTable<T> {

    private T[] array;
    private IncrementalFunction incrementalFunction;

    public OpenAddressingHashTable(double maxLoadFactor, Comparator<? super T> comparator,
                                   HashFunction<T> hashFunction, IncrementalFunction incrementalFunction) {
        super(maxLoadFactor, comparator, hashFunction);
        this.incrementalFunction = incrementalFunction;
        array = (T[]) new Object[10];
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T object) {
        size++;
        if(loadFactor() >= maxLoadFactor) {
            extendArray();
        }

        counter.incrementhashFunctionEvaluations();
        int hashCode = hashFunction.hashCode(object) % array.length;
        int position = hashCode;
        if(array[position] != null) {
            counter.incrementCollisions();

            int trial = 1;
            while(array[position] != null && comparator.compare(object, array[position]) != 0) {
                counter.incrementInsertComparisons();
                position = Math.abs((hashCode + incrementalFunction.shift(++trial)) % array.length);
            }
        }

        if(array[position] == null) {
            array[position] = object;
        }
    }

    public void extendArray() {
        T[] oldArray = array;
        array = (T[]) new Object[oldArray.length * 2];
        for(T element: oldArray) {
            if(element != null) {
                insert(element);
                size--;
            }
        }
    }

    @Override
    public boolean lookUp(T object) {
        int hashCode = hashFunction.hashCode(object) % array.length;
        int trial = 0;
        int position = hashCode + incrementalFunction.shift(trial) % array.length;
        while(array[position] != null && comparator.compare(object, array[position]) != 0) {
            counter.incrementLookUpComparisons();
            position = hashCode + incrementalFunction.shift(++trial) % array.length;
        }

        if(array[position] != null) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[ ");
        for (int i = 0; i < array.length; i++) {
            text.append(array[i]);
            if(i != array.length - 1) {
                text.append(", ");
            }
        }
        text.append(" ]");
        return text.toString();
    }
}
