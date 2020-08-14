import java.util.*;

public class myArrayAssignment{

    public static class myArray extends ArrayList<Integer> {

        private final ArrayList<Integer> originalData;

        public myArray(){
            originalData = new ArrayList<>();
        }

        public ArrayList<Integer> getData(){
            return originalData;
        }

        public void sort(){
            this.sort(Comparator.naturalOrder());
        }

        public Object[] findItem(int item){
            if(this.contains(item))
                return new Object[]{true, this.getData().indexOf(item)};
            else
                return new Object[]{false};
        }

        public Integer getMax() {
            this.sort();
            return this.get(this.size()-1);
        }

        public Integer getMin() {
            this.sort();
            return this.get(0);
        }
        public Double getAverage(){
            int sum = 0;
            for (Integer integer : this) {
                sum += integer;
            }
            return sum/ (double) this.size();
        }

        public void sortDescending() {
            this.sort(Comparator.reverseOrder());
        }

        @Override
        public boolean add(Integer integer) {
            super.add(integer);
            originalData.add(integer);
            return true;
        }
    }

    public static boolean INPUT_FLAG = true;

    public static void main(String[] args) {
        myArray myList = new myArray();
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("To exit input, type \"exit\"!");
        while (INPUT_FLAG){
            input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                INPUT_FLAG = false;
                break;
            }
            else {
                try {
                    myList.add(Integer.parseInt(input));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("Max value = "+ myList.getMax());
        System.out.println("Min value = "+ myList.getMin());
        System.out.println("Average value = "+ myList.getAverage());
        myList.sort();
        System.out.println("Sorted Array (Ascending order) = "+ myList);
        myList.sortDescending();
        System.out.println("Sorted Array (Descending order) = "+ myList);
        System.out.print("Enter the element to search for: ");
        int item = sc.nextInt();
        Object[] result = myList.findItem(item);
        if((boolean)result[0])
            System.out.println("Found "+ item + " at "+ result[1]);
        else
            System.out.println("Didn't find "+ item + " in the list");
    }
}
