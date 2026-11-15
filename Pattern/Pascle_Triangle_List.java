package Pattern;
import java.util.ArrayList;
import java.util.List;

public class Pascle_Triangle_List {
    
    public List<List<Integer>> generate (int numrow) {

        List<List<Integer>> triangle = new ArrayList<>();

        if(numrow >= 1) {
            triangle.add(new ArrayList<>());

            triangle.get(0).add(1);
        }

        for(int i=1; i<numrow; i++) {
            List<Integer> prevrow = triangle.get(i - 1);
            List<Integer>  newrow = new ArrayList<>();
            newrow.add(1);

            for (int j=1; j<i; j++) {
                int sum = prevrow.get(j-1) + prevrow.get(j);
                newrow.add(sum);
            }
            newrow.add(1);

            triangle.add(newrow);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int row = 6;

        Pascle_Triangle_List sol = new Pascle_Triangle_List();
        List<List<Integer>> result =sol.generate(6);

        for(List<Integer> res : result) {
            System.out.println(res);
        }
    }
}
