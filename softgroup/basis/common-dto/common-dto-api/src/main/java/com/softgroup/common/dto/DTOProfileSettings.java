package com.softgroup.common.dto;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOProfileSettings implements Serializable{

    private static final long serialVersionUID = -409838183898236491L;

    private String settings;

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }
}
