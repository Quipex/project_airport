package com.nc.airport.backend.persistence.eav.mutable2query.filtering2sorting.sorting;

import com.nc.airport.backend.persistence.eav.mutable2query.filtering2sorting.PropertiesEntityType;

import java.math.BigInteger;

public class SortEntity {

    private String type;
    private Boolean order;

    public SortEntity() {
    }

    /*sort by property*/
    public SortEntity(PropertiesEntityType type, Boolean order) {
        this.type = "O." + type.getType();
        this.order = order;
    }

    /*sort by field*/
    public SortEntity(BigInteger attrId, Boolean order) {
        this.type = "ATTR" + attrId;
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getOrder() {
        return order;
    }

    public void setOrder(Boolean order) {
        this.order = order;
    }
}
