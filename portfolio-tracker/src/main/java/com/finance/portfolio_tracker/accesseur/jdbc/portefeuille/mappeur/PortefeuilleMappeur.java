package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.mappeur;

import org.mapstruct.Mapper;

import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.modele.PortefeuilleAccesseur;
import com.finance.portfolio_tracker.noyau.mappeur.MappeurParametreAccesseur;
import com.finance.portfolio_tracker.noyau.mappeur.MappeurReponseAccesseur;
import com.finance.portfolio_tracker.service.portefeuille.modele.PortefeuilleInterne;
@Mapper(componentModel = "spring")
public interface PortefeuilleMappeur extends 
    MappeurParametreAccesseur<PortefeuilleInterne, PortefeuilleAccesseur>,
    MappeurReponseAccesseur<PortefeuilleAccesseur, PortefeuilleInterne>{
    
}
