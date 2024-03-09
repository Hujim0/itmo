package govnoParser;

public interface Serializable<T> {
    String serialize(int indent, Object input);
    T deserialize(String input);
}
