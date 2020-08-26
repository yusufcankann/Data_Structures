public class Main {
    public static void main(String[] args) {

        System.out.println("Test 1:");
        Integer[][] arr = new Integer[6][5];
        int a=0;
        System.out.println("InputArray:");
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                arr[i][j]=a;
                a++;
                System.out.printf(" %3d ",arr[i][j]);
            }
            System.out.println("\n");
        }
        SpiralIterator sp = new SpiralIterator(arr);

        System.out.println("Output:");
        while(sp.hasNext()==true){
            System.out.printf("%d ",sp.next());
        }

        System.out.println("\n\nTest 2:");
        Integer[][] arr1 = new Integer[3][5];
        int b=0;
        System.out.println("InputArray:");
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                arr1[i][j]=b;
                b++;
                System.out.printf(" %3d ",arr1[i][j]);
            }
            System.out.println("\n");
        }
        SpiralIterator sp1 = new SpiralIterator(arr1);
        System.out.println("Output:");
        while(sp1.hasNext()==true){
            System.out.printf("%d ",sp1.next());
        }

        System.out.println("\n\nTest 3:");
        Integer[][] arr2 = new Integer[4][4];
        int c=0;
        System.out.println("InputArray:");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                arr2[i][j]=c;
                c++;
                System.out.printf(" %3d ",arr2[i][j]);
            }
            System.out.println("\n");
        }
        SpiralIterator sp2 = new SpiralIterator(arr2);
        System.out.println("Output:");
        while(sp2.hasNext()==true){
            System.out.printf("%d ",sp2.next());
        }







    }
}
