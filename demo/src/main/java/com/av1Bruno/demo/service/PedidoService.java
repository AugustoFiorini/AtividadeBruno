package com.av1Bruno.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.av1Bruno.demo.dto.PedidoDto;
import com.av1Bruno.demo.interfaces.IService;
import com.av1Bruno.demo.model.PedidoModel;
import com.av1Bruno.demo.repository.PedidoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PedidoService implements IService<PedidoDto, Integer> {

    final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public PedidoDto create(PedidoDto entity) {
        log.info("PedidosService::create");
        log.debug("Valores: {}", entity);
        pedidoRepository.save(null);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public PedidoDto read(Integer id) {
        log.info("PedidosService::read(id)");
        log.debug("Valores: {}", id);

        Optional<PedidoModel> pedidoFound = pedidoRepository.findById(id);
        PedidoModel pedidoQueVaiReceberObjetoTratado;

        if (pedidoFound.isPresent()) {

            pedidoQueVaiReceberObjetoTratado = pedidoFound.get();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoDto> read() {
        log.info("PedidosService::read()");
        log.debug("Valores: sem parâmetros");

        // Pesquisa a lista de usuários
        List<PedidoModel> pedidoModels = pedidoRepository.findAll();

        // Converter lista de List<ItensPedidoModel> >>> List<ItensPedidosDto>

        // Retornar a lista de DTOS (List<ItensPedidosDto)

        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public PedidoDto update(Integer id, PedidoDto entity) {
        log.info("ItensPedidosService::update");
        log.debug("Valores: {} e {}", id, entity);

        Optional<PedidoModel> pedidoFound = pedidoRepository.findById(id);
        PedidoModel pedidoPresente = new PedidoModel();
        if (pedidoFound.isPresent() && !pedidoFound.isEmpty()) {
            pedidoPresente = pedidoFound.get();
        }
        pedidoPresente.setDatpedidodate(entity.getDatpedidodate());
        pedidoPresente.setNropedido(entity.getNropedido());

        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("PedidosService::delete");
        log.debug("Valores:{}", id);

        pedidoRepository.deleteById(id);
    }

}
