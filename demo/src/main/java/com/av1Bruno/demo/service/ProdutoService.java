package com.av1Bruno.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.av1Bruno.demo.dto.ProdutoDto;
import com.av1Bruno.demo.interfaces.IService;
import com.av1Bruno.demo.model.ProdutoModel;
import com.av1Bruno.demo.repository.ProdutoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdutoService implements IService<ProdutoDto, Integer> {

    final 
    ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ProdutoDto create(ProdutoDto entity) {
        log.info("PedidosService::create");
        log.debug("Valores: {}", entity);
        produtoRepository.save(null);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ProdutoDto read(Integer id) {
        log.info("ProdutoService::read(id)");
        log.debug("Valores: {}", id);

        Optional<ProdutoModel> produtoFound = produtoRepository.findById(id);
        ProdutoModel produtoQueVaiReceberObjetoTratado;

        if (produtoFound.isPresent()) {

            produtoQueVaiReceberObjetoTratado = produtoFound.get();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoDto> read() {
        log.info("PedidosService::read()");
        log.debug("Valores: sem parâmetros");

        // Pesquisa a lista de usuários
        List<ProdutoModel> produtoModels = produtoRepository.findAll();

        // Converter lista de List<ItensPedidoModel> >>> List<ItensPedidosDto>

        // Retornar a lista de DTOS (List<ItensPedidosDto)

        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ProdutoDto update(Integer id, ProdutoDto entity) {
        log.info("ProdutoService::update");
        log.debug("Valores: {} e {}", id, entity);

        Optional<ProdutoModel> produtoFound = produtoRepository.findById(id);
        ProdutoModel produtoPresente = new ProdutoModel();
        if (produtoFound.isPresent() && !produtoFound.isEmpty()) {
            produtoPresente = produtoFound.get();
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("ProdutoService::delete");
        log.debug("Valores:{}", id);

        produtoRepository.deleteById(id);
    }

}
