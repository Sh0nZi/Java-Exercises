/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1_4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author sstoyanov
 */
public class Zad1_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long totalMembers;
        
        List<Artist> artists = new ArrayList<>();
        List<Artist> members = new ArrayList<>();
        
        members.add(new Artist("1", " 2"));
        members.add(new Artist("1a", " 6"));
        members.add(new Artist("1s", " 5"));
        members.add(new Artist("1d", " 4"));
        artists.add(new Artist("test", members, "test"));
        
        members.add(new Artist("1s", " 5"));
        members.add(new Artist("1d", " 4"));
        artists.add(new Artist("aaa", members, "dadada"));
        
        totalMembers = artists.stream().mapToLong((i)-> i.getMembers().count()).reduce(0, (a,b)-> a + b);
       
        System.out.println("Total members: " + totalMembers);
        
        /*totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> mems = artist.getMembers();
            totalMembers += mems.count();
        }
        
        System.out.println("Total members: " + totalMembers);*/
                
    }

}
