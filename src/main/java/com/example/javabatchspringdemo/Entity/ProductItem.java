package com.example.javabatchspringdemo.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table
@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "product_name")
    @Size(max = 30)
//    @NotNull
    private String name;

    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createTime;
}
