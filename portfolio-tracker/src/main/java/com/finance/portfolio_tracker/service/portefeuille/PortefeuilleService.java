package com.finance.portfolio_tracker.service.portefeuille;

import java.util.List;
import java.util.Optional;

import com.finance.portfolio_tracker.service.portefeuille.modele.PortefeuilleInterne;

public interface PortefeuilleService {
    
    PortefeuilleInterne creerPortefeuille(String nom, String devise); 

    Optional<PortefeuilleInterne> obtenirPortefeuille(Long id);

    List<PortefeuilleInterne> obtenirTousLesPortefeuilles();

    PortefeuilleInterne mettreAJourPortefeuille(Long id, String nom, String devise);
    
    void supprimerPortefeuille(Long id);

}
