package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        //converts interne model to accesseur
        var accesseur = mappeur.map(portefeuille);
        //saves to database with assigned id (if new)
        var saved = repository.save(accesseur);
        // converts saved back to interne with id
        var interne = mappeur.map(saved);
        return interne;
    }

    public Optional<PortefeuilleInterne> findById(Long id) {
        return repository.findById(id).map(mappeur::map);
    }

    public List<PortefeuilleInterne> findAll() {
        return repository.findAll().stream()
        .map(mappeur::map)
        .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
