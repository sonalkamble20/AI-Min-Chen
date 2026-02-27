import java.util.HashMap;
import java.util.Map;

public class MemeRepository {

    public static Map<String, Meme> getAllMemes() {
        Map<String, Meme> memes = new HashMap<>();

        // ---------- THE OFFICE ----------
        memes.put("michael_no_god", new Meme(
                "NO GOD, PLEASE NO!",
                "https://media.tenor.com/kbQv5cIBq8IAAAAM/the-office-steve-carell.gif",
                Map.ofEntries(
                        Map.entry("deadline", 3),
                        Map.entry("relatives", 3),
                        Map.entry("thanksgiving", 3),
                        Map.entry("late", 2),
                        Map.entry("panic", 3),
                        Map.entry("exam", 2),
                        Map.entry("bad", 2),
                        Map.entry("wrong", 3),
                        Map.entry("mistake", 2),
                        Map.entry("lost", 2),
                        Map.entry("failed", 3),
                        Map.entry("grade", 2),
                        Map.entry("regret", 2),
                        Map.entry("ruined", 2),
                        Map.entry("terrified", 2)
                )
        ));

        memes.put("jim_group_project", new Meme(
                "",
                "https://media1.giphy.com/media/ly8G39g1ujpNm/giphy.gif",
                Map.ofEntries(
                        Map.entry("group", 3),
                        Map.entry("project", 3),
                        Map.entry("present", 3),
                        Map.entry("reaction", 3),
                        Map.entry("teamwork", 2),
                        Map.entry("awkward", 3),
                        Map.entry("tired", 2),
                        Map.entry("frustrated", 3),
                        Map.entry("work", 2),
                        Map.entry("effort", 3),
                        Map.entry("team", 2),
                        Map.entry("responsibility", 3),
                        Map.entry("unfair", 3),
                        Map.entry("doing", 3),
                        Map.entry("friends", 1)
                )
        ));

        // ---------- MODERN FAMILY ----------
        memes.put("phil_sarcasm", new Meme(
                "Really...",
                "https://i.pinimg.com/originals/24/b7/ca/24b7ca32502e1941fed2bdf4afa87167.gif",
                Map.ofEntries(
                        Map.entry("feedback", 3),
                        Map.entry("presentation", 3),
                        Map.entry("joke", 2),
                        Map.entry("funny", 2),
                        Map.entry("pun", 1),
                        Map.entry("witty", 3),
                        Map.entry("humor", 2),
                        Map.entry("response", 1),
                        Map.entry("awkward", 2),
                        Map.entry("laugh", 2),
                        Map.entry("clever", 3),
                        Map.entry("snarky", 2),
                        Map.entry("teasing", 2),
                        Map.entry("comedy", 3),
                        Map.entry("comment", 1)
                )
        ));

        memes.put("gloria_yelling", new Meme(
                "Why are you shouting? I’m right here!",
                "https://i.pinimg.com/originals/34/ca/23/34ca237a92a7858404c036a0d5adfd9b.gif",
                Map.ofEntries(
                        Map.entry("shouting", 3),
                        Map.entry("loud", 3),
                        Map.entry("yelling", 3),
                        Map.entry("argument", 2),
                        Map.entry("annoyed", 3),
                        Map.entry("scream", 2),
                        Map.entry("fight", 2),
                        Map.entry("shout", 3),
                        Map.entry("upset", 2),
                        Map.entry("irritated", 3),
                        Map.entry("heated", 2),
                        Map.entry("furious", 2),
                        Map.entry("frustration", 3),
                        Map.entry("madness", 2),
                        Map.entry("dramatic", 3)
                )
        ));

        // ---------- THE BIG BANG THEORY ----------
        memes.put("sheldon_bazinga", new Meme(
                "Bazinga!",
                "https://media1.tenor.com/m/lXdlrxwLUCwAAAAC/bazinga-sheldon.gif",
                Map.ofEntries(
                        Map.entry("joke", 3),
                        Map.entry("prank", 3),
                        Map.entry("trick", 3),
                        Map.entry("haha", 2),
                        Map.entry("funny", 2),
                        Map.entry("kidding", 3),
                        Map.entry("troll", 2),
                        Map.entry("laugh", 2),
                        Map.entry("experiment", 1),
                        Map.entry("nerd", 2),
                        Map.entry("science", 1),
                        Map.entry("clever", 3),
                        Map.entry("smart", 2),
                        Map.entry("humor", 2)
                )
        ));

        memes.put("penny_confused", new Meme(
                "What is wrong with you?",
                "https://i.pinimg.com/originals/3c/6e/de/3c6ede407e4566abf2b3079d306fa287.gif",
                Map.ofEntries(
                        Map.entry("confused", 3),
                        Map.entry("crazy", 3),
                        Map.entry("weird", 3),
                        Map.entry("what", 2),
                        Map.entry("why", 2),
                        Map.entry("stupid", 2),
                        Map.entry("awkward", 2),
                        Map.entry("problem", 3),
                        Map.entry("silly", 2),
                        Map.entry("lost", 2),
                        Map.entry("dumb", 2),
                        Map.entry("surprised", 2),
                        Map.entry("unusual", 2),
                        Map.entry("strange", 2),
                        Map.entry("unexpected", 2)
                )
        ));

        // ---------- BREAKING BAD ----------
        memes.put("walter_power", new Meme(
                "I am the one who knocks.",
                "https://media.tenor.com/DjQrkDVYpHwAAAAM/breaking-bas-bryan-cranston.gif",
                Map.ofEntries(
                        Map.entry("boss", 3),
                        Map.entry("serious", 3),
                        Map.entry("angry", 3),
                        Map.entry("confident", 3),
                        Map.entry("leader", 3),
                        Map.entry("danger", 3),
                        Map.entry("power", 3),
                        Map.entry("control", 3),
                        Map.entry("fearless", 3),
                        Map.entry("warning", 3),
                        Map.entry("authority", 3),
                        Map.entry("respect", 2),
                        Map.entry("dominance", 3),
                        Map.entry("assertive", 3),
                        Map.entry("bold", 3),
                        Map.entry("boogie", 3)
                )
        ));

        memes.put("jesse_science", new Meme(
                "Yeah science!",
                "https://media1.giphy.com/media/v1.Y2lkPTZjMDliOTUydW9zMjRycGRyMjBvYXBvaWk2Z3pjN3Fwcng5ZWI1dDI5Z3Y5ajRpayZlcD12MV9naWZzX3NlYXJjaCZjdD1n/LiljwvntZmf4c/giphy.gif",
                Map.ofEntries(
                        Map.entry("success", 3),
                        Map.entry("worked", 3),
                        Map.entry("science", 3),
                        Map.entry("experiment", 3),
                        Map.entry("chemistry", 3),
                        Map.entry("test", 2),
                        Map.entry("finished", 2),
                        Map.entry("win", 2),
                        Map.entry("yes", 2),
                        Map.entry("correct", 2),
                        Map.entry("lab", 2),
                        Map.entry("result", 2),
                        Map.entry("solution", 2),
                        Map.entry("celebrate", 2),
                        Map.entry("achievement", 3)
                )
        ));

        memes.put("nana_control_uday", new Meme(
                "Control, Uday, Control!",
        "https://media.tenor.com/ZkgCCkSo70gAAAAM/control-control-welcome.gif",
                Map.ofEntries(
                        Map.entry("angry", 3),
                        Map.entry("control", 3),
                        Map.entry("shout", 2),
                        Map.entry("calm", 2),
                        Map.entry("funny", 3),
                        Map.entry("boss", 2),
                        Map.entry("temper", 3),
                        Map.entry("patience", 2),
                        Map.entry("warning", 2),
                        Map.entry("fight", 2),
                        Map.entry("tension", 2),
                        Map.entry("movie", 1),
                        Map.entry("dialogue", 2),
                        Map.entry("classic", 2),
                        Map.entry("welcome", 3)
                )
        ));

        memes.put("fallback_default", new Meme(
                "This is a fallback meme in case I don't have a proper response in the repository ",
                "https://media.tenor.com/7QhoA9wcstgAAAAM/confused-no.gif",
                Map.ofEntries(
                        Map.entry("unknown", 1),
                        Map.entry("random", 1),
                        Map.entry("default", 1),
                        Map.entry("fallback", 1)
                )));

        return memes;
    }
}
