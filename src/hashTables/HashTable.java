package hashTables;

import hashFuntions.HashFunction;

import java.util.Comparator;

public abstract class HashTable<T> {
	
	protected final double maxLoadFactor;
	protected final Comparator<? super T> comparator;
	protected final HashFunction hashFunction;
	protected int size;
	protected Counter counter;


	protected HashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction hashFunction) {
		this.maxLoadFactor = maxLoadFactor;
		this.comparator = comparator;
		this.hashFunction = hashFunction;
		this.counter = new Counter();
	}
	
	public final double loadFactor() {
		return size() / ((double) capacity());
	}

	public int collisions() {
		return counter.getCollisions();
	}

	public int insertComparisons() {
		return counter.getInsertComparisons();
	}

	public int lookUpComparisons() {
		return counter.getLookUpComparisons();
	}

	public int hashFunctionEvaluations() {
		return counter.getHashFunctionEvaluations();
	}

	public HashFunction<T> getHashFunction() {
		return hashFunction;
	}

	public int size() {
		return size;
	}


	public abstract int capacity();
	public abstract void insert(T object);
	public abstract boolean lookUp(T object);
}
