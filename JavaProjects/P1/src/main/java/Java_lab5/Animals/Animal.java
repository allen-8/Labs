package Java_lab4.Java_lab5.Animals;

public class Animal
{
    private String name;
    private String latin_name;
    private String animal_type;
    private String active_time;
    private double length_min;
    private double length_max;
    private double weight_min;
    private double weight_max;
    private int lifespan;
    private String habitat;
    private String diet;
    private String geo_range;
    private String image_link;
    private int id;
    public Animal(String name, String latin_name, String animal_type, String active_time, double length_min,
                      double length_max, int weight_min, int weight_max, int lifespan, String habitat, String diet,
                      String geo_range, String image_link, int id)
    {
        this.name = name;
        this.latin_name = latin_name;
        this.animal_type = animal_type;
        this.active_time = active_time;
        this.length_min = length_min;
        this.length_max = length_max;
        this.weight_min = weight_min;
        this.weight_max = weight_max;
        this.lifespan = lifespan;
        this.habitat = habitat;
        this.diet = diet;
        this.geo_range = geo_range;
        this.image_link = image_link;
        this.id = id;
    }
    public String getData()
    {
        return String.format("Name: %s\nLatin Name: %s\nAnimal Type: %s\nActive Time: %s\nMinimal Length: %f\n" +
                "Maximal Length: %f\nMinimal Weight: %f\nMaximal Weight: %f\nLifespan: %d\nHabitat: %s\n" +
                "Diet: %s\nGeographic Range: %s\nImage Link: %s\nID: %d", name, latin_name, animal_type, active_time,
                length_min, length_max, weight_min, weight_max, lifespan, habitat, diet, geo_range, image_link, id);
    }
    public String getName() {
        return name;
    }
    public String getLatin_name() {
        return latin_name;
    }
    public String getAnimal_type() {
        return animal_type;
    }
    public String getActive_time() {
        return active_time;
    }
    public double getLength_min() {
        return length_min;
    }
    public double getLength_max() {
        return length_max;
    }
    public double getWeight_min() {
        return weight_min;
    }
    public double getWeight_max() {
        return weight_max;
    }
    public int getLifespan() {
        return lifespan;
    }
    public String getHabitat() {
        return habitat;
    }
    public String getDiet() {
        return diet;
    }
    public String getGeo_range() {
        return geo_range;
    }
    public String getImage_link() {
        return image_link;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLatin_name(String latin_name) {
        this.latin_name = latin_name;
    }
    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }
    public void setActive_time(String active_time) {
        this.active_time = active_time;
    }
    public void setLength_min(double length_min) {
        this.length_min = length_min;
    }
    public void setLength_max(double length_max) {
        this.length_max = length_max;
    }
    public void setWeight_min(double weight_min) {
        this.weight_min = weight_min;
    }
    public void setWeight_max(double weight_max) {
        this.weight_max = weight_max;
    }
    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    public void setDiet(String diet) {
        this.diet = diet;
    }
    public void setGeo_range(String geo_range) {
        this.geo_range = geo_range;
    }
    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }
    public void setId(int id) {
        this.id = id;
    }
}
