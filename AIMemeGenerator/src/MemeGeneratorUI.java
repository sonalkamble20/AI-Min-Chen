import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MemeGeneratorUI extends JFrame {

    private JTextField inputField;
    private JLabel imageLabel;
    private JLabel captionLabel;
    private Meme currentMeme;

    public MemeGeneratorUI() {
        setTitle("AI Meme Generator 🤖😂");
        setSize(900, 700); // smaller window by default
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen

        // Main layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 236, 179));

        // Top input bar
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(new Color(255, 213, 79));

        JLabel promptLabel = new JLabel("Describe your situation:");
        inputField = new JTextField(25);
        JButton generateButton = new JButton("Generate Meme 🎉");

        generateButton.addActionListener(e -> generateMeme());
        inputField.addActionListener(e -> generateMeme());

        topPanel.add(promptLabel);
        topPanel.add(inputField);
        topPanel.add(generateButton);

        // Meme display label
        imageLabel = new JLabel("", SwingConstants.CENTER);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(new Color(255, 236, 179));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Caption label
        captionLabel = new JLabel("", SwingConstants.CENTER);
        captionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        captionLabel.setForeground(new Color(183, 28, 28));
        captionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(imageLabel, BorderLayout.CENTER);
        mainPanel.add(captionLabel, BorderLayout.SOUTH);

        add(mainPanel);

        // When window resizes, re-render current meme
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                if (currentMeme != null) {
                    renderMeme(currentMeme);
                }
            }
        });
    }

    private void generateMeme() {
        String userText = inputField.getText();
        Meme meme = MemeMatcher.findBestMeme(userText);

        if (meme == null) {
            JOptionPane.showMessageDialog(this, "No suitable meme found! Try another phrase.");
            return;
        }

        currentMeme = meme;
        captionLabel.setText(meme.getCaption());
        renderMeme(meme);
    }

    private void renderMeme(Meme meme) {
        try {
            URL url = new URL(meme.getImageUrl());
            String imgUrl = meme.getImageUrl().toLowerCase();

            // Get window size
            int frameWidth = getContentPane().getWidth();
            int frameHeight = getContentPane().getHeight() - captionLabel.getHeight() - 40;

            imageLabel.setIcon(null);
            imageLabel.setText("");

            if (imgUrl.endsWith(".gif")) {
                // Scale GIF to fill the window
                ImageIcon gifIcon = new ImageIcon(url);
                Image scaledGif = gifIcon.getImage().getScaledInstance(
                        frameWidth, frameHeight, Image.SCALE_DEFAULT);
                imageLabel.setIcon(new ImageIcon(scaledGif));
            } else {
                // Scale static image
                ImageIcon icon = new ImageIcon(url);
                Image scaled = icon.getImage().getScaledInstance(
                        frameWidth, frameHeight, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaled));
            }

            imageLabel.revalidate();
            imageLabel.repaint();

        } catch (Exception ex) {
            imageLabel.setText("⚠️ Could not load meme image.");
            imageLabel.setIcon(null);
        }
    }

}
