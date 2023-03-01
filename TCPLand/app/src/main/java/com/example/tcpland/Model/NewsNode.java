package com.example.tcpland.Model;

import com.example.tcpland.View.Account.Tintuc.Tintuc;

public class NewsNode {

    public NewsNode(Tintuc node) {
        this.node = node;
    }
    public NewsNode() {
    }
    public Tintuc getNode() {
        return node;
    }

    public void setNode(Tintuc node) {
        this.node = node;
    }

    public Tintuc node;
}
