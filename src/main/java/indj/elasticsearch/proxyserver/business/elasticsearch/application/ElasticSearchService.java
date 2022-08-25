package indj.elasticsearch.proxyserver.business.elasticsearch.application;

import indj.elasticsearch.proxyserver.business.elasticsearch.domain.payload.SearchRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElasticSearchService {

    private final WebClient webClient = WebClient.create();

    public boolean searchData(SearchRequest request) {
        System.err.println(request.getParams());
        System.err.println(request.getSearchIndex());
        System.err.println(request.getId());

//
//        System.err.println(jsonString);
//
////        Mono<String> result = WebClient.create()
////                .method(HttpMethod.GET)
////                .uri("http://15.165.50.8:9200/" + param.get("searchIndex") + "/_search/template")
////                .accept(MediaType.APPLICATION_JSON)
////                .body(BodyInserters.fromValue(jsonString))
////                .retrieve()
////                .bodyToMono(String.class);
//
//        System.err.println(result);
//        return result;
        return true;
    }

}
