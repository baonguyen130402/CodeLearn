package com.env.gs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "m_course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @Field(name = "courseId")
    private Integer courseId;
    @Field(name = "courseName")
    private String courseName;
    @Field(name = "description")
    private String description;
    @Field(name = "status")
    private int status;
    @Field(name = "updateDate")
    private Date updateDate;
    @Field(name = "studyHours")
    private float studyHours;
    @Field(name = "level")
    private String level;
    @Field(name = "thumbnailUrl")
    private String thumbnailUrl;
}
