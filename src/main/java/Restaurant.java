import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        LocalTime currentTime = getCurrentTime();
        return currentTime.isAfter(this.openingTime) && currentTime.isBefore(this.closingTime);
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public String getName() {
        return name;
    }

//    public int getOrderTotal(String[] itemNames) throws itemNotFoundException{
//        int orderTotal = 0;
//        String notFoundItem = "";
//        for(int i=0 ; i<itemNames.length ; i++){
//            for(Item item: menu){
//                if(item.getName().equals(itemNames[i])){
//                    orderTotal += item.getPrice();
//                }
//                notFoundItem = item.getName();
//            }
//            throw new itemNotFoundException(notFoundItem);
//        }
//        return orderTotal;
//    }

}
