package com.amson.threadExecutorService.dto;

import com.amson.threadExecutorService.genericDto.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrudResponse<T> {

    private HttpStatus status;

    private String message;

    private ResponseData<T> data;
}
