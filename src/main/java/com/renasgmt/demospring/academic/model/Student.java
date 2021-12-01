package com.renasgmt.demospring.academic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("students")
public class Student {
    @Id
    private String id;
    @Field(name = "student_id")
    private String studentId;
    @Field(name = "name")
    private String name;
    @Field(name = "address")
    private Address address;
    @Field(name = "place_of_birth")
    private String placeOfBirth;
    @Field(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Field(name = "sex")
    private String sex;
    @Field(name = "religion")
    private String religion;
    @Field(name = "major")
    private String major;
    @Field(name = "year")
    private String year;

}
