package com.akademia.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post_categories")
public class PostCategory {
    @Id
    @GeneratedValue
    private Integer id;
    private Date dateCreated;
    private Date dateModified;

}
