package model.firstRoom;

public class Bookshelf {
    public String getLookingAtBooks() {
        return """
                 On the large bookshelf you see a lot of different titles: “IT, Saw, American Psycho, Sinister”.
                 At the top of the shelf is a sign, “Horror”.
                 You quickly realize that all the books are old and new Horror titles and you ask yourself “Why”?
                 Some of the books are very old, others more recent.
                """;
    }

    public String getWrongBookChosen() {
        return """
                You flip through the pages and nothing is out of the ordinary..
                """;
    }

    public String getCorrectBookChosen() {
        return """
                You flip through the pages and notice a strange message.
                You say the word out loud, and you're suddenly startled with a loud noise!
                The bookshelf begins to move.
                After a short while, a keypad behind the bookshelf has been revealed.
                 """;
    }
}
