package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.modele;

import java.math.BigDecimal;

import com.finance.portfolio_tracker.noyau.modele.ModeleAccesseur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionAccesseur implements ModeleAccesseur{
    
    private Long id;
    private Long portefeuilleId;
    private String ticker;
    private String nomProduit;
    private Integer quantite;
    private BigDecimal prixAchatMoyen;
}
