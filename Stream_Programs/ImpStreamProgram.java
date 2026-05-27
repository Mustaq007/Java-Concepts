import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImpStreamProgram {

    static class Employee {
        private int id;
        private String name;
        private Integer salary;
        private String dept;

        public Employee(int id, String name, Integer salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public Employee(int id, String name, Integer salary, String dept) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.dept = dept;
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

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", dept='" + dept + '\'' +
                    '}';
        }
    }

    static class Expenses {
        private int id;
        private String category;
        private Integer amount;

        public Expenses(int id, String category, Integer amount) {
            this.id = id;
            this.category = category;
            this.amount = amount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Expenses{" +
                    "id=" + id +
                    ", category='" + category + '\'' +
                    ", amount=" + amount +
                    '}';
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
      //  returnTopTwoHighestPaid();
       // sortEmployeeSaleryThenByNames();
     //   findFrequencyOfEachElement();
      //  findTotalTransaction();
      //  findAverageSalaryFromEachDept();
     //   findHighestSalaryFromEachDept();
       // groupEmployeeAccordingToDept();
       // convertEmployeeListIntoCommaSeparatedNames();
        //findCommonBetweenTwoList();
       // convertListOfListIntoSingleList();
        printEmployees();

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


    //Q9. From a list of Employees Sort it According to Salary Then Sort it According to names
    public static void sortEmployeeSalaryThenByNames(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000),
                new Employee(2,"Vinesh",60000),
                new Employee(3,"Anuj",52000),
                new Employee(4,"Harsh",51000),
                new Employee(5,"Anand",51000),
                new Employee(6,"Sankar",88000),
                new Employee(7,"Madhab",85000),
                new Employee(8,"Abhishek",52000));
        inputList.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).forEach(System.out::println);
    }

    //Q10. We have a list Find the Frequncy of each Element in a list
    public static void findFrequencyOfEachElement(){
        List<Integer> inputList = Arrays.asList(1,2,2,1,19,21,15,19,14,11,30);
        Map<Integer, Long> collect = inputList.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println(collect);

    }

    //Q11. From a list of Employees Group them according to department
    public static void groupEmployeeByDept(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000,"Devops"),
                new Employee(2,"Vinesh",60000,"Engineering"),
                new Employee(3,"Anuj",52000,"Engineering"),
                new Employee(4,"Harsh",51000,"Product"),
                new Employee(5,"Anand",51000,"HR"),
                new Employee(6,"Sankar",88000,"Admin"),
                new Employee(7,"Madhab",85000,"Admin"),
                new Employee(8,"Abhishek",52000,"Engineering"));
        Map<String, Long> collect = inputList.stream().collect(Collectors.groupingBy(n -> n.getDept(), Collectors.counting()));
        System.out.println(collect);
    }

    //Q12. Find the total transaction amount from each category
    public static void findTotalTransaction(){
        List<Expenses> inputList = Arrays.asList(
                new Expenses(1, "Food", 200),
                new Expenses(2, "Travel", 1200),
                new Expenses(3, "Utilities", 800),
                new Expenses(4, "Food", 450),
                new Expenses(5, "Shopping", 1500),
                new Expenses(6, "Travel", 600),
                new Expenses(7, "Health", 900),
                new Expenses(8, "Utilities", 300),
                new Expenses(9, "Food", 350)
        );

        Map<String, Integer> totalByCategory = inputList.stream()
                .collect(Collectors.groupingBy(Expenses::getCategory, Collectors.summingInt(Expenses::getAmount)));

        System.out.println(totalByCategory);
    }


    //Q13. Given List of employees find average salary from each department
    public static void findAverageSalaryFromEachDept(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000,"Devops"),
                new Employee(2,"Vinesh",60000,"Engineering"),
                new Employee(3,"Anuj",52000,"Engineering"),
                new Employee(4,"Harsh",51000,"Product"),
                new Employee(5,"Anand",51000,"HR"),
                new Employee(6,"Sankar",88000,"Admin"),
                new Employee(7,"Madhab",85000,"Admin"),
                new Employee(8,"Abhishek",52000,"Engineering"));
        Map<String, Double> collect = inputList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingInt(Employee::getSalary)));
        System.out.println(collect);
    }


    //Q14. Given List of employees find Higest salary from each department
    public static void findHighestSalaryFromEachDept(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000,"Devops"),
                new Employee(2,"Vinesh",60000,"Engineering"),
                new Employee(3,"Anuj",52000,"Engineering"),
                new Employee(4,"Harsh",51000,"Product"),
                new Employee(5,"Anand",51000,"HR"),
                new Employee(6,"Sankar",88000,"Admin"),
                new Employee(7,"Madhab",85000,"Admin"),
                new Employee(8,"Abhishek",52000,"Engineering"));
        Map<String, Optional<Employee>> result = inputList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        System.out.println(result);
    }


    //Q15. Given List of employees Group Them According to Department
    public static void groupEmployeeAccordingToDept(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000,"Devops"),
                new Employee(2,"Vinesh",60000,"Engineering"),
                new Employee(3,"Anuj",52000,"Engineering"),
                new Employee(4,"Harsh",51000,"Product"),
                new Employee(5,"Anand",51000,"HR"),
                new Employee(6,"Sankar",88000,"Admin"),
                new Employee(7,"Madhab",85000,"Admin"),
                new Employee(8,"Abhishek",52000,"Engineering"));

        Map<String, List<Employee>> collect = inputList.stream().collect(Collectors.groupingBy(Employee::getDept));
        System.out.println(collect);
    }

    //Q16. Given List of employees Convert the list into comma-separated string of Employee names.
    public static void convertEmployeeListIntoCommaSeparatedNames(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000,"Devops"),
                new Employee(2,"Vinesh",60000,"Engineering"),
                new Employee(3,"Anuj",52000,"Engineering"),
                new Employee(4,"Harsh",51000,"Product"),
                new Employee(5,"Anand",51000,"HR"),
                new Employee(6,"Sankar",88000,"Admin"),
                new Employee(7,"Madhab",85000,"Admin"),
                new Employee(8,"Abhishek",52000,"Engineering"));

        String collect = inputList.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    //Q17. Given List of employees Convert the list into comma-separated string of Employee names.
    public static void findCommonBetweenTwoList(){

        //below program will use time complexity of o(n)
//        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
//        List<Integer> list2 = Arrays.asList(4,5,6,7,8);
//        list2.stream().filter(n-> list1.contains(n)).forEach(System.out::println);

        //below is the optimized version of it for time complexity O(1)
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(4,5,6,7,8);
        Set<Integer> list1Set = new HashSet<>(list1);

        list2.stream().filter(n-> list1Set.contains(n)).forEach(System.out::println);

    }


    //Q18. you have a list of list convert it into a single list with all the elements. Remove Duplicate if any
    public static void convertListOfListIntoSingleList(){
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 6),
                Arrays.asList(7, 8, 9, 10, 11),
                Arrays.asList(12, 13, 14, 15, 16)
        );

        list.stream().flatMap(n->n.stream().distinct()).forEach(System.out::println);
    }

    //Q19. Given List of employees Print them very fast (The Order doesnot matter)
    public static void printEmployees(){
        List<Employee> inputList = Arrays.asList(new Employee(1,"Ravi",40000,"Devops"),
                new Employee(2,"Vinesh",60000,"Engineering"),
                new Employee(3,"Anuj",52000,"Engineering"),
                new Employee(4,"Harsh",51000,"Product"),
                new Employee(5,"Anand",51000,"HR"),
                new Employee(6,"Sankar",88000,"Admin"),
                new Employee(7,"Madhab",85000,"Admin"),
                new Employee(8,"Abhishek",52000,"Engineering"));
        inputList.parallelStream().map(Employee::getName).forEach(System.out::println);
    }





}
