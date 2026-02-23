package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.modele;

import com.finance.portfolio_tracker.noyau.modele.ModeleAccesseur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortefeuilleAccesseur implements ModeleAccesseur{
    
    private Long id;
    private String nom;
    private String devise;
}
