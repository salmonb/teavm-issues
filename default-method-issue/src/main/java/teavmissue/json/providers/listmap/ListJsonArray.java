package teavmissue.json.providers.listmap;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public class ListJsonArray extends ListBasedJsonArray {

    protected List<Object> list;

    protected ListJsonArray() { // super constructor will call recreateEmptyNativeArray() to initialize the list
    }

    protected ListJsonArray(List<Object> list) {
        super(list);
    }

    @Override
    public List<Object> getList() {
        return list;
    }

    @Override
    protected void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public List<Object> getNativeElement() {
        return list;
    }

}
