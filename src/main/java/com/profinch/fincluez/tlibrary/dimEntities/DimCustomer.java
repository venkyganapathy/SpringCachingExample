package com.profinch.fincluez.tlibrary.dimEntities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class DimCustomer {

    @Id
    private String customerId;
    private String dimension_1;
    private String dimension_2;
    private String dimension_3;

}
