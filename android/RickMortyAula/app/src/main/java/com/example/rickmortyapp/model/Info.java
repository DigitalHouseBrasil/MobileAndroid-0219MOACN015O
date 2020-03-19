
package com.example.rickmortyapp.model;

import com.google.gson.annotations.Expose;

public class Info {

    @Expose
    private Long count;
    @Expose
    private String next;
    @Expose
    private Long pages;
    @Expose
    private String prev;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

}
