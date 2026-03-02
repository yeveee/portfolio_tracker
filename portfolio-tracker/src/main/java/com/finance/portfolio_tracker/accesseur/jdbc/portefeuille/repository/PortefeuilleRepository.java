package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.repository;

import java.util.List;
import java.util.Optional;

import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.modele.PortefeuilleAccesseur;

public interface PortefeuilleRepository {
    
    PortefeuilleAccesseur save(PortefeuilleAccesseur portefeuille);

    Optional<PortefeuilleAccesseur> findById(Long id);

    List<PortefeuilleAccesseur> findAll();

    void deleteById(Long id);
}
