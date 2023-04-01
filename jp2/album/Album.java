/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.album;

import java.util.List;

public class Album {
    private String name;
    private List<Track> listTrack;
    private List<Artist> musicians;

    public Album(String name, List<Track> listTrack, List<Artist> musicians) {
        this.name = name;
        this.listTrack = listTrack;
        this.musicians = musicians;
    }

    public String getName() {
        return name;
    }

    public List<Track> getListTrack() {
        return listTrack;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListTrack(List<Track> listTrack) {
        this.listTrack = listTrack;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }

    @Override
    public String toString() {
        return "Album{" + "name=" + name + ", listTrack=" + listTrack + ", musicians=" + musicians + '}';
    }
    
}
