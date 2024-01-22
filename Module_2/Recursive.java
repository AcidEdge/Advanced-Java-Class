public class Recursive {
    public static void main(String[] args){
        sayHi(100);
        
    }
    private static void sayHi(int calls) {
        System.out.println("Hi!");

        if (calls == 1){
            return;
        }
        sayHi(calls - 1);
    
}
}
