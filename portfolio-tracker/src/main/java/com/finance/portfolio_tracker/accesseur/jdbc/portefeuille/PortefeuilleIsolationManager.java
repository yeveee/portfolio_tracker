package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.mappeur.PortefeuilleMappeur;
import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.modele.PortefeuilleAccesseur;
import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.repository.PortefeuilleRepository;
import com.finance.portfolio_tracker.service.portefeuille.modele.PortefeuilleInterne;
@Component
public class PortefeuilleIsolationManager {
    
    private final PortefeuilleRepository repository;
    private final PortefeuilleMappeur mappeur;

    public PortefeuilleIsolationManager(PortefeuilleRepository repository, PortefeuilleMappeur mappeur) {
        this.repository = repository;
        this.mappeur = mappeur;
    }

    public PortefeuilleInterne save(PortefeuilleInterne portefeuille) {
        var accesseur = mappeur.map(portefeuille);
        var saved = repository.save(accesseur);
        var interne = mappeur.map(saved);
        return interne;
    }

    public Optional<PortefeuilleInterne> findById(Long id) {
        return repository.findById(id).map(mappeur::map);
    }
    
}
