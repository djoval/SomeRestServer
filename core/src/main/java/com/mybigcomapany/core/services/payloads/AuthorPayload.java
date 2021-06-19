package com.mybigcomapany.core.services.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybigcomapany.core.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorPayload {
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT)
    private LocalDateTime dayOfBirth;

}
