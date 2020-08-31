package br.com.digisystem.firsttestdigisystem.service;


import br.com.digisystem.firsttestdigisystem.enums.OperationsEnum;
import br.com.digisystem.firsttestdigisystem.model.Operation;
import br.com.digisystem.firsttestdigisystem.model.OperationResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationServiceTest {

    @Autowired
    private OperationService service;

    @Test
    public void mustEfetuarSoma() throws Exception {
        final Operation operation = this.getOperation();
        final OperationResult result = this.service.operations(operation);
        assertThat(result.getTotal()).isEqualTo("15.00");
    }

    @Test
    public void mustEfetuarSubitracao() throws Exception {
        Operation operation = this.getOperation();
        operation.setAcao(OperationsEnum.SUBTRACAO.getDescription());
        final OperationResult result = this.service.operations(operation);
        assertThat(result.getTotal()).isEqualTo("-5.00");
    }

    @Test
    public void mustEfetuarMedia() throws Exception {
        Operation operation = this.getOperation();
        operation.setAcao(OperationsEnum.MEDIA.getDescription());
        final OperationResult result = this.service.operations(operation);
        assertThat(result.getTotal()).isEqualTo("3.00");
    }

    @Test
    public void mustEfetuarTotal() throws Exception {
        Operation operation = this.getOperation();
        operation.setAcao(OperationsEnum.TOTAL.getDescription());
        final OperationResult result = this.service.operations(operation);
        assertThat(result.getTotal()).isEqualTo("5.00");
    }

    private Operation getOperation() {
        Operation operation = new Operation();
        operation.setAcao(OperationsEnum.SOMA.getDescription());
        int[] intArray = new int[]{5, 4, 3, 2, 1};
        operation.setNumeros(intArray);
        return operation;
    }

}
