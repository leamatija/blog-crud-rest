package com.akademia.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Date dateCreated;
    private Date dateModified;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

}
