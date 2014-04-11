import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.SearchHit;

import javax.xml.ws.Response;

/**
 * Created by srajbhandari on 4/8/14.
 */
public class main {
    Client client;
    public main(){
        String clustername="esone";

        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", clustername).build();

        client = new TransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

    }
    public static void main(String args[]){
        main client=new main();
        MultiSearchRequestBuilder multiSearchRequestBuilder=client.client.prepareMultiSearch();


        builder build=new builder();

        SearchRequestBuilder builder=build.termFacet(client.client);
        listener l=new listener();
//        builder.execute(l);

        SearchRequestBuilder builder1=build.termFilter(client.client);
//        builder1.execute(l);

        multiSearchRequestBuilder.add(builder).add(builder1);
        multiSearchRequestBuilder.execute(l);
    //        for(SearchHit hit:l.getResponse().getHits().hits()){
//            System.out.println(hit.getSource());
//        }

        //////////
       while (!l.isComplete.get());
        //System.out.println("l = " + l.getResponse());
    }


}
