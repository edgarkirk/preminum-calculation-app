package net.proofit.premiumcalculation.domain;

import java.util.List;

public class PolicyObject {

    private String objectName;
    private List<PolicySubObject> policySubObjects;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<PolicySubObject> getPolicySubObjects() {
        return policySubObjects;
    }

    public void setPolicySubObjects(List<PolicySubObject> policySubObjects) {
        this.policySubObjects = policySubObjects;
    }
}
