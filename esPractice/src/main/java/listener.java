import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchResponse;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by srajbhandari on 4/8/14.
 */
public class listener implements ActionListener<MultiSearchResponse>{
    AtomicBoolean isComplete=new AtomicBoolean(false);
    SearchResponse response;
    @Override
    public void onResponse(MultiSearchResponse o) {
        for (MultiSearchResponse.Item item : o) {
            System.out.println("item = " + item.getResponse());
        }
//        response=o;
        isComplete.set(true);

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
