package Six_A;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        ArrayList<choice> review = new ArrayList<>();
        review.add(new choice("BYE BYE","deadpool&wolverine"));
        review.add(new choice("back in black","IRON MAN"));
        review.add(new choice("way down we go","LOGAN"));
        review.add(new choice("x gonna give to ya","deadpool 1"));
        //review.forEach(REVIEW->{System.out.println(" Song Name->"+REVIEW.getSong_name()+"Movie Name-> "+REVIEW.getMovie_name());});
        //review.sort(Comparator.naturalOrder());
        review.sort(Comparator.naturalOrder());
        for(choice REVIEW:review)
        {
            System.out.println(" Song Name->"+REVIEW.getSong_name()+"Movie Name-> "+REVIEW.getMovie_name());
        }
    }
}