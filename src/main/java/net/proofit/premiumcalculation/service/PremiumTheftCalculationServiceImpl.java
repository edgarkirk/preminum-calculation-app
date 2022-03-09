package net.proofit.premiumcalculation.service;

import net.proofit.premiumcalculation.domain.Policy;
import net.proofit.premiumcalculation.domain.PolicyObject;
import net.proofit.premiumcalculation.domain.PolicySubObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Optional.ofNullable;
import static net.proofit.premiumcalculation.enums.RiskType.THEFT;

@Service
public class PremiumTheftCalculationServiceImpl implements PremiumCalculationService {

    private final static BigDecimal COEFFICIENT_THEFT_005 = BigDecimal.valueOf(0.05);
    private final static BigDecimal COEFFICIENT_THEFT_011 = BigDecimal.valueOf(0.11);

    private final static BigDecimal LIMIT = BigDecimal.valueOf(15);

    @Override
    public BigDecimal calculate(Policy policy) {
        BigDecimal sumInsuredTheft = ofNullable(policy)
                .map(Policy::getPolicyObjects).stream()
                .flatMap(List::stream)
                .map(PolicyObject::getPolicySubObjects)
                .flatMap(List::stream)
                .filter(policySubObject -> THEFT.equals(policySubObject.getRiskType()))
                .map(PolicySubObject::getSumInsured)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sumInsuredTheft.compareTo(LIMIT) > 0 ? sumInsuredTheft.multiply(COEFFICIENT_THEFT_005) : sumInsuredTheft.multiply(COEFFICIENT_THEFT_011);
    }
}
