package com.example.h2demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Permissions {
    private boolean read;
    private boolean write;
    private boolean execute;
}
