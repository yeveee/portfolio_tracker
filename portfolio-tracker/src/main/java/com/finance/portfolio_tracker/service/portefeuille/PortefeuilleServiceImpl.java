package com.finance.portfolio_tracker.service.portefeuille;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.PortefeuilleIsolationManager;
import com.finance.portfolio_tracker.service.portefeuille.modele.PortefeuilleInterne;

@Service
public class PortefeuilleServiceImpl implements PortefeuilleService {

    private final PortefeuilleIsolationManager isolationManager;

    public PortefeuilleServiceImpl(PortefeuilleIsolationManager isolationManager) {
        this.isolationManager = isolationManager;
    }

    @Override
    public PortefeuilleInterne creerPortefeuille(String nom, String devise) {
        var object = PortefeuilleInterne.builder()
        .nom(nom)
        .devise(devise)
        .build();

        var save = isolationManager.save(object);
        return save;
    }

    @Override
    public Optional<PortefeuilleInterne> obtenirPortefeuille(Long id) {
        return isolationManager.findById(id);
    }

    @Override
    public List<PortefeuilleInterne> obtenirTousLesPortefeuilles() {
        return isolationManager.findAll();
    }

    @Override
    public PortefeuilleInterne mettreAJourPortefeuille(Long id, String nom, String devise) {
        //find existing portfolio
        isolationManager.findById(id).orElseThrow(() -> new RuntimeException("Portfolio not found with id: " + id));

        var updatedPortfolio = PortefeuilleInterne.builder()
            .id(id)
            .nom(nom)
            .devise(devise)
            .build();

        return isolationManager.save(updatedPortfolio);

    }

    @Override
    public void supprimerPortefeuille(Long id) {
        isolationManager.deleteById(id);
    }
}
