import library.Member;
import library.Library;
import library.Magazine;
import library.Book;

import sortingalgorithms.InsertionSortVariation;
import sortingalgorithms.InsertionSort;
import sortingalgorithms.SelectionSort;
import sortingalgorithms.BubbleSort;
import sortingalgorithms.SortingPerformance;
import sortingalgorithms.SortingAlgorithm;

import java.util.Collection;
import java.util.List;
import java.util.Random;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Magazine magazine1 = new Magazine("Magazine1", 2, true, 2, 43);
        Magazine magazine2 = new Magazine("Magazine2", 3, true, 5, 23);
        Magazine magazine3 = new Magazine("Magazine3", 4, false, 0, 4);

        Book book1 = new Book("Book1", 11, true,  "author1");
        Book book2 = new Book("Book2", 13, true,  "author2");
        Book book3 = new Book("Book3", 16, true,  "author3");

        Member member = new Member(1, "library.Member");

        System.out.println(magazine1);
        System.out.println(magazine2);
        System.out.println(magazine3);

        Library library = new Library();

        library.addItem(magazine1);
        library.addItem(magazine3);
        library.addItem(book1);
        library.addItem(book2);
        library.addMember(member);
        System.out.println(library.getItems());
        System.out.println(library.getMembers());
        library.lendItem(11, 1);

        System.out.println(library.getItems());
        System.out.println(library.getMembers());


//        sorting algorithms
        SortingPerformance analyzer = new SortingPerformance();

        Collection<SortingAlgorithm> algorithms = List.of(new InsertionSortVariation(), new InsertionSort(),
                new BubbleSort(), new SelectionSort());


        int[] arr1 = {3, 1, 4, 1, 5, 9, 2};
        int[] arr2 = {
                100, 3, 40, 25, 76, 21, 34, 9, 4,
                91, 53, 83, 44, 58, 65, 14, 11, 99, 69,
                51, 92, 43, 87, 91, 51, 32, 34, 27, 26
        };
        int[] randomArray = new int[10000];
        Random rand = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextInt(10000);
        }

        SortingAlgorithm fastestAlgorithm1 = analyzer.findFastestSortingAlgorithm(algorithms, arr1);
        SortingAlgorithm fastestAlgorithm2 = analyzer.findFastestSortingAlgorithm(algorithms, arr2);
        SortingAlgorithm fastestAlgorithm3 = analyzer.findFastestSortingAlgorithm(algorithms, randomArray);

        System.out.println("Fastest sorting algorithm: " + fastestAlgorithm1.getClass().getSimpleName());
        System.out.println("Fastest sorting algorithm: " + fastestAlgorithm2.getClass().getSimpleName());
        System.out.println("Fastest sorting algorithm: " + fastestAlgorithm3.getClass().getSimpleName());
    }
}