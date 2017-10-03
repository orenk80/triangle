package com.assignment.triangle.data;


public enum CalcState {
    POST, PRE;

    public static CalcState getStateFromName(String stateName) {

        if (stateName.toUpperCase().matches(PRE.name()))
            return PRE;
        if (stateName.toUpperCase().matches(POST.name()))
            return POST;
        throw new RuntimeException("TriangleUpdateState name(" + stateName + ") is not valid");
    }
}
