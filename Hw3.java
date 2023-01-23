import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Hw3 {
    public static void main(String[] args) {
        // *1 Объявить два списка список ArrayList, в каждый добавить по 20 случайных чисел. 
        //     Удалить из первого списка элементы отсутствующие во втором списке. 
        //     Отсортировать первый список методом sort класса Collections.
        Random rnd = new Random();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list1.add(rnd.nextInt(50));
        }
        System.out.println("\nЗадание 1.\nСписок 1: " + list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list2.add(rnd.nextInt(50));
        }
        System.out.println("Список 2: " + list2);

        ArrayList<Integer> copy_list1 = new ArrayList<>(list1);
        copy_list1.retainAll(list2);
        System.out.println("\nУдаление из первого списка элементов отсутствующих во втором списке:\n" + copy_list1);
    
        list1.sort(Collections.reverseOrder());
        System.out.println("\nПервый список отсортированный методом sort класса Collections:\n" + list1);
    
    
        //2 * Отсортировать второй список методом sort списка и компаратором по уменьшению.
    
        list2.sort(new Comparator<Integer>() {
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        System.out.println("\nЗадание 2.\nСортировка второго списка методом sort списка и компаратором по уменьшению:\n" + list2);
    
        //3 **Отсортировать первый список пузырьковой сортировкой самостоятельно, без использования доп методов и классов.*/
       
        for (int i = 0; i < list1.size(); i++) {
            int max = list1.get(i);
            int ind_max = i;
            for (int j = i + 1; j < list1.size(); j++) {
                if (max < list1.get(j)) {
                    max = list1.get(j);
                    ind_max = j;
                }
            }
            list1.add(i, max);
            list1.remove(ind_max + 1);
        }
        System.out.println("\nЗадание 3.\nПузырьковая сортировка примененная к первому списку:\n" + list1);
    }

}
    
    


