package com.savinglives;

import java.util.ArrayList;

    //TODO change from ArrayList to HashMap (?or HashTable) for faster

public class MiniCart {
    private ArrayList<CartItem> items = null;

    public MiniCart() {
        this.items = new ArrayList<>();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }
    public void addItem(CartItem newItem) {
        this.items.add(newItem);
    }
    public void emptyCart() {
        items.clear();
    }

    public CartItem getByProductId(String productId) {
        for (CartItem i : items) {
            if (i.getProductId() == productId) {
                return i;
            }
        }
        return null; //not found
    }
        //returns new quantity - can be 1,2,etc.
    public int incrItem(CartItem in) {
        CartItem ci = getByProductId(in.getProductId());
        int newq = 0;
        if (ci != null) { //already exists
            ci.setQuantity(ci.getQuantity()+1);
            newq = ci.getQuantity();
        } else {
            in.setQuantity(1);
            addItem(in);
            newq = 1;
        }
        return newq;
    }
        //returns new quantity - can be zero
    public int decrItem(CartItem in) {
        CartItem ci = getByProductId(in.getProductId());
        int newq = 0;
        if (ci != null) { //already exists
            if (ci.getQuantity()==1) { //remove it!
                newq = 0;
                items.remove(ci);
            } else {
                newq = ci.getQuantity() - 1;
                ci.setQuantity(newq);
            }
        } else { //does not exist
            //TODO SHOULD THROW exception or log PROGERR
            newq = 0;
        }
        return newq;
    }
    public void deleteItem(String productId) {
        for (CartItem i : items) {
            if (i.getProductId() == productId) {
                items.remove(items.indexOf(i));
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "MiniCart{" +
                "items=" + items +
                '}';
    }
}
