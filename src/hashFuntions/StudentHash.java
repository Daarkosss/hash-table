package hashFuntions;

public class StudentHash implements HashFunction<Student> {

    @Override
    public int hashCode(Student object) {
        int hashCode = 0;
        hashCode ^= object.getName().hashCode();
        hashCode ^= object.getSurname().hashCode();
        hashCode ^= object.getAge().hashCode();

        return Math.abs(hashCode);
    }
}
