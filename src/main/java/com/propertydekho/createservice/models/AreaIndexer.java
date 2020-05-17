package com.propertydekho.createservice.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaIndexer
{
    @JsonProperty("area")
    private String area;
    @JsonProperty("prop_detail")
    private PropFilterableSortableData propDetail;

    public AreaIndexer() {
    }

    public AreaIndexer(String area, PropFilterableSortableData propDetail) {
        this.area = area;
        this.propDetail = propDetail;
    }
}
