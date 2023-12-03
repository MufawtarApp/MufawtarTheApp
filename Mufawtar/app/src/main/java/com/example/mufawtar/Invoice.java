package com.example.mufawtar;

import android.graphics.Bitmap;

public class Invoice {
    private String desc; //invoice description
    private Bitmap pic;
    public Invoice(String desc, Bitmap pic) {
        this.desc = desc;
        this.pic = pic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Bitmap getPic() {
        return pic;
    }

    public void setPic(Bitmap pic) {
        this.pic = pic;
    }
}
