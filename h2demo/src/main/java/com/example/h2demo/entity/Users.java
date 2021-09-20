package com.example.h2demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table("users")
public class Users {
    @Id

    private int id;
    private String name;


    private Permissions permissions;
    //private JSONObject details;
}
