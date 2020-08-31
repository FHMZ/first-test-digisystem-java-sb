package br.com.digisystem.firsttestdigisystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fernando Zandonadi
 * @Email ferzan17@gmail.com
 **/
@Data
public class Operation implements Serializable {


    /** Se forem realizadas mudanças muito grandes nesta classe,
     * deve-se tambem alterar este valor
     **/
    private static final long serialVersionUID = 1L;

    private String acao;
    private int[] numeros;

}
