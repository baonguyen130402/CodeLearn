package com.env.gs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseProfile {
    private Integer courseProfileId;
    private Integer courseId;
    private Integer userid;
    private Date updateDate;
}
