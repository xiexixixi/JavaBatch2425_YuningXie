package com.example.javabatchspringdemo.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createTime;
}
