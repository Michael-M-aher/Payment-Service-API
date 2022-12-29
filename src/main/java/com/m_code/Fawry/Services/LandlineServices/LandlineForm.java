package com.m_code.Fawry.Services.LandlineServices;

import com.m_code.Fawry.Services.AbstractService.ServiceForm;

//Concrete Product A
public class LandlineForm extends ServiceForm {
    private String landlinenumber;

    public String getLandlinenumber() {
        return landlinenumber;
    }

    public void setLandlinenumber(String landLineNumber) {
        landlinenumber = landLineNumber;
    }

    @Override
    public Boolean validate() {
        return (landlinenumber != null);
    }

}
