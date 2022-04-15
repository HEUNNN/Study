package kr.UDDT;

public class MovieVO {
    private String title;
    private int price;
    private String character;
    private int grade;
    private int hours;

    public MovieVO(){
        // default 생성자
    }
    public MovieVO(String title, int price, String character, int grade, int hours){
        this.title = title;
        this.price = price;
        this.character = character;
        this.grade = grade;
        this.hours = hours;
    }

    public void setMovie(String title, int price, String character, int grade, int hours){
        this.title = title;
        this.price = price;
        this.character = character;
        this.grade = grade;
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public String getTitle() {
        return title;
    }

    public String getCharacter() {
        return character;
    }

    public int getGrade() {
        return grade;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "MovieVO [title=" + title + ", price=" + price + ", character=" + character + ", grade=" + grade +", hours=" + hours+"]";
    }
}
