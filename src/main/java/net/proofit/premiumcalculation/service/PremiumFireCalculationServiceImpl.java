package net.proofit.premiumcalculation.service;

import net.proofit.premiumcalculation.domain.Policy;
import net.proofit.premiumcalculation.domain.PolicyObject;
import net.proofit.premiumcalculation.domain.PolicySubObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Optional.ofNullable;
import static net.proofit.premiumcalculation.enums.RiskType.FIRE;

@Service
public class PremiumFireCalculationServiceImpl implements PremiumCalculationService {

    private final static BigDecimal COEFFICIENT_FIRE_0014 = BigDecimal.valueOf(0.014);
    private final static BigDecimal COEFFICIENT_FIRE_0024 = BigDecimal.valueOf(0.024);

    private final static BigDecimal LIMIT = BigDecimal.valueOf(100);

    @Override
    public BigDecimal calculate(Policy policy) {
        BigDecimal sumInsuredFire = ofNullable(policy)
                .map(Policy::getPolicyObjects).stream()
                .flatMap(List::stream)
                .map(PolicyObject::getPolicySubObjects)
                .flatMap(List::stream)
                .filter(policySubObject -> FIRE.equals(policySubObject.getRiskType()))
                .map(PolicySubObject::getSumInsured)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sumInsuredFire.compareTo(LIMIT) > 0 ? sumInsuredFire.multiply(COEFFICIENT_FIRE_0024) : sumInsuredFire.multiply(COEFFICIENT_FIRE_0014);
    }
}
