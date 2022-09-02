package testing;

public class Result {

    public int repetitions;
    public double loadFactor;
    public int collisions;
    public int insertComparisons;
    public int hashFunctionEvaluations;

    public Result(int repetitions) {
        this.repetitions = repetitions;
        loadFactor = 0;
        collisions = 0;
        insertComparisons = 0;
        hashFunctionEvaluations = 0;
    }

    public void add(double loadFactor, int collisions, int insertComparisons, int hashFunctionEvaluations) {
        this.loadFactor += loadFactor;
        this.collisions += collisions;
        this.insertComparisons += insertComparisons;
        this.hashFunctionEvaluations += hashFunctionEvaluations;
    }

    public void makeAverages() {
        loadFactor /= repetitions;
        collisions /= repetitions;
        insertComparisons /= repetitions;
        hashFunctionEvaluations /= repetitions;
    }

}
