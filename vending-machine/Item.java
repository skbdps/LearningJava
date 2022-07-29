public class Item {
    private String name;
    private double price;
    private int quantity;

//Constructor
    public Item(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
//Copy COnstructor

    public Item(Item source){
        this.name = source.name;
        this.price = source.price;
        this.quantity=source.quantity;
    }

//Getters

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }public int getQuantity(){
        return quantity;
    }

//Setters

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

//Tostring

    public String toString() {
        return this.name + ": " + this.price + " ("+this.quantity+")";
    }
}
