package com.finance.portfolio_tracker.service.portefeuille.modele;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.finance.portfolio_tracker.noyau.modele.ModeleInterne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInterne implements ModeleInterne{
    
    private Long id;
    private Long portefeuilleId;
    private String ticker;
    private String type;
    private Integer quantite;
    private BigDecimal prix;
    private LocalDateTime dateTransaction;
}
