package week5.BlackList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ImplBlackListFilter filter = new ImplBlackListFilter();

        List<String> comments = new ArrayList<>();
        comments.add("как тебе такое");
        comments.add("я крутой миллионер, программист, плейбой");
        comments.add("ну это бан");
        comments.add("однажды, в студеную зимнюю пору");
        comments.add("мой дядя самых честных правил");

        Set<String> blackList = new HashSet<>();
        blackList.add("бан");
        blackList.add("миллионер");

        filter.filterComments(comments, blackList);
        for (String c : comments) {
            System.out.println(c);
        }


    }
}
