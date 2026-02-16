package com.finance.portfolio_tracker.noyau.mappeur;

import com.finance.portfolio_tracker.noyau.modele.ModeleAccesseur;
import com.finance.portfolio_tracker.noyau.modele.ModeleInterne;

public interface MappeurReponseAccesseur<C extends ModeleAccesseur, I extends ModeleInterne> {
    I map(C source);
}
