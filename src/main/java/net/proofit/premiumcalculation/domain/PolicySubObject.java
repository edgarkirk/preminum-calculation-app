package net.proofit.premiumcalculation.domain;

import net.proofit.premiumcalculation.enums.RiskType;

import java.math.BigDecimal;

public class PolicySubObject {

    private String subObjectName;
    private BigDecimal sumInsured;
    private RiskType riskType;

    public String getSubObjectName() {
        return subObjectName;
    }

    public void setSubObjectName(String subObjectName) {
        this.subObjectName = subObjectName;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }
}
