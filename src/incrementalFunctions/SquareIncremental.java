package incrementalFunctions;

public class SquareIncremental implements IncrementalFunction {

    @Override
    public int shift(int trial) {
        if( (trial - 1) % 2 == 0 ) {
            return (trial+1)/2;
        }
        return -(trial+1)/2;
    }
}
