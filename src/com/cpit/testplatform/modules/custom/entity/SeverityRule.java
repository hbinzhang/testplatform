package com.cpit.testplatform.modules.custom.entity;

public class SeverityRule {
    private Boolean critical;

    private Boolean major;

    private Boolean minor;

    private Boolean warning;

    public Boolean getCritical() {
        return critical;
    }

    public void setCritical(Boolean critical) {
        this.critical = critical;
    }

    public Boolean getMajor() {
        return major;
    }

    public void setMajor(Boolean major) {
        this.major = major;
    }

    public Boolean getMinor() {
        return minor;
    }

    public void setMinor(Boolean minor) {
        this.minor = minor;
    }

    public Boolean getWarning() {
        return warning;
    }

    public void setWarning(Boolean warning) {
        this.warning = warning;
    }
}