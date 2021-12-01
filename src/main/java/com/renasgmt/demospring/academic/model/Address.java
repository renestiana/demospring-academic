package com.renasgmt.demospring.academic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Field(name = "street")
    private String street;
    @Field(name = "sub_district1")
    private String subDistrict1;
    @Field(name = "sub_district2")
    private String subDistrict2;
    @Field(name = "district")
    private String district;
    @Field(name = "province")
    private String province;
    @Field(name = "postal_code")
    private String postalCode;
}
