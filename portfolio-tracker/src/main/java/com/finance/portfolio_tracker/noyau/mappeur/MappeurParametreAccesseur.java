package com.finance.portfolio_tracker.noyau.mappeur;

import com.finance.portfolio_tracker.noyau.modele.ModeleAccesseur;
import com.finance.portfolio_tracker.noyau.modele.ModeleInterne;

public interface MappeurParametreAccesseur<I extends ModeleInterne, C extends ModeleAccesseur>{
    C map(I source);
}
