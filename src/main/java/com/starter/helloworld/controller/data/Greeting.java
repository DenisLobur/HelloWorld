package com.starter.helloworld.controller.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Greeting {
    private long id;
    private String content;
}
