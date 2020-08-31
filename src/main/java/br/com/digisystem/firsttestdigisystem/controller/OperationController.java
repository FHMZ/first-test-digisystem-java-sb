package br.com.digisystem.firsttestdigisystem.controller;

import br.com.digisystem.firsttestdigisystem.model.Operation;
import br.com.digisystem.firsttestdigisystem.model.OperationResult;
import br.com.digisystem.firsttestdigisystem.service.OperationService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @author Fernando Zandonadi
 * @Email ferzan17@gmail.com
 * @Doc variaveis de ambiente adicionadas para  melhor pratica
 **/
@RestController
@RequestMapping(value = "${controller.url}")
public class OperationController implements Serializable {

    /** Se forem realizadas mudanças muito grandes nesta classe,
     * deve-se tambem alterar este valor
     **/
    private static final long serialVersionUID = 1L;

    private OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping()
    public OperationResult save(@RequestBody Operation operation) throws Exception {
        return this.operationService.operations(operation);
    }
}
