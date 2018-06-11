package sk.mnb.gm.iwillhave.domain;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.Wither;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Value
@Accessors(fluent = true)
@Builder(toBuilder = true)
@JsonAutoDetect(fieldVisibility = ANY)
@JsonInclude(NON_NULL)
public class RestaurantTable {

    @Wither
    private Long id;
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public RestaurantTable() {
        this.id = null;
        this.name = null;
        this.password = null;
    }

    public RestaurantTable(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

}
