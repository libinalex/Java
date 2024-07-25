class MyEmployee {
    private int id;
    private String name;

    public void setData(int i, String n) {
        id = i;
        name = n;
    }

    public void PrintData() {
        System.out.println("ID = " + id);
        System.out.println("Name = " + name);
    }

}

public class Access_Specifiers {
    public static void main(String[] args) {
        MyEmployee E1 = new MyEmployee();

        // E1.id = 101;             // This will give error as these are private attributes
        // E1.name = "Darryl";      // so we cannot access them directly.

        E1.setData(101, "Darryl");       // Thus we use member methods to set and get values of private attributes.
        E1.PrintData();               

    }
}
