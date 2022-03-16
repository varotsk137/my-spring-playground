package com.playground.mail.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomType implements Serializable {

    @NotNull
    private Integer typeId;

    @NotBlank
    private String name;

    @NotNull
    private String price;
}
