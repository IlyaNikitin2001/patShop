/**
 * Created by USER on 06.03.2017.
 */
public class Dog {
    String name;
    int weight;
    String poroda;
    public Dog(){

    }

    public Dog (String name, int  weight, String poroda){
        this.name= name;
        this.weight= weight;
        this.poroda= poroda;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
   public void setWeight(int weight){
        this.weight=weight;
    }
    public int getWeight(){
        return weight;
    }

    public void setPoroda(String poroda){
        this.poroda=poroda;
    }
    public String getPoroda(){
        return poroda;
    }


}
