public class Inventory{
    public Item[] bag = null;

    public static void main(String[] args){

    }

    public void setBagSize(int size){
        bag = new Item[size];
    }

    public boolean addItem(Item item){
        boolean wasSuccessful = false;
        for (int i = 0; i < bag.length; i++){
            if (bag[i] == null){
                bag[i] = item;
                wasSuccessful = true;
                break;
            }
        }

        System.out.println(wasSuccessful ? "success" : "no free");
        return wasSuccessful;
    }

    public void listAllItemsOfType(int type){
        for (Item item : bag) {
            if (item != null) {
                if (item.getType() == type) {
                    System.out.println(item.describe());
                }
            }
        }
    }

    public void listAllItemsOfQuality(int quality){
        for (Item item : bag) {
            if (item != null) {
                if (item.getQuality() == quality) {
                    System.out.println(item.describe());
                }
            }
        }
    }

    public void lookAtInventory(){
        int totalValue = 0;
        for (int i = 0; i < bag.length; i++) {
            Item item = bag[i];
            if (item != null) {
                totalValue += item.getValue();
            }
            System.out.println("slot " + i + ":\t" + (item == null ? "free" : item.describe()));
        }
    }

    public Item[] getBag(){
        return bag;
    }
}