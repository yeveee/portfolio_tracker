package com.finance.portfolio_tracker.noyau.mappeur;

import com.finance.portfolio_tracker.noyau.modele.ModeleApi;
import com.finance.portfolio_tracker.noyau.modele.ModeleInterne;

public interface MappeurParametreApi<A extends ModeleApi, I extends ModeleInterne> {
    I map(A source);
}