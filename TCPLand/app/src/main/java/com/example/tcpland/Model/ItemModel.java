package com.example.tcpland.Model;

import androidx.fragment.app.Fragment;

public class ItemModel {

    // string course_name for storing course_name
    // and imgid for storing image id.
    private String course_name;
    private int imgid;
    private Fragment targetFragment;

    public ItemModel(String course_name, int imgid) {
        this.course_name = course_name;
        this.imgid = imgid;
    }

    public ItemModel(String course_name, int imgid,Fragment targetFragment) {
        this.course_name = course_name;
        this.imgid = imgid;
        this.targetFragment=targetFragment;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public Fragment getTargetFragment() {
        return targetFragment;
    }

    public void setTargetFragment(Fragment targetFragment) {
        this.targetFragment = targetFragment;
    }
}
