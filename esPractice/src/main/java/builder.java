

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.facet.FacetBuilder;
import org.elasticsearch.search.facet.FacetBuilders;

/**
 * Created by srajbhandari on 4/8/14.
 */
public class builder {

    public SearchRequestBuilder termFacet(Client client){
        SearchRequestBuilder requestBuilder=client.prepareSearch("sports");
        requestBuilder.setTypes("athlete");
        requestBuilder.setSize(1);
        QueryBuilder queryBuilder= QueryBuilders.termQuery("sport","baseball");
        FacetBuilder facetBuilder= FacetBuilders.termsFacet("facet_term").field("name");
        requestBuilder.setQuery(queryBuilder);//add query
        requestBuilder.addFacet(facetBuilder);//add facet
        return requestBuilder;
    }

    public SearchRequestBuilder termFilter(Client client){
        SearchRequestBuilder requestBuilder=client.prepareSearch("sports");
        requestBuilder.setTypes("athlete");
        requestBuilder.setSize(4);
        FilterBuilder filterBuilder= FilterBuilders.termFilter("sport","baseball");//add filter
        requestBuilder.setPostFilter(filterBuilder);
        return requestBuilder;
    }

}
