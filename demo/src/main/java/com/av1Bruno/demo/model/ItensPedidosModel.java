package com.av1Bruno.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ItensPedido") 
public class ItensPedidosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "QDTEITEM", nullable = false) 
    private double qtdeitem;

    @Column(name = "VALUNIDADE", nullable = false) 
    private double valunidade;
}
