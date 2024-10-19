package com.av1Bruno.demo.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.av1Bruno.demo.dto.ItensPedidosDto;
import com.av1Bruno.demo.interfaces.IResource;
import com.av1Bruno.demo.service.ItensPedidosService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping( value = "/v1/ItensPedidos")
public class ItensPedidosResource implements IResource<ItensPedidosDto, Integer>{
    
    @Autowired
    ItensPedidosService ItensPedidoService;

    @Override
    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ItensPedidosDto create(@RequestBody ItensPedidosDto entity) {
        log.info("IntenPedidosResource::inciado");
        log.debug("Valores: {}", entity);
        return ItensPedidoService.create(entity);
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ItensPedidosDto get(@PathVariable Integer id) {
        log.info("IntenPedidosResource::get(id)");
        log.debug("Valores: {}", id);
        return ItensPedidoService.read(id);
    }

    @Override
    @GetMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<ItensPedidosDto> get() {
        log.info("UserResource::get");
        log.debug("Valores: sem parâmetro");
        return ItensPedidoService.read();
    }

    @Override
    @PutMapping(
        value = "/{id}",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ItensPedidosDto update(
            @PathVariable Integer id,
            @RequestBody ItensPedidosDto entity) {
        log.info("ItensPedidosResource::update");
        log.debug("Valores:{} e {}", id, entity);
        return ItensPedidoService.update(id, entity);
    }

    @Override
    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        log.info("ItensPedidosResource::update");
        log.debug("Valores: {}", id, id);
        ItensPedidoService.delete(id);

    }

   
}
