package indj.elasticsearch.proxyserver.business.elasticsearch.api;

import indj.elasticsearch.proxyserver.business.elasticsearch.application.ElasticSearchService;
import indj.elasticsearch.proxyserver.business.elasticsearch.domain.payload.SearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class ElasticSearchController {

    private final ElasticSearchService searchService;

    @GetMapping("/search_station")
    public ResponseEntity<String> searchStation(@RequestBody SearchRequest request) {
        String searchIndex = "search_station";
        return searchService.searchData(request, searchIndex);
    }

    @GetMapping("/search_music_to_create")
    public ResponseEntity<String> searchMusic(@RequestBody SearchRequest request) {
        String searchIndex = "search_music_to_create";
        return searchService.searchData(request, searchIndex);
    }

    @GetMapping("/search_Dj")
    public ResponseEntity<String> searchDj(@RequestBody SearchRequest request) {
        String searchIndex = "search_Dj";
        return searchService.searchData(request, searchIndex);
    }

    @GetMapping("/search_Artist")
    public ResponseEntity<String> searchArtist(@RequestBody SearchRequest request) {
        String searchIndex = "search_Artist";
        return searchService.searchData(request, searchIndex);
    }

    @GetMapping("/style_tag")
    public ResponseEntity<String> searchStyleTag(@RequestBody SearchRequest request) {
        String searchIndex = "style_tag";
        return searchService.searchData(request, searchIndex);
    }

    @GetMapping("/search_tag")
    public ResponseEntity<String> searchTag(@RequestBody SearchRequest request) {
        String searchIndex = "search_tag";
        return searchService.searchData(request, searchIndex);
    }

}
