package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Operator;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.OperatorId;
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
        OperatorId id = new OperatorId(operator.getNumIdentification(),demandeDomiciliationMessage.getTitre().getNumEnregistrement());
        operator.setId(id);
        operateurRepository.save(operator);
    }
    @Override
    public List<Operator> selectOperators() {
        return operateurRepository.findAll();
    }
}
