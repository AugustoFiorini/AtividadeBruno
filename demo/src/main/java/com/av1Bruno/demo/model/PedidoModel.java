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
@Table(name = "Pedido") 
public class PedidoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;

        @Column(name = "NROPEDIDO")
        private Long nropedido;

        @Column(name = "DATPEDIDODATE")
        private int datpedidodate;

}
