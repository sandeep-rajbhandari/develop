import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

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
        builder build=new builder();
         SearchRequestBuilder builder=build.termFacet(client.client);
        listener l=new listener();
        builder.execute(l);

        //////////
       while (!l.isComplete.get());
        System.out.println("l = " + l.getResponse());
    }
}
