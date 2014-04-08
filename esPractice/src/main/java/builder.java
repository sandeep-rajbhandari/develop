
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * Created by srajbhandari on 4/8/14.
 */
public class builder {
    public SearchRequestBuilder termFacet(Client client){
        SearchRequestBuilder requestBuilder=client.prepareSearch("sports");
        requestBuilder.setTypes("athlete");
        requestBuilder.setSize(1);
        QueryBuilder queryBuilder= QueryBuilders.termQuery("sport","baseball");
        requestBuilder.setQuery(queryBuilder);
        return requestBuilder;




    }

}
