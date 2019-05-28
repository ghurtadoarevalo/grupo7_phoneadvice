package com.tbd.phoneadvice.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfiguration{

//-------------------------------------- OJO: Aun no borrar --------------------------------------//

    /*
    private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchConfiguration.class);
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;
    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    @Bean
    public Client client() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("cluster.name", clusterName).build();
        @SuppressWarnings("resource")
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }
    */

}
