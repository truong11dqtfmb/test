/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp2.album;

import java.util.Arrays;
import java.util.List;

public class AlbumManagenment {

    // Dsach cac bai hat
    private List<Track> listTrack2 = Arrays.asList(
            new Track("Ha Buon", 500),
            new Track("Vung la me bay", 1000),
            new Track("Noi buon hoa phuong", 134),
            new Track("Phuong hong", 10000)
    );

    private List<Track> listTrack1 = Arrays.asList(
            new Track("Bai ca hi vong", 15000),
            new Track("Ao mua dong", 12000),
            new Track("Mau hoa do", 130),
            new Track("Que nha", 1500),
            new Track("Me yeu con", 12300)
    );

    // Dsach cac tac gia
    private List<Artist> musicians1 = Arrays.asList(
            new Artist("Tung Duong"),
            new Artist("Quang Tho")
    );
    private List<Artist> musicians2 = Arrays.asList(
            new Artist("Quang Le"),
            new Artist("Nhu Quynh")
    );

    // Dsach album
    private Album album1 = new Album("Tung Duong Hat Tinh Ca", listTrack1, musicians1);
    private Album album2 = new Album("Tung Duong Hat Tinh Ca", listTrack2, musicians2);

    public AlbumManagenment() {
    }

    public List<Album> initiateAlbumList() {
        List<Album> listAlbum = Arrays.asList(album1, album2);
        return listAlbum;
    }

    public Track getMaxViewCount(List<Album> listAlbum) {
        Track tp = listAlbum.get(0).getListTrack().get(0);
        for (Album album : listAlbum) {
            for (int i = 0; i < album.getListTrack().size(); i++) {
                if (album.getListTrack().get(i).getViewCount() > tp.getViewCount()) {
                    tp = album.getListTrack().get(i);
                }
            }
        }
        return tp;
    }
    
    
//    public Track getMaxViewCount(List<Album> listAlbum) {
//        listAlbum.stream().forEach(a -> {
//            a.getListTrack().stream().forEach(b -> {
//                
//            });
//        });
//        
//        
//    }
    public Track getMinViewCount(List<Album> listAlbum) {
        Track tp = listAlbum.get(0).getListTrack().get(0);
        for (Album album : listAlbum) {
            for (int i = 0; i < album.getListTrack().size(); i++) {
                if (album.getListTrack().get(i).getViewCount() < tp.getViewCount()) {
                    tp = album.getListTrack().get(i);
                }
            }
        }
        return tp;
    }

    public long countTracks(List<Album> listAlbum) {
        long countTrack = 0;
        for (Album album : listAlbum) {
            countTrack += album.getListTrack().size();
        }
        return countTrack;
    }
}
