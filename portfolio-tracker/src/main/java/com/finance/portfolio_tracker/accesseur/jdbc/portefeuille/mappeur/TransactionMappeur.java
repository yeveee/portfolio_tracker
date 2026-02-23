package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.mappeur;

import org.mapstruct.Mapper;

import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.modele.TransactionAccesseur;
import com.finance.portfolio_tracker.noyau.mappeur.MappeurParametreAccesseur;
import com.finance.portfolio_tracker.noyau.mappeur.MappeurReponseAccesseur;
import com.finance.portfolio_tracker.service.portefeuille.modele.TransactionInterne;
@Mapper(componentModel = "spring")
public interface TransactionMappeur extends 
    MappeurParametreAccesseur<TransactionInterne, TransactionAccesseur>,
    MappeurReponseAccesseur<TransactionAccesseur, TransactionInterne>{
    
}
