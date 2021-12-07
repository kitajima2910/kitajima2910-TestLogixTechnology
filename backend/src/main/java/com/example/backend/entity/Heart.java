package com.example.backend.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@DynamicUpdate
@DynamicInsert
//@IdClass(HeartKey.class)
@Accessors(chain = true)
@Entity
@Table(name = "heart")
public class Heart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

//    @Embedded
//    private HeartKey heartKey;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private BigInteger id;
//
//    @Id
    @Column(name = "post_id")
    private BigInteger postId;

//    @Id
    @Column(name = "user_id")
    private BigInteger userId;

    @Column(name = "heart")
    private int heart;

}
