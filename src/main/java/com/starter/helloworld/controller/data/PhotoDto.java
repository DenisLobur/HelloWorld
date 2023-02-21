package com.starter.helloworld.controller.data;

import lombok.Data;

@Data
public class PhotoDto {
    private Long id;
    private String url;
    private String description;
}
