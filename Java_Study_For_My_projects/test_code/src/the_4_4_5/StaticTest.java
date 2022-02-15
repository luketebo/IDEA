package the_4_4_5;

public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Pick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee e : staff) {
            e.setId();
            System.out.println("name= " + e.getName() + ",Id= " + e.getId() + ",Salary= " +
                    e.getSalary());
        }

        int n = Employee.getNextId();
        System.out.println("NEXT available id= " + n);
    }
    static class Employee{
        private static int nextId = 1;

        private final String name;
        private final double salary;
        private int id;

        public Employee(String n,double s){
            name = n;
            salary = s;
            id = 0;
        }

        public String getName(){
            return name;
        }

        public double getSalary(){
            return salary;
        }

        public int getId(){
            return id;
        }

        public void setId(){
            id = nextId;
            nextId++;
        }

        public static int getNextId(){
            return nextId;
        }

        public  void main(String[] args) {
            Employee e = new Employee("Harry", 5000);
            System.out.println(e.getName() + " " + e.getSalary());
        }
    }
}
