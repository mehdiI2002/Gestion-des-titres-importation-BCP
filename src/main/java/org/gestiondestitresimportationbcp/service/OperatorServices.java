package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Operator;

import java.util.List;

public interface OperatorServices {
    void insertOperator();
    List<Operator> selectOperators();


}
