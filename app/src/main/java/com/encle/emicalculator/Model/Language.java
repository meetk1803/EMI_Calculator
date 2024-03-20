package com.encle.emicalculator.Model;

public class Language {
    private String name;
    private int logo;
    private boolean isSelected;

    public Language(String name, int logo) {
        this.name = name;
        this.logo = logo;
        this.isSelected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
