package com.example.kwy2868.boostcamp_1st.Model;

/**
 * Created by kwy2868 on 2017-07-04.
 */

public class Profile {
    private String name;
    private int image;

    public Profile(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
