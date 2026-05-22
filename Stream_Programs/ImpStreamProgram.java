import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ImpStreamProgram {


    public static void main(String[] args) {
     //   removeDuplicateAndSortInDescendingOrder();
      //  findOddAndReturnSquares();
        find2ndAnd3rdItem();

    }





    //Q1. Remove duplicates & sort in descending order
    public static void removeDuplicateAndSortInDescendingOrder(){
        List<Integer> uniqueSortedList = Arrays.asList(1,2,2,1,19,21,15,19,14,11,30);
        uniqueSortedList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //Q2. From the List of Integers Find All the Odd numbers and Return their Squares
    public static void findOddAndReturnSquares(){
        List<Integer> inputList = Arrays.asList(1,2,2,1,19,21,15,19,14,11,30);
        inputList.stream().distinct().filter(n->n%2!=0).map(n->n*n).forEach(System.out::println);
    }

    //Q3. We have a list of Integers get 2nd and 3rd element from it return item in a list
    public static void find2ndAnd3rdItem(){
        List<Integer> inputList = Arrays.asList(1,2,2,1,19,21,15,19,14,11,30);
        List<Integer> desiredList = inputList.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(desiredList);
    }

    //Q3. We have a list Find the Second Highest Number from a list
    public static void find2ndHighest(){
        List<Integer> oddSquares = Arrays.asList(1,2,2,1,19,21,15,19,14,11,30);
        List<Integer> desiredList = oddSquares.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(desiredList);
    }





}
