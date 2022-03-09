package net.proofit.premiumcalculation.controller;

import net.proofit.premiumcalculation.domain.Policy;
import net.proofit.premiumcalculation.service.PremiumCalculationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@Controller
public class PremiumCalculatorController {

    private final PremiumCalculationService premiumCalculationService;

    public PremiumCalculatorController(@Qualifier("premiumCalculationServiceImpl") PremiumCalculationService premiumCalculationService) {
        this.premiumCalculationService = premiumCalculationService;
    }

    @PostMapping("/")
    public ResponseEntity<String> calculate(@RequestBody Policy policy) {
        BigDecimal premium = premiumCalculationService.calculate(policy);
        return new ResponseEntity<>(premium + " EUR", HttpStatus.OK);
    }
}
