package system12306;

public class Ticket {
    private String Start;
    private String end;
    private Float price;

    public Ticket() {
    }

    public Ticket(String start, String end, Float price) {
        Start = start;
        this.end = end;
        this.price = price;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Start='" + Start + '\'' +
                ", end='" + end + '\'' +
                ", price=" + price +
                '}';
    }
}
