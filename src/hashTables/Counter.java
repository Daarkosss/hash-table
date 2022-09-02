package hashTables;

public class Counter {

    private int collisions;
    private int insertComparisons;
    private int lookUpComparisons;
    private int hashFunctionEvaluations;

    public Counter() {
        collisions = 0;
        insertComparisons = 0;
        lookUpComparisons = 0;
        hashFunctionEvaluations = 0;
    }
    
    public void incrementCollisions() {
        collisions++;
    }

    public void incrementInsertComparisons() {
        insertComparisons++;
    }

    public void incrementLookUpComparisons() {
        lookUpComparisons++;
    }

    public void incrementhashFunctionEvaluations() {
        hashFunctionEvaluations++;
    }

    public int getCollisions() {
        return collisions;
    }

    public int getInsertComparisons() {
        return insertComparisons;
    }

    public int getLookUpComparisons() {
        return lookUpComparisons;
    }

    public int getHashFunctionEvaluations() {
        return hashFunctionEvaluations;
    }



    
    
}
