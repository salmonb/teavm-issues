package teavmissue.json.spi;

/**
 * @author Bruno Salmon
 */
public interface JsonWrapper {

    ElementType getNativeElementType(Object nativeElement);

    default <T> T anyNativeToJava(Object nativeElement) {
        switch (getNativeElementType(nativeElement)) {
            case STRING:
            case BOOLEAN:
            case NUMBER: return nativeToJavaScalar(nativeElement);
            case ARRAY:  return (T) nativeToJavaJsonArray(nativeElement);
            case OBJECT: return (T) nativeToJavaJsonObject(nativeElement);
            default:     return (T) nativeElement;
        }
    }

    default <T> T nativeToJavaScalar(Object nativeScalar) { return (T) nativeScalar; }

    default WritableJsonArray nativeToJavaJsonArray(Object nativeArray) { return  (WritableJsonArray) nativeArray; }

    default WritableJsonObject nativeToJavaJsonObject(Object nativeObject) { return (WritableJsonObject) nativeObject; }

    default Object anyJavaToNative(Object value) {
        if (value == null)
            return null;
        if (value instanceof JsonArray)
            return javaToNativeJsonArray((JsonArray) value);
        if (value instanceof JsonObject)
            return javaToNativeJsonObject((JsonObject) value);
        return javaToNativeScalar(value);
    }

    default Object javaToNativeScalar(Object scalar) { return scalar; }

    default Object javaToNativeJsonArray(JsonArray array) { return array.getNativeElement(); }

    default Object javaToNativeJsonObject(JsonObject object) { return object.getNativeElement(); }

}
