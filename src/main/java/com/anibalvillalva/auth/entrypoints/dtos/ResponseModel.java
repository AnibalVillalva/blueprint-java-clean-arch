package com.anibalvillalva.auth.entrypoints.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ResponseModel {

    @JsonProperty("code")
    private String code;
    @JsonProperty("description")
    private String description;
    @JsonProperty("report")
    private String report;

    public ResponseModel(final String code, final String description, final String report) {
        this.code = code;
        this.description = description;
        this.report = report;
    }
}
