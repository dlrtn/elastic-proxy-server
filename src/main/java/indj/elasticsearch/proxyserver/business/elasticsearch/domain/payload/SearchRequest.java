package indj.elasticsearch.proxyserver.business.elasticsearch.domain.payload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
@RequiredArgsConstructor
public class SearchRequest {

    private String id;

    private Map<String, String> params;

}
