public class BubbleTestClass {

        public static void main( String[] args )
    {
        Bubble b = new Bubble( 5 );
        b.setSize( b.getSize() * 2 );
        b.setIsPopped( true );
        System.out.println(b);
    }


}
