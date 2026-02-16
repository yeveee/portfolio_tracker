package com.finance.portfolio_tracker.noyau.mappeur;

import com.finance.portfolio_tracker.noyau.modele.ModeleApi;
import com.finance.portfolio_tracker.noyau.modele.ModeleInterne;

public interface MappeurReponseApi<I extends ModeleInterne, A extends ModeleApi> {
    A map(I source);
}
