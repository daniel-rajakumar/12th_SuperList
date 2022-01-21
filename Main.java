import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

public class Main
{
    SuperList<Integer> list_arrayList;
    SuperList<Integer> list_stack;
    SuperList<Integer> list_queue;
    SuperList<String> list_string;

	public Main() {
        one();
        two();
        three();
        four();
        five();
        six();
        seven();
        eight();
        nine();
        ten();
        eleven();
        twelve();
        thirteen();
        fourteen();
        fifteen();
        sixteen();
        seventeen();
        eighteen();
        nineteen();
	}

    void one(){
        list_arrayList = new SuperList<>();
        for (int i = 0; i < 30; i++){
            list_arrayList.add(random(1, 1000));
        }
        System.out.println("1 -> " + list_arrayList);
    }

    void two(){
        System.out.println("2 -> " + list_arrayList.toString());
    }

    void three(){
        System.out.println("3 -> size: " + list_arrayList.size());
    }

    void four(){
        list_stack = new SuperList<>();

        System.out.print("4 -> array: " + list_arrayList);
        while (!list_arrayList.isEmpty()){
            list_stack.push(list_arrayList.remove(0));
        }
        System.out.println(" => stack: " + list_stack);
    }

    void five(){
        System.out.print("5 -> stack: " + list_stack);

        list_queue = new SuperList<>();

        while (!list_stack.isEmpty()){
            list_queue.add(list_stack.pop());
        }
        System.out.println(" => queue: " + list_queue);
    }

    void six(){
        System.out.print("6 -> queue: " + list_queue);

        while (!list_queue.isEmpty()) {
            list_arrayList.add(random(0, list_arrayList.size()), list_queue.poll());
        }

        System.out.println(" => array: " + list_arrayList);
    }

    void seven(){
        int sum = 0;

        for (int i = 0; i < list_arrayList.size(); i++){
            sum += list_arrayList.get(i);
        }

        System.out.println("7 -> sum: " + sum);
    }

    void eight(){
        int sum = 0;
        for (int i = 0; i < list_arrayList.size(); i+=2){
            sum += list_arrayList.get(i);
        }
        System.out.println("8 -> even sum: " + sum);
    }

    void nine(){
        int sum = 0;
        for (int i = 1; i < list_arrayList.size(); i+=2){
            sum += list_arrayList.get(i);
        }
        System.out.println("9 -> odd sum: " + sum);
    }

    void ten(){
        int size = list_arrayList.size();
        for (int i = 0; i < size; i+=2){
            list_arrayList.add(list_arrayList.get(i));
        }
        System.out.println("10 -> " + list_arrayList);
    }

    void eleven(){
        for (int i = 0; i < list_arrayList.size(); i++){
            if (list_arrayList.get(i) % 3 == 0){
                list_arrayList.remove(i);
            }
        }
        System.out.println("11 -> " + list_arrayList);
    }

    void twelve(){
        list_arrayList.add(3, 55555);
        System.out.println("12 -> " + list_arrayList);
    }

    void thirteen(){
        for (int i = 1; i < list_arrayList.size(); i++){
            int key = list_arrayList.get(i);

            for (int j = i - 1; (j >= 0) && (list_arrayList.get(j) < key); j--){
                list_arrayList.add(j + 1, list_arrayList.remove(j));
            }
        }

        System.out.println("13 -> " + list_arrayList);
    }

    void fourteen() {
        int median, beforeMedian, afterMedian;

        if (list_arrayList.size() % 2 == 1){
            beforeMedian = list_arrayList.get(list_arrayList.size()/2 - 1);
            median = list_arrayList.get(list_arrayList.size()/2);
            afterMedian = list_arrayList.get(list_arrayList.size()/2 + 1);

        } else {
            beforeMedian = list_arrayList.get(list_arrayList.size()/2 - 2);
            median = (list_arrayList.get(list_arrayList.size()/2) + list_arrayList.get(list_arrayList.size()/2 - 1)) / 2;
            afterMedian = list_arrayList.get(list_arrayList.size()/2 + 1);
        }

        System.out.print("14 -> median: " + median);
        System.out.print("    |    14 -> before median: " + beforeMedian);
        System.out.println("    |    14 -> after median: " + afterMedian);
    }

    void fifteen(){
        list_string = new SuperList<>();
        System.out.println("15 -> " + list_string);
    }

    void sixteen(){
        String sentence = "Java is a high level, class based, object oriented programming language that is designed to have as few implementation dependencies as possible.";

        String[] arr = sentence.replaceAll("[^a-zA-Z ]", "").split(" ");

        for (int i = 0; i < arr.length; i++){
            list_string.add(arr[i]);
        }

        System.out.println("16 -> " + list_string);
    }

    void seventeen(){
        for (int i = 0; i < list_string.size(); i++){
            if (list_string.get(i).length() <= 3)
                list_string.remove(i--);
        }

        System.out.println("17 -> " + list_string);
    }

    void eighteen() {
        sortString(list_string);
        System.out.println("18 -> " + list_string);
    }

    void nineteen(){
        double sum = 0;
        for (int i = 0; i < list_string.size(); i++){
            sum += list_string.get(i).length();
        }

        sum /= list_string.size();

        System.out.println("19 -> average word length: " + sum);
    }


    void sortString(SuperList<String> list){
        for (int i = 1; i < list.size(); i++) {
            String key = list.get(i);

            for (int j = i - 1; (j >= 0) && (list.get(j).compareToIgnoreCase(key) > 0); j--){
                list.add(j + 1, list.remove(j));
            }
        }
    }


    int random(int from, int to){
        return (int)(Math.random() * (to - from + 1)) + from;

    }

	public static void main(String[] args) {
		new Main();
	}



}