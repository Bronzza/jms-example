package com.example.jms_example.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HelloWorldMessage implements Serializable {

    private static final long serialVersionUID = -8873021750822269614L;

    private UUID id;
    private String message;
}
