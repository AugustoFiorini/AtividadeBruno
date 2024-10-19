package com.av1Bruno.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.av1Bruno.demo.dto.ProdutoDto;
import com.av1Bruno.demo.interfaces.IResource;
import com.av1Bruno.demo.service.ProdutoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/Produto")
public class ProdutoResource implements IResource<ProdutoDto, Integer>{
    
    @Autowired
    ProdutoService produtoService;

    @Override
    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProdutoDto create(@RequestBody ProdutoDto entity) {
        log.info("ProdutoResource::inciado");
        log.debug("Valores: {}", entity);
        return produtoService.create(entity);
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProdutoDto get(@PathVariable Integer id) {
        log.info("ProdutoResource::get(id)");
        log.debug("Valores: {}", id);
        return produtoService.read(id);
    }

    @Override
    @GetMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<ProdutoDto> get() {
        log.info("ProdutoResource::get");
        log.debug("Valores: sem parâmetro");
        return produtoService.read();
    }

    @Override
    @PutMapping(
        value = "/{id}",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProdutoDto update(
            @PathVariable Integer id,
            @RequestBody ProdutoDto entity) {
        log.info("ProdutoResource::update");
        log.debug("Valores:{} e {}", id, entity);
        return produtoService.update(id, entity);
    }

    @Override
    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        log.info("ProdutoResource::update");
        log.debug("Valores: {}", id, id);
        produtoService.delete(id);

    }

}
