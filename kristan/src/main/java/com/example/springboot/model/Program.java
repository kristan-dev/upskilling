package com.example.springboot.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Program {
    private String programName;
    private String programId;
    private String programDesc;
}
