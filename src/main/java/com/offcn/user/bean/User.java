package com.offcn.user.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "boot_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "UTC")
    @Column(name = "bir",nullable = true)
    private Date bir;
}
