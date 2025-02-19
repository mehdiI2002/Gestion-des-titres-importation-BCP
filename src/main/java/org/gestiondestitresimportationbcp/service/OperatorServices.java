package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Operator;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;

import java.util.List;

public interface OperatorServices {
    void insertOperator( DemandeDomiciliationMessage demandeDomiciliationMessage);
    List<Operator> selectOperators();


}
