public class WillThisRun {
    public static void main(String[] args) {
        Bubble b = new Bubble( 5 );
        b.setSize( b.getSize() * 2 );
        b.setIsPopped( true );
        boolean pop = b.getIsPopped();
        System.out.println(pop);
        System.out.println(b);
    }
}
