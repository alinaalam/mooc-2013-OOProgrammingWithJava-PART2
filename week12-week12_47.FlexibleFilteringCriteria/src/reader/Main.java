package reader;

import reader.criteria.AtLeastOne;
import reader.criteria.Both;
import reader.criteria.Criterion;
import reader.criteria.ContainsWord;
import reader.criteria.LengthAtLeast;
import reader.criteria.Not;

public class Main {

    public static void main(String[] args) {
        String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
        GutenbergReader book = new GutenbergReader(address);

        Criterion words = new AtLeastOne(
                new ContainsWord("beer"),
                new ContainsWord("milk"),
                new ContainsWord("oil")
        );

        Criterion rightLength = new Both(
                new LengthAtLeast(20),
                new Not(new LengthAtLeast(31))
        );

        Criterion wanted = new Both(words, rightLength);
    }
}
