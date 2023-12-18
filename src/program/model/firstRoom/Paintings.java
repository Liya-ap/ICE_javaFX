package model.firstRoom;

public class Paintings {
    public String getLookingAtPaintings() {
        return """
                 You take a look at the 5 paintings on the wall.
                 All of them depict something different.
                 Different people, doing different things.
                 They do have one thing in common though. They're all smiling.
                 No matter what they're doing or what's happening in the painting,
                 the people are smiling.
                 
                 In the middle of the biggest painting, you see a note..
                """;
    }

    public String getRiddle() {
        return """
                What is the highest number between 1 and 1.000.000 that does not contain the letter “N” when said out loud?
                
                Take that number and subtract 19 from it.
                Remember the result.
                
                Now take the number and add 351 to it.
                Remember the result.
                
                You should now have a two-digit number and a three-digit number.
                Put them together in the order you got them to make a five-digit number.
                
                Remember this final number. You'll need it.""";
    }

    public String getRiddleSolved() {
        return """
                 With that done you’ve now acquired a five-digit number.
                 It looks like that's about all you can do with the paintings.
                 Maybe these clues you've gathered can be used somewhere else?
                """;
    }
}
