package model.gamIntro;

public class IntroductionPage {

    public String getStory() {
        return """
                Welcome, brave soul, to "The Haunted Mansion" – an escape room like no other.\s
                I’m the GameMaster and I will try to help you where I can. \s
                But I don’t have all the answers.\s
                There are some things you have to figure out on your own. \s
                You will be tested in different puzzles and obstacles. \s
                Objects and items will come up along the way. \s
                Remember them. \s
                They’re important. \s
                But don’t take too long. \s
                Time is of the essence, someone or something may be watching you, waiting...""";
    }

    public char[] getCharacters() {
        return getStory().toCharArray();
    }

}
