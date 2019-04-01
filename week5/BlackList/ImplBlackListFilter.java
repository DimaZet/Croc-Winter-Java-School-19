package week5.BlackList;

import java.util.List;
import java.util.Set;

public class ImplBlackListFilter implements BlackListFilter {
    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments  list of comments; every comment
     *                  is a sequence of words, separated
     *                  by spaces or line breaks
     * @param blackList list of words that should not
     */
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        for (int i = 0; i < comments.size(); i++) {
            String comment = comments.get(i);
            if (comment == null)
                continue;
            for (String stopWord : blackList) {
                if (comment.contains(stopWord)) {
                    comments.remove(comment);
                }
            }
        }

    }
}
