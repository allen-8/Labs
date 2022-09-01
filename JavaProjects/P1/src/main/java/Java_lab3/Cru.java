package Java_lab3;

public enum Cru {
    BASE (80),
    PREMIER (90),
    GRAND(100);
    private final int quality;
    Cru (int q) { quality = q; }
    public int qetQuality() { return quality; }
}
