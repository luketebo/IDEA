package the_4_5;

public class ParamTest {
    public static void main(String[] args) {
        System.out.println("Testing tripleValue");
        double percent = 10;
        System.out.println("Before: percent = " + percent);
        tripleValue(percent);
        System.out.println("After: percent = " + percent);
    }
    public static void tripleValue(double x){
        x = 3 * x;
        System.out.println("End of method: x = " + x);
    }
    public static void tripleValue(Employee x){
        x.raiseSalary(200);
        System.out.println("End of method: salary = " + x.getSalary());
    }
}
