public class BubbleTestClass {

        public static void main( String[] args )
    {
        Bubble b = new Bubble( 5 );
//        try {
//            int s = 5/0;
//            Bubble t = new Bubble(5, false);
//        }
//        catch(Error e){
//            System.out.println("Success?");
//        }
//        catch(Exception e){
//            System.out.println("Other success?");
//        }
//        catch(Throwable e){
//            System.out.println("Seriosly please");
//        }
        b.setSize( b.getSize() * 2 );
        b.setIsPopped( true );
        System.out.println(b);
    }


}
