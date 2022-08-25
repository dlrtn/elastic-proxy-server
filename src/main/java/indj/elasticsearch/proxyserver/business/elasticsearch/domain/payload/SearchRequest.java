package indj.elasticsearch.proxyserver.business.elasticsearch.domain.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.MultiValueMap;

@Data
@ToString
public class SearchRequest {

    @JsonProperty("searchIndex")
    private String searchIndex;

    private String id;

    private MultiValueMap<String, String> params;

}
