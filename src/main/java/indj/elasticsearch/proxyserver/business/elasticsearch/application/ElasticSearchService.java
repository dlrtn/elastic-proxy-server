package indj.elasticsearch.proxyserver.business.elasticsearch.application;

import indj.elasticsearch.proxyserver.business.elasticsearch.domain.payload.SearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.directory.SearchControls;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static indj.elasticsearch.proxyserver.business.elasticsearch.domain.ProxyServerConstants.*;

@Service
@Slf4j
public class ElasticSearchService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> searchData(SearchRequest request, String searchIndex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);

        log.info("searchIndex : " + searchIndex + "requestBody : " + request.getParams().toString());

        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(makeSearchRequestBody(request), headers);

        String url = String.format(BASIC_PATH, searchIndex);
        String result = restTemplate.postForObject(url, entity, String.class);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType(APPLICATION, JSON, StandardCharsets.UTF_8));

        return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
    }

    private Map<String, Object> makeSearchRequestBody(SearchRequest request) {
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, String> paramBody = new HashMap<>();

        requestBody.put("id", request.getId());

        paramBody.put("q", request.getParams().get("q"));
        paramBody.put("size", request.getParams().get("size"));
        paramBody.put("from", request.getParams().get("from"));
        requestBody.put("params", paramBody);

        return requestBody;

    }

}
