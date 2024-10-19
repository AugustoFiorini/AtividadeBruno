package com.av1Bruno.demo.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.av1Bruno.demo.dto.PedidoDto;
import com.av1Bruno.demo.interfaces.IResource;
import com.av1Bruno.demo.service.PedidoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/Pedido")
public class PedidoResource implements IResource<PedidoDto, Integer>{

    @Autowired
    PedidoService pedidoService;

    @Override
    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public PedidoDto create(@RequestBody PedidoDto entity) {
        log.info("PedidosResource::inciado");
        log.debug("Valores: {}", entity);
        return pedidoService.create(entity);
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public PedidoDto get(@PathVariable Integer id) {
        log.info("PedidosResource::get(id)");
        log.debug("Valores: {}", id);
        return pedidoService.read(id);
    }

    @Override
    @GetMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<PedidoDto> get() {
        log.info("UserResource::get");
        log.debug("Valores: sem parâmetro");
        return pedidoService.read();
    }

    @Override
    @PutMapping(
        value = "/{id}",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public PedidoDto update(
            @PathVariable Integer id,
            @RequestBody PedidoDto entity) {
        log.info("ItensPedidosResource::update");
        log.debug("Valores:{} e {}", id, entity);
        return pedidoService.update(id, entity);
    }

    @Override
    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        log.info("ItensPedidosResource::update");
        log.debug("Valores: {}", id, id);
        pedidoService.delete(id);

    }

}
