package com.cfwu.music5.bean;

import java.net.URL;

/**
 * Created by cfwu on 17-12-8.
 */
public class Song {
    private int srcRid;
    private String nameSong;
    private String singer;
    private URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Song(int srcImg, String nameSong, String singer) {
        this.srcRid = srcImg;
        this.nameSong = nameSong;
        this.singer = singer;
    }

    public Song(int srcRid, URL url, String singer, String nameSong) {
        this.srcRid = srcRid;
        this.url = url;
        this.singer = singer;
        this.nameSong = nameSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSrcRid() {
        return srcRid;
    }

    public void setSrcRid(int srcRid) {
        this.srcRid = srcRid;
    }
}
