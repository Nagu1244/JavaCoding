package TechnicalROund;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

            public static void main(String[] args) {
                List<Item> items = Arrays.asList(
                        new Item("apple", 10L),
                        new Item("banana", 30L),
                        new Item("orange", 10L),
                        new Item("papaya", null),
                        new Item(null, 10L),
                        new Item("banana", 10L),
                        new Item("apple", 20L));

               List<Item> nonNullList = items.stream().filter(i1-> i1.getItem() != null && i1.getQty() != null).collect(Collectors.toList());
               System.out.println(nonNullList);
            }
        }

    class Item {
        String item;
        Long qty;
        public String getItem() {
            return item;
        }
        public void setItem(String item) {
            this.item = item;
        }
        public Long getQty() {
            return qty;
        }
        public void setQty(Long qty) {
            this.qty = qty;
        }

        public Item(String item, Long qty) {
            this.item = item;
            this.qty = qty;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "item='" + item + '\'' +
                    ", qty=" + qty +
                    '}';
        }

            //O/P: {3,5}, {1,7}
        }



