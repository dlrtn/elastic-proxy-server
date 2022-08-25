package indj.elasticsearch.proxyserver.business.elasticsearch.api;

import indj.elasticsearch.proxyserver.business.elasticsearch.application.ElasticSearchService;
import indj.elasticsearch.proxyserver.business.elasticsearch.domain.payload.SearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class ElasticSearchController {

    private final ElasticSearchService searchService;

    @PostMapping("/search")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean searchStation(SearchRequest request) {
        return searchService.searchData(request);
    }

}
