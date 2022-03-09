package net.proofit.premiumcalculation.domain;

import net.proofit.premiumcalculation.enums.PolicyStatus;

import java.util.List;

public class Policy {

    private String policyNumber;
    private PolicyStatus policyStatus;
    private List<PolicyObject> policyObjects;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObjects(List<PolicyObject> policyObjects) {
        this.policyObjects = policyObjects;
    }
}
