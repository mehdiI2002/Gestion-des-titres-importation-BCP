package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.entities.Operator;
import org.gestiondestitresimportationbcp.repositories.OperateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorServiceDefault implements OperatorServices {
    @Autowired
    private  OperateurRepository operateurRepository;

    @Override
    public void insertOperator( DemandeDomiciliationMessage demandeDomiciliationMessage) {
        Operator operator = demandeDomiciliationMessage.getOperateur();
        operateurRepository.save(operator);
    }
    @Override
    public List<Operator> selectOperators() {
        return operateurRepository.findAll();
    }
}
