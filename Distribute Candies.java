/*
Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.

Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
The sister has two different kinds of candies, the brother has only one kind of candies. 
*/

Runtime: 108 ms
class Solution {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        List<Integer> sisList = new ArrayList<Integer>();
        sisList.add(candies[0]);
        for(int i =1; i<candies.length; i++){
            if(candies[i]!=candies[i-1]){
                sisList.add(candies[i]);
            }
        }
        if(sisList.size() > candies.length/2){
            return candies.length/2;
        }else{
            return sisList.size();
        }
    }
}

sample 74 ms submission
class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        
        for (int i : candies) {
            set.add(i);
            if (set.size() == candies.length / 2) {
                return candies.length / 2;
            }
        }
        
        return set.size();
    }
}