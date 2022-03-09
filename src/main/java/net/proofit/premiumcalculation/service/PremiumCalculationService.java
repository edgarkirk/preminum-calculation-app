package net.proofit.premiumcalculation.service;

import net.proofit.premiumcalculation.domain.Policy;

import java.math.BigDecimal;

public interface PremiumCalculationService {

    BigDecimal calculate(Policy policy);
}
