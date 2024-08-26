package com.env.gs.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    private String courseName;
    private String description;
    private int status;
    private Date updateDate;
    private float studyHours;
    private String level;
    private String thumbnailUrl;
}
