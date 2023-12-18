package model.firstRoom;

public class FirstRoomDark {

    public String getStory() {
        return """
                You wake in a dark room feeling dizzy. You can’t see much but you appear to be in an old house of some sorts.
                You’re not quite sure where you are but one thing’s for sure. It’s cold. Almost freezing.
                Suddenly you hear a voice coming from the room. It sounds like a little girl, crying.
                
                "So cold... it’s... so cold..."
                
                You get on your feet, and try to look around in the dark.
                The room is filled with old furniture and paintings.
                
                In the middle of the room is a table with what looks to be a standing candle on it and maybe something next to it.
                To your right, are some paintings on the wall but you can’t make out any details.
                In the corner of the room you see a large, tall rectangular object, a bookshelf maybe?
                At the opposite end of the room you see a… a human, a little girl? Or whatever it is. It’s crying.
                Beside the little girl you see a door. A way out maybe.
                """;
    }

    public String getBlowOutCandle() {
        return """
                You blew out the candle that illuminated the room..
                Weirdo.
                """;
    }

    public String getGoNearCandle() {
        return """
                Coming to the table you see a small metal object next to the standing candle.
                A lighter.
                It’s looks old but still functional.""";
    }

    public String getGoNearBookshelf() {
        return """
                You see a lot of books on the shelf but it’s too dark in the room to make out any of the titles.
                Maybe something in the room could help to illuminate the place.
                """;
    }

    public String getGoNearPaintings() {
        return """
                You see the silhouette of 5 paintings on the wall.
                But it’s too dark to see what's on them.
                Maybe something in the room could help to illuminate the place.
                """;
    }
}
