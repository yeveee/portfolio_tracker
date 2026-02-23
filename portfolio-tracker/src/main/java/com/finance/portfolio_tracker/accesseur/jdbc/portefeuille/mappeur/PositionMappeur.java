package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.mappeur;

import org.mapstruct.Mapper;

import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.modele.PositionAccesseur;
import com.finance.portfolio_tracker.noyau.mappeur.MappeurParametreAccesseur;
import com.finance.portfolio_tracker.noyau.mappeur.MappeurReponseAccesseur;
import com.finance.portfolio_tracker.service.portefeuille.modele.PositionInterne;
@Mapper(componentModel = "spring")
public interface PositionMappeur extends 
    MappeurParametreAccesseur<PositionInterne, PositionAccesseur>,
    MappeurReponseAccesseur<PositionAccesseur, PositionInterne>{
}
