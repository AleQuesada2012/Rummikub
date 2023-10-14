package src;

public class Ficha {
    private int num;

    private String color;



    public void  getficha(){
        System.out.println(getNum());
        System.out.println(getColor());
    }

    public Ficha(int num,String color){
        setColor(color);
        setNum(num);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    // this is a test commit
}
