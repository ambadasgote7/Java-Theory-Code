package coding;

// this refers to current object variable
class Demo {
    int x = 10;
    String name = "Ambadas";
    int age = 20;
    Demo(String name, int age) {
        /* If i don't use this keyword, then it will refer to the local variable
        instead of the instance variable here name = Ambadas and age = 20
        if the local variables are not initialized, then it will null and 0
        */
        //name = name; 
        //age = age; 

        /* If i use this keyword, then it will refer to the instance variable
        here name = Babusha and age = 20 
         */
        this.name = name;
        this.age = age;    
    }
    void show() {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}


public class thisKeyword {
    public static void main(String[] args) {
        Demo d = new Demo("Babusha", 20);
        d.show();
    }
}
