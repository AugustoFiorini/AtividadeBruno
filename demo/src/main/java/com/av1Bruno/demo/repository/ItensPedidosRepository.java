package com.av1Bruno.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.av1Bruno.demo.model.ItensPedidosModel;

@Repository
public interface ItensPedidosRepository extends JpaRepository<ItensPedidosModel, Integer>{

}
