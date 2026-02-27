import java.util.Map;

public class MemeMatcher {

    public static Meme findBestMeme(String userText) {

        if (userText == null || userText.isBlank()) {
            return MemeRepository.getAllMemes().get("fallback_default");
        }

        userText = userText.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

        Map<String, Meme> memes = MemeRepository.getAllMemes();
        Meme bestMeme = null;
        int bestScore = 0;

        for (Meme meme : memes.values()) {
            int score = 0;

            for (Map.Entry<String, Integer> entry : meme.getKeywords().entrySet()) {
                if (userText.contains(entry.getKey())) {
                    score += entry.getValue();
                }
            }

            if (score > bestScore) {
                bestScore = score;
                bestMeme = meme;
            }
        }

        // Explicit fallback handling
        if (bestScore == 0) {
            return memes.get("fallback_default");
        }

        return bestMeme;
    }
}
