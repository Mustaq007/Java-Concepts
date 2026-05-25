import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImpStreamProgram {

    static class Employee {
        private int id;
        private String name;
        private Integer salary;

        public Employee(int id, String name, Integer salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "'}";
        }
    }


    public static void main(String[] args) {
       // removeDuplicateAndSortInDescendingOrder();
       // findOddAndReturnSquares();
      //  find2ndAnd3rdItem();
        //find2ndHighest();
        //divideEvenAndOdd();
      //  returnLongestString();
        //returnFirst50KSalary();
        returnTopTwoHighestPaid();

    }


    //Q1. Remove duplicates & sort in descending order
    public static void removeDuplicateAndSortInDescendingOrder(){
        List<Integer> uniqueSortedList = Arrays.asList(1,2,2,1,19,21,15,19,14,11,30);
        uniqueSortedList.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
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

    //Q4. We have a list Find the Second Highest Number from a list
    public static void find2ndHighest(){
        List<Integer> oddSquares = Arrays.asList(1,2,2,1,19,21,15,19,14,11,30);
        Optional<Integer> secondHighest = oddSquares.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        secondHighest.ifPresent(System.out::println);

    }

    //Q5. You have a list of Integers Divide them into even and odd
    public static void divideEvenAndOdd(){
        List<Integer> inputList = Arrays.asList(1,2,2,1,19,21,15,19,14,11,30);
        Map<Boolean, List<Integer>> collect = inputList.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(collect);
    }

    //Q6. You have a list String Return the longest String
    public static void returnLongestString(){
        List<String> inputList = Arrays.asList("Hello","Java","Playground");
        Optional<String> max = inputList.stream().max(Comparator.comparing(elem -> elem.length()));
        max.ifPresent(System.out::println);

    }

    //Q7. From a list of Employees Find the first Employee Whose salary is greater than 50000
    public static void returnFirst50KSalary(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000),
                new Employee(2,"Vinesh",60000),
                new Employee(3,"Anuj",52000),
                new Employee(4,"Harsh",51000));
        Optional<Employee> first = inputList.stream().filter(n -> n.getSalary() > 50000).sorted(Comparator.comparing(elem -> elem.getSalary())).findFirst();
        first.ifPresent(System.out::println);

    }


    //Q8. From a list of Employees Find the top two highest paid Employee
    public static void returnTopTwoHighestPaid(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000),
                new Employee(2,"Vinesh",60000),
                new Employee(3,"Anuj",52000),
                new Employee(4,"Harsh",51000),
                new Employee(4,"Sankar",88000),
                new Employee(5,"Madhab",85000));
       inputList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).forEach(System.out::println);
    }


    //Q7. From a list of Employees Sort it According to Salary Then Sort it According to names
//    public static void returnTopTwoHighestPaid(){
//        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000),
//                new Employee(2,"Vinesh",60000),
//                new Employee(3,"Anuj",52000),
//                new Employee(4,"Harsh",51000),
//                new Employee(4,"Sankar",88000),
//                new Employee(5,"Madhab",85000));
//        inputList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).forEach(System.out::println);
//    }









}
