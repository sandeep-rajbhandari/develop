import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.search.SearchResponse;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by srajbhandari on 4/8/14.
 */
public class listener implements ActionListener<SearchResponse>{
    AtomicBoolean isComplete=new AtomicBoolean(false);
    SearchResponse response;
    @Override
    public void onResponse(SearchResponse o) {
        isComplete.set(true);
        response=o;

    }

    @Override
    public void onFailure(Throwable e) {
        isComplete.set(true);

    }

    public AtomicBoolean getIsComplete() {
        return isComplete;
    }

    public SearchResponse getResponse() {
        return response;
    }
}
