package indj.elasticsearch.proxyserver.business.elasticsearch.application;

import indj.elasticsearch.proxyserver.business.elasticsearch.domain.payload.SearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

import static indj.elasticsearch.proxyserver.business.elasticsearch.domain.ProxyServerConstants.BASIC_PATH;

@Service
@Slf4j
public class ElasticSearchService {

    @Autowired
    private RestTemplate restTemplate;

    //@ResponseBody
    public ResponseEntity<String> searchData(SearchRequest request, String searchIndex) {
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        String jsonString = makeJsonStringByRequest(request);

        HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);

        String url = String.format(BASIC_PATH, searchIndex);
        String result = restTemplate.postForObject(url, entity, String.class);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
    }

    private String makeJsonStringByRequest(SearchRequest request) {
        return "{" + "\n" +
                "\"id\": " + "\"" + request.getId() + "\"," + "\n" +
                "\"params\": " + "\n" +
                "{" + "\n" +
                "\"q\": " + "\"" + request.getParams().get("q") + "\"," + "\n" +
                "\"size\": " + "\"" + request.getParams().get("size") + "\"," + "\n" +
                "\"from\": " + "\"" + request.getParams().get("from") + "\"" + "\n" +
                "}" + "\n" +
                "}";
    }

}
