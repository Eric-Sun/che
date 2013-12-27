package com.h13.che.cache.co;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-12-17
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class CommentCO {
    private long id;
    private long mid;
    private String uid;
    private String content;
    private long ts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }
}
