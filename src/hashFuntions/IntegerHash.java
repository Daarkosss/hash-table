package hashFuntions;

public class IntegerHash implements HashFunction<Integer> {

    @Override
    public int hashCode(Integer object) {
        int hashCode = 1;
        int number = object;
        int i = 0;
        while(number > 0) {
            int q = (number % 10) * (++i + 17);
            hashCode += q;
            hashCode %= 10000000;
            number /= 10;
        }

        return hashCode;
    }
}
