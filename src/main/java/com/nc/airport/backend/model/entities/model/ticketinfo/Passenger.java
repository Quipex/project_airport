package com.nc.airport.backend.model.entities.model.ticketinfo;

import com.nc.airport.backend.model.BaseEntity;
import com.nc.airport.backend.persistence.eav.annotations.ObjectType;
import com.nc.airport.backend.persistence.eav.annotations.attribute.value.ReferenceField;
import com.nc.airport.backend.persistence.eav.annotations.attribute.value.ValueField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@ObjectType(ID = "13")
@Getter
@Setter
@ToString(callSuper = true)
public class Passenger extends BaseEntity {

    @ValueField(ID = "38")
    private String firstName;

    @ValueField(ID = "39")
    private String lastName;

    @ReferenceField(ID = "40")
    private BigInteger passportId;
}
