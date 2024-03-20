package Maxim;

public class App 
{
    public static void main( String[] args )
    {
        Container container = new Container();
        System.out.println(container);


        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
        container.add(6);

        System.out.println(container);

        container.remove(2);
        System.out.println(container);

        container.remove(3);
        System.out.println(container);

        container.add(1, 66);
        System.out.println(container);

        container.add(0, 8);
        System.out.println(container);

        container.add(4, 8);
        System.out.println(container);

        System.out.println(container.contains(8));

        Container new_container = container.clone();
        System.out.println(new_container);

        System.out.println(container.equals(new_container));

        System.out.println(container.indexOf(5));
        System.out.println(container.lastIndexOf(8));
       
        container.clear();
        new_container.clear();
    }
}
