package net.proofit.premiumcalculation.service;

import net.proofit.premiumcalculation.domain.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PremiumCalculationServiceImpl implements PremiumCalculationService {

    private final static Logger log = LoggerFactory.getLogger(PremiumCalculationServiceImpl.class);

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
        log.debug("Fire insured sum = {}", sumInsuredFire);
        BigDecimal sumInsuredTheft = premiumTheftCalculationService.calculate(policy);
        log.debug("Theft insured sum = {}", sumInsuredTheft);

        return sumInsuredFire.add(sumInsuredTheft).setScale(2, RoundingMode.HALF_UP);
    }
}
