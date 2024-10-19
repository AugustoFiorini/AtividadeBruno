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
@Table(name = "Produto") 
public class ProdutoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;    

        @Column(name = "DESPRO")
        private String despro;

        @Column(name = "QDTEPRODUTO")
        private double qdteproduto;

        @Column(name = "VALPRODUTO", length = 50)
        private double valproduto;

}
