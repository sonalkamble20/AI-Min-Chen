public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MemeGeneratorUI ui = new MemeGeneratorUI();
            ui.setVisible(true);
        });
    }
}
