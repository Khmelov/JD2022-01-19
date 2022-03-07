package by.it.kuzma.jd01_06;

public class TaskB2 {

    public static final String WITHOUT_MARK = "[\\p{P} ]+";
    public static final String DOT = "[.!]";

    public static void main(String[] args) {

        String text = Poem.text;
        text = text.replace("...", "").replace("\n", " ");

        String[] sentences = text.split(DOT);

        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll(WITHOUT_MARK, " ").trim();
        }

        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < sentences.length-1; j++) {
                if (sentences[j].length() > sentences[j + 1].length()){

                    String container = sentences[j];
                    sentences[j] = sentences[j + 1];
                    sentences[j + 1] = container;
                }
            }
        }

        for (String sentence : sentences) {
            System.out.println(sentence);
        }

    }
}
