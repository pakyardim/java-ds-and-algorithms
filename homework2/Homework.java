import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Homework {

    public String[] getData(String pathName){
        String content = null;
        try {
            File file = new File(pathName);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                content = sc.nextLine();
            }

            String[] nums = content.split(",");
            sc.close();
            return nums;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<String> getLinkedList() {
        LinkedList<String> list = new LinkedList<String>();
        String[] nums = getData("homework2/data.txt");
            for (int i = 0; i < nums.length; i++) {
                list.addToEnd(nums[i]);
            }
        return list;
    }

    public void search () {
        LinkedList<String> list = getLinkedList();
        String[] nums = getData("homework2/search.txt");
        int totalMemoryAccess = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if(list.search(nums[i])){
                totalMemoryAccess += i;
                counter++;
            }
        }
        int average = totalMemoryAccess / counter;
    }


    public void searchAndModify() {
        LinkedList<String> list = getLinkedList();
        String[] nums = getData("homework2/search.txt");
        int totalMemoryAccess = 0;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if(list.search(nums[i])){
                totalMemoryAccess += i;
                counter++;
                String temp = nums[i];
                list.delete(nums[i]);
                list.addFront(temp);
            }
        }
        int average = totalMemoryAccess / counter;
    }

}
