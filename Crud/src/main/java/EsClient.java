import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.count.CountRequest;
import org.elasticsearch.action.count.CountResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.facet.FacetBuilders;
import org.elasticsearch.search.facet.terms.TermsFacet;

import static org.elasticsearch.common.xcontent.XContentFactory.*;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class EsClient {
    Client client;
    EsClient(){
        String clustername="elasticsearch_sandeep";

        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", clustername).build();

        client = new TransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));


    }
    public void makeQuery() {
//        FilterBuilder filters= FilterBuilders.andFilter(
//                FilterBuilders.termFilter("hobbies", "rollerblading"));
//        QueryBuilder searchQuery=QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(), filters);

        //index api
        try {
            IndexRequestBuilder in= client.prepareIndex("twitter", "tweet", "600")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("user", "kimchy")
                            .field("postDate", new Date())
                            .field("message", "trying out Elastic Search")
                            .endObject()
                    );
                    IndexResponse indexResponse=in.execute()
                    .actionGet();
            System.out.println("index response:"+indexResponse.getIndex());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        List<String> hobbies = new ArrayList();
//        hobbies.add(0, "rollerblading");
//        hobbies.add(1, "skating");
//        try {
//            IndexResponse response = client.prepareIndex("planet", "hacker", "1")
//                    .setSource(jsonBuilder()
//                            .startObject()
//                            .field("handle", "mark")
//                            .field("hobbies", hobbies)
//                            .endObject()
//                    )
//                    .execute()
//                    .actionGet();
//        } catch (IOException e) {
////            StackTrace();
//        }
//
//
        //get api
//        GetResponse getResponse = client.prepareGet("twitter", "tweet", "1")
//                .execute()
//                .actionGet();
//       System.out.println(getResponse);
//
//        //delete api
//        DeleteResponse deleteResponse = client.prepareDelete("twitter", "tweet", "1")
//                .execute()
//                .actionGet();
//
//        //bulk api
///*        BulkRequestBuilder bulkRequest = client.prepareBulk();
//        try {
//            bulkRequest.add(client.prepareIndex("twitter", "tweet", "1")
//                                    .setSource(jsonBuilder()
//                                    .startObject()
//                                        .field("user", "nishant")
//                                        .field("postDate", new Date())
//                                        .field()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }*/
//
//        //search api
//        SearchResponse searchResponseAll = client.prepareSearch().execute().actionGet();
//        System.out.println(searchResponseAll);
//
//
//
//        SearchRequestBuilder srb=client.prepareSearch("planet")
//                .setTypes("hacker")
//                .setQuery(QueryBuilders.matchQuery("hobbies", "rollerblading"))
////                .setPostFilter(filters)
//                .setSize(10);
////                .addFields();
////        FacetBuilder facet= FacetBuilders.termsFacet("a").field("");
//        SearchResponse searchResponse=srb.execute().actionGet();//JSON result
//        System.out.println(searchResponse);
//        for(SearchHit hit:searchResponse.getHits().hits()){
////            hit.getFields()
//            Map<String,Object> sourceMap=hit.getSource();
////            String id = hit.getId();
//            for(Map.Entry<String,Object> aentry:sourceMap.entrySet()){
////                System.out.println("key = " + aentry.getKey());
////                System.out.println("value = " + aentry.getValue());
//
//
//            }
//        }
//
//        //multisearch api
//        SearchRequestBuilder sb1 = client.prepareSearch()
//                .setQuery(QueryBuilders.queryString("ing"));
//        SearchRequestBuilder sb2 = client.prepareSearch()
//                .setQuery(QueryBuilders.matchQuery("handle", "mark"));
//        MultiSearchResponse sr = client.prepareMultiSearch()
//                .add(sb1)
//                .add(sb2)
//                .execute()
//                .actionGet();
//        long nbHits = 0;
//        for(MultiSearchResponse.Item item:sr.getResponses()){
//            SearchResponse multiSearchResponse = item.getResponse();
//            nbHits += multiSearchResponse.getHits().getTotalHits();
//        }
//
//
//        //count api
//        CountResponse countResponse = client.prepareCount("ing")
//                .setQuery(termQuery("_type", "hobbies"))
//                .execute()
//                .actionGet();
//        System.out.println(countResponse);
//
//        //filter facet
//
////        System.out.println(multiSea);
//
//
//       /* for(Facet fac:response.getFacets().facets()){
//            TermsFacet tf=(TermsFacet)fac;
//            for(TermsFacet.Entry aent:tf.getEntries()){
//                aent.getTerm();
//                aent.getCount();
//            }
//        }*/
////        System.out.println(response);


    }

    public void movieQuery(){
        SearchResponse searchResponse = client.prepareSearch()
                .setQuery(QueryBuilders.matchQuery("description", "hacking"))
                .addFacet(FacetBuilders.termsFacet("f")
                        .field("genre"))
                .execute()
                .actionGet();

//        TermsFacet f = (TermsFacet)searchResponse.getFacets().facetsAsMap().get("f");

//        f.getTotalCount();
//        f.getOtherCount();
//        f.getMissingCount();
//
//        for(TermsFacet.Entry entry:f){
//            entry.getTerm();
//            entry.getCount();
//
//        }

        System.out.println(searchResponse);

    }


    public void productQuery(){
        SearchResponse searchResponse = client.prepareSearch("products")
                .setQuery(QueryBuilders.matchAllQuery())
                .addFacet(FacetBuilders.rangeFacet("f")
                        .field("price")
                        .addUnboundedTo(4000))
                .execute()
                .actionGet();
        System.out.println(searchResponse);
    }
    public void searchTweet(){
        SearchRequestBuilder request=client.prepareSearch("twitter")
                .setTypes("tweet")
                .setQuery(QueryBuilders.matchQuery("user", "kimchy"));
        SearchResponse res=request.execute().actionGet();
        System.out.println("request:  "+request);
        System.out.println("response:  "+res);



    }
    public static void main(String[] args) {
        EsClient esc=new EsClient();
        System.out.println("Starting cluster.............");
      esc.makeQuery();
        esc.searchTweet();
//        esc.movieQuery();
       // esc.productQuery();
    }

}
