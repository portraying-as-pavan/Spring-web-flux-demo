package com.example.Task1.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor

@Data
@ToString

@Table("user")
public class User {
    @Id
    int id;
    String userName;
}
