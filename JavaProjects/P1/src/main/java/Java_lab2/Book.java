package Java_lab2;

public class Book {
    private String title;
    private Author author;
    private double price;
    private void check(String t, double p)
    {
        title = (t.isEmpty()) ? "unknown" : t;
        price = (p < 0) ? 0 : p;
    }
    private void setAuth(String a)
    {
        String[] str = a.split(" ");
        switch (str.length) {
            case 0 -> author = new Author("unknown_name", "unknown_surname");
            case 1 -> author = new Author(str[0], "unknown_surname");
            default -> {
                String s = "";
                for (int i = 0; i < str.length - 1; ++i)
                    s = s + str[i] + " ";
                s = s.substring(0, s.length() - 1);
                author = new Author(s, str[str.length - 1]);
            }
        }
    }
    Book(String t, Author a, double p) { check(t, p); author = a; }
    Book(String t, String a, double p) { check(t, p); setAuth(a); }
    public String getTitle() { return title; }
    public Author getAuthor() { return author; }
    public double getPrice() { return price; }
    public void setTitle(String t) { title = (t.isEmpty()) ? "unknown" : t; }
    public void setAuthor(Author a) { author = a; }
    public void setAuthor(String a) { setAuth(a); }
    public void setPrice(double p) { price = (p < 0) ? 0 : p; }
    @Override
    public String toString() { return String.format("'%s' by %s (%.2f $)", title, author, price); }
}
