package teavmissue.json.spi;


/**
 * @author Bruno Salmon
 */
public interface IndexedArray {

    /**
     * Length of the array or number of keys of the object
     */
    int size();

    /**
     * Returns the first index of the given value, or -1 if it cannot be found.
     */
    int indexOf(Object value);

    /**
     * Return the ith element of the array. Most consuming call.
     */
    <V> V getElement(int index);

    /**
     * Return the ith element of the array as a JsonObject. If the type is not an object, this can result in runtime errors.
     */
    default KeyObject getObject(int index) { return getElement(index); }

    /**
     * Return the ith element of the array as a JsonArray. If the type is not an array, this can result in runtime errors.
     */
    default IndexedArray getArray(int index) { return getElement(index); }

    default <T> T getScalar(int index) {
        return getElement(index);
    }

}
