package net.proofit.premiumcalculation.service;

import net.proofit.premiumcalculation.domain.Policy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PremiumCalculationServiceImpl implements PremiumCalculationService {

    private final PremiumCalculationService premiumFireCalculationService;
    private final PremiumCalculationService premiumTheftCalculationService;

    public PremiumCalculationServiceImpl(@Qualifier("premiumFireCalculationServiceImpl") PremiumCalculationService premiumFireCalculationService,
                                         @Qualifier("premiumTheftCalculationServiceImpl") PremiumCalculationService premiumTheftCalculationService) {
        this.premiumFireCalculationService = premiumFireCalculationService;
        this.premiumTheftCalculationService = premiumTheftCalculationService;
    }

    @Override
    public BigDecimal calculate(Policy policy) {
        BigDecimal sumInsuredFire = premiumFireCalculationService.calculate(policy);
        BigDecimal sumInsuredTheft = premiumTheftCalculationService.calculate(policy);
        return sumInsuredFire.add(sumInsuredTheft).setScale(2, RoundingMode.HALF_UP);
    }
}
