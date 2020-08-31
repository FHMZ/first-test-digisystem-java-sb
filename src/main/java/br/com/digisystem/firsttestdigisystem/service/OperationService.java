package br.com.digisystem.firsttestdigisystem.service;

import br.com.digisystem.firsttestdigisystem.enums.OperationsEnum;
import br.com.digisystem.firsttestdigisystem.model.Operation;
import br.com.digisystem.firsttestdigisystem.model.OperationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Fernando Zandonadi
 * @Email ferzan17@gmail.com
 **/
@Service
public class OperationService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    NumberFormat format = new DecimalFormat("##.00");


    public OperationResult operations(Operation operation) throws Exception {

        logger.info("#### starting metodo operations()");

        final OperationResult result = new OperationResult();

        final int arraySize = operation.getNumeros().length;
        final String action = operation.getAcao().toUpperCase();
        logger.info("#### arraySize: {}", arraySize);
        logger.info("#### action: {}", action);

        if (action.equals(OperationsEnum.TOTAL.getDescription())) {
            result.setTotal(this.format.format(arraySize).replace(",", "."));
            logger.info("#### total: {}", result.getTotal());
            logger.info("#### ending metodo operations()");
            return result;
        }

        long total = 0;

        if (action.equals(OperationsEnum.SOMA.getDescription())) {
            total = this.soma(operation, arraySize);
        } else if (action.equals(OperationsEnum.SUBTRACAO.getDescription())) {
            total = this.subtracao(operation, arraySize);
        } else {
            final long soma = this.soma(operation, arraySize);
            total = soma / arraySize;
        }

        result.setTotal(this.format.format(total).replace(",", "."));

        logger.info("#### total: {}", result.getTotal());
        logger.info("#### ending metodo operations()");

        return result;
    }

    /**
     * este metodo efetua a soma dos elementos do array
     *
     * @param operation
     * @param arraySize
     * @returns int
     **/
    private long soma(Operation operation, int arraySize) {
        logger.info("#### starting Metodo soma()");
        int total = 0;
        for (int i = 0; i < arraySize; i++) {
            total += operation.getNumeros()[i];
        }
        logger.info("#### ending Metodo soma()");
        return total;
    }

    /**
     * este metodo efetua a subtracao dos elementos do array
     *
     * @param operation
     * @param arraySize
     * @returns int
     **/
    private long subtracao(Operation operation, int arraySize) {
        logger.info("#### starting Metodo subtracao()");
        int total = 0;
        for (int i = 0; i < arraySize; i++) {
            if (i == 0) {
                total = operation.getNumeros()[0];
                i = 1;
            }
            total -= operation.getNumeros()[i];
        }
        logger.info("#### ending Metodo soma()");
        return total;
    }

}
