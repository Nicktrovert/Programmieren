public class Item{
    private String name;
    private int type;
    private int value;
    private int quality;

    public static void main(String[] args){

    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(int type){
        this.type = type;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setQuality(int quality){
        this.quality = quality;
    }

    public String getName(){
        return this.name;
    }

    public int getType(){
        return this.type;
    }

    public int getQuality(){
        return this.quality;
    }

    public int getValue(){
        return this.value;
    }

    public String translateType(){
        return switch (getType()){
            case 0 -> "armor";
            case 1 -> "weapon";
            case 2 -> "potion";
            case 3 -> "consumable";
            default -> "";
        };
    }

    public String translateQuality(){
        return switch (quality){
            case 0 -> "average";
            case 1 -> "unusual";
            case 2 -> "rare";
            case 3 -> "epic";
            case 4 -> "legendary";
            default -> "";
        };
    }

    public String describe(){
        return String.format("%s, %s (%s), %d gold", getName(), translateType(), translateQuality(), getValue());
    }
}