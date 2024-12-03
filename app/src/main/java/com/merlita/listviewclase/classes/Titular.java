package com.merlita.listviewclase.classes;

public class Titular {
    String title, subtitle;

    public Titular(String title, String subtitle) {
        setTitle(title);
        setSubtitle(subtitle);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
