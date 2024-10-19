package com.av1Bruno.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.av1Bruno.demo.dto.ItensPedidosDto;
import com.av1Bruno.demo.interfaces.IService;
import com.av1Bruno.demo.model.ItensPedidosModel;
import com.av1Bruno.demo.repository.ItensPedidosRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItensPedidosService implements IService<ItensPedidosDto, Integer> {
    
    final
    ItensPedidosRepository itensPedidosRepository;

    public ItensPedidosService(ItensPedidosRepository itensPedidosRepository) {
        this.itensPedidosRepository = itensPedidosRepository;
    }
    
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ItensPedidosDto create(ItensPedidosDto entity) {
        log.info("ItensPedidosService::create");
        log.debug("Valores: {}", entity);
        itensPedidosRepository.save(null);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ItensPedidosDto read(Integer id) {
        log.info("ItensPedidosService::read(id)");
        log.debug("Valores: {}", id);
        
        Optional<ItensPedidosModel> itenspedidosFound = itensPedidosRepository.findById(id);
        ItensPedidosModel itenspedidosQueVaiREceberObjetoTratado;  

        if (itenspedidosFound.isPresent()) {

            itenspedidosQueVaiREceberObjetoTratado = itenspedidosFound.get();            
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItensPedidosDto> read() {
        log.info("ItensPedidosService::read()");
        log.debug("Valores: sem parâmetros");

        //Pesquisa a lista de usuários
        List<ItensPedidosModel> itensPedidoModels = itensPedidosRepository.findAll();

        //Converter lista de List<ItensPedidoModel> >>> List<ItensPedidosDto>


        //Retornar a lista de DTOS (List<ItensPedidosDto)

        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ItensPedidosDto update(Integer id, ItensPedidosDto entity) {
        log.info("ItensPedidosService::update");
        log.debug("Valores: {} e {}", id, entity);

        Optional<ItensPedidosModel> itenspedidosFound = itensPedidosRepository.findById(id);
        ItensPedidosModel itensPedidosPresente = new ItensPedidosModel();
        if(itenspedidosFound.isPresent() && !itenspedidosFound.isEmpty()){
            itensPedidosPresente =  itenspedidosFound.get();
        }

        itensPedidosPresente.setValunidade(entity.getValunidade());
        itensPedidosPresente.setQtdeitem(entity.getQtdeitem());
        
        return null;
        }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("ItensPedidosService::delete");
        log.debug("Valores:{}", id);

        itensPedidosRepository.deleteById(id);
    }
}
    