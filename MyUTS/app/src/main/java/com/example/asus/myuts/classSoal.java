package com.example.asus.myuts;

import android.widget.ImageView;

/**
 * Created by ASUS on 4/6/2017.
 */

public class classSoal {
    public int id;
    public String []jawaban=new String[3];
    public String []pilihan=new String[3];
    public ImageView[]img = new ImageView[3];



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getJawaban() {
        return jawaban;
    }

    public void setJawaban(String[] jawaban) {
        this.jawaban = jawaban;
    }

    public String[] getPilihan() {
        return pilihan;
    }

    public void setPilihan(String[] pilihan) {
        this.pilihan = pilihan;
    }

    public ImageView[] getImg() {
        return img;
    }

    public void setImg(ImageView[] img) {
        this.img = img;
    }

    public classSoal(int id, String[] jawaban, String[] pilihan, ImageView[] img) {
        this.id = id;
        this.jawaban = jawaban;
        this.pilihan = pilihan;
        this.img = img;
    }
}
