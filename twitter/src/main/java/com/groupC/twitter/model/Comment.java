package com.groupC.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column(name = "content",nullable = false,length = 100)
    private String commentText;

    private long imageId;
    private long userId;
    private long tweetId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(updatable = false,nullable = false)
    private User user;

    @ManyToOne(targetEntity = Tweet.class)
    @JoinColumn(updatable = false,nullable = false)
    private Tweet tweet;

    @CreatedDate
    private Date commentedAt;

    private String image;

//    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JsonIgnore
//    private List<Image> images = new ArrayList<>();

//    @ElementCollection
//    private Map<String, Date> imagess = new HashMap<>(4);

}
