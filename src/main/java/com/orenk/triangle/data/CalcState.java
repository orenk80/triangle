package com.orenk.triangle.data;

import javax.xml.bind.ValidationException;

public enum CalcState {
    POST,PRE;

    public static CalcState getStateFromName(String stateName)  {
        if (stateName.toUpperCase().matches(PRE.name()))
            return PRE;
        if (stateName.toUpperCase().matches(POST.name()))
            return POST;
        throw new RuntimeException(new ValidationException("TriangleUpdateState name("+stateName +") is not valid"));
    }
}
