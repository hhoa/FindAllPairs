/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findallpairs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Hoa
 */
public class FindAllPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String fileName = "question.txt";
        int[] number = null;
        int x = 0;
        
        URL path = FindAllPairs.class.getResource(fileName);
        BufferedReader br = new BufferedReader(new FileReader(new File(path.getFile())));
        try {
            String line = br.readLine();
            String[] temp;

            if (line != null) {
                temp = line.split(", ");
                number = new int[temp.length];
                for (int i = 0; i < temp.length; i++){
                    number[i] = Integer.parseInt(temp[i]); 
                }
                x = Integer.parseInt(br.readLine());
            }
        } finally {
            br.close();
        }
        
        List<Integer> ans = findAllPair(number, x);
        if (ans.isEmpty())
            System.out.println("None");
        else 
        {
            for (int i = 0; i < ans.size(); i += 2) {
                System.out.printf("(%d, %d)\n", ans.get(i), ans.get(i + 1));
            }
        }
    }

    private static List<Integer> findAllPair(int[] number, int x) {
        int tmp;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            if (x % number[i] == 0) 
            {
                tmp = x / number[i];
                if (map.containsKey(number[i]))
                {
                    ans.add(map.get(number[i]));
                    ans.add(i);
                }
                else
                {
                    map.put(tmp, i);
                }
            }
        }
        
        return ans;
    }
}
