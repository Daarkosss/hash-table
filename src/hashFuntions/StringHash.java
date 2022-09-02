package hashFuntions;

public class StringHash implements HashFunction<String> {

    @Override
    public int hashCode(String object) {
        int hashCode = 0;
        for (int i = 0; i < object.length(); i++) {
            Character q = object.charAt(i);
            hashCode ^= q.hashCode();
            hashCode %= 9679;
        }

        return hashCode;
    }
}
