package com.finance.portfolio_tracker.service.portefeuille.modele;

import java.math.BigDecimal;

import com.finance.portfolio_tracker.noyau.modele.ModeleInterne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionInterne implements ModeleInterne{
    
    private Long id;
    private Long portefeuilleId;
    private String ticker;
    private String nomProduit;
    private Integer quantite;
    private BigDecimal prixAchatMoyen;
}
