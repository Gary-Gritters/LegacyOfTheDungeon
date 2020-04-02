public class Inventory {

    Item[] myInventory = new Item[8];

    public Inventory() {
        for(int i = 0; i < 8; i++) {
            myInventory[i] = new Weapon();
        }
    }

    public Inventory(Item[] myInventory) {
        this.myInventory = myInventory;
    }

    public Item[] getMyInventory() {
        return myInventory;
    }

    public Item getItem(int place, Inventory i) {
        if(place > -1 && place < 8){
            return i.getMyInventory()[place];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addItem(Inventory i, Item thisOne){
        if(isFull(i)){
            //handle this later
        } else {
            for(int j = 0; j < 8; j++){
                if(i.myInventory[j].getItemName() == ""){
                    i.myInventory[j] = thisOne;
                    break;
                }
            }
        }
    }

    public Boolean isFull(Inventory i){
        for(int j = 0; j < 8; j++){
            if(i.getItem(j, this).getItemName() == ""){
                return false;
            }
        }
        return true;
    }
}