package com.java.wiki.domain;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;

@Data
@ToString
public class TestObj {

    @Min(value = 0)
    private Integer num;

    @NotBlank
    private String testMessage;


}
