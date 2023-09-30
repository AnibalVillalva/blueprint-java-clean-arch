package com.anibalvillalva.auth.entrypoints.dtos;

import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ErrorMessage {
    @JsonProperty("status")
    private int status;

    @JsonProperty("error")
    private String error;

    @JsonProperty("message")
    private String message;

    @JsonProperty("source")
    private String source;

    public ErrorMessage(InvalidAccountException e) {
        this.error = HttpStatus.BAD_REQUEST.toString();
        this.status = HttpStatus.BAD_REQUEST.value();
        this.message = e.getMessage();
        this.source = e.getApi();
    }

    public ErrorMessage(Exception e) {
        this.error = HttpStatus.BAD_REQUEST.toString();
        this.status = HttpStatus.BAD_REQUEST.value();
        this.message = e.getMessage();
    }

    public ResponseEntity toResponseEntity() {
        return ResponseEntity.status(this.status)
                .body(this);
    }
}
