package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humansRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humansRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              //expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           //expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        Set<Integer> set = new HashSet<>();
        if (index < humansRelationships.length && deep > 0) {

            for (int i = 0; i < Solution.generateRelationships()[index].length; i++) {
                if (humansRelationships[index][i] == true) {
                    set.add(i);
                    HashSet<Integer> tempSet = new HashSet<Integer>(getAllFriendsAndPotentialFriends(i, deep - 1));
                    Iterator<Integer> iterator = tempSet.iterator();
                    while (iterator.hasNext()) {
                        set.add(iterator.next());
                    }
                }
            }
            for (int j = index + 1; j < humansRelationships.length; j++) {
                if (humansRelationships[j][index] == true) {
                    set.add(j);
                    HashSet<Integer> tempSet2 = new HashSet<>(getAllFriendsAndPotentialFriends(j, deep - 1));
                    Iterator<Integer> iterator2 = tempSet2.iterator();
                    while (iterator2.hasNext()) {
                        set.add(iterator2.next());
                    }
                }
            }
        }
        Iterator<Integer> iteratorSet = set.iterator();
        while (iteratorSet.hasNext()) {
            if (iteratorSet.next() == index) {
                iteratorSet.remove();
            }
        }
        return set;

    }

    //remove people from set, with which you have already had relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humansRelationships.length; i++) {
            if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humansRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    //return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}