package com.finance.portfolio_tracker.service.portefeuille.modele;

import com.finance.portfolio_tracker.noyau.modele.ModeleInterne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortefeuilleInterne implements ModeleInterne{
    
    private Long id;
    private String nom;
    private String devise;
    private List<PositionInterne> positions;
}
