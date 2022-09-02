package incrementalFunctions;

public class LinearIncremental implements IncrementalFunction {

    @Override
    public int shift(int trial) {
        return trial;
    }
}
