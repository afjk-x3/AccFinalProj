package finalProj;

public class Capital {
    // Method to calculate total capital
    public static float computeTotalCapital() {
        return Titles.proprietorCapital - Titles.proprietorDrawing;
    }
}