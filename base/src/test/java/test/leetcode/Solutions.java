package test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solutions {

    @Test
    public void testTwoSum(){
        final int[] ints = Solution.twoSum(new int[]{3,2,3}, 6);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testLongestSubstring(){
        final int[] ints = {
                LongestSubString.lengthOfLongestSubstring("abc"),
                LongestSubString.lengthOfLongestSubstring("abcabcdd"),
                LongestSubString.lengthOfLongestSubstring("abcddese"),
                LongestSubString.lengthOfLongestSubstring("abbbbbbbbwww"),
                LongestSubString.lengthOfLongestSubstring("abcabcbb"),
                LongestSubString.lengthOfLongestSubstring("abcb"),
        };
        System.out.println(Arrays.toString(ints));
    }


    static class LongestSubString{
        public static int lengthOfLongestSubstring(String s) {
            if(s==null || s.length()==0){
                return 0;
            }
            int ret=-1;
            int lowestPos=0;
            final int length = s.length();
            Map<Character,Integer> map=new HashMap<>();
            for(int i=0;i<length;++i){
                char c=s.charAt(i);
                if(map.containsKey(c)){
                    final Integer pos = map.remove(c);
                    int dis=i-lowestPos;
                    if(dis>ret){
                        ret=dis;
                    }
                    for(int j=lowestPos;j<pos;++j){
                        map.remove(s.charAt(j));
                    }
                    lowestPos=pos+1;

                }
//                else {
                map.put(c,i);
//                }
            }
            if(ret<0){
                ret=s.length();
            }else if(ret<map.size()){
                ret=map.size();
            }
            return ret;
        }
    }

    static class SolutionAddTowNumbers {
        static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ret=null,node=null;
            int sumUpper=0,v1=0,v2=0;
            do{
                if(l1!=null){
                    v1=l1.val;
                    l1=l1.next;
                }else{
                    v1=0;
                }
                if(l2!=null){
                    v2=l2.val;
                    l2=l2.next;
                }else{
                    v2=0;
                }

                int val=v1+v2+sumUpper;
                int remain;
                if(val>=10){
                    remain=val-10;
                    sumUpper=1;
                }else{
                    remain=val;
                    sumUpper=0;
                }
                if(ret==null){
                    ret=new ListNode(remain);
                    node=ret;
                }else{
                    node.next=new ListNode(remain);
                    node=node.next;
                }
            }while(l1!=null || l2!=null || sumUpper!=0);
            //ret+=sumNode(l1);
            //ret+=sumNode(l2);
            return ret;
        }

    }

    public static class Solution {
        public static int[] twoSum(int[] nums, int target) {
            Arrays.sort(nums);
//            boolean find=false;
            int ti = Arrays.binarySearch(nums, target);
            if(ti<0){
                ti=-ti-1;
            }
            if(ti>=nums.length){
                ti=nums.length-1;
            }
            int ti2 = Arrays.binarySearch(nums, (int) Math.floor(target / 2));
            if(ti2<0){
//                return new int[]{-1};
                ti2=-ti2-1;

            }else{
//                find=true;
            }
            if(ti2<0){
                ti2=0;
            }
            int i=ti2,j=ti2;
            System.out.println("nearest index:"+ti2+"->"+nums[ti2]);
            int gap=0;

            int oldGap;

            while(i>=0 && j<=ti){
                oldGap = gap;
                gap = nums[i]+nums[j]-target;
                System.out.println("find:"+i+" "+j);
//                if(Math.abs(oldGap)<Math.abs(gap) && oldGap*gap>0){
//                    return new int[-2];
//                }
                if(gap==0){
                    if(i!=j) {
                        return new int[]{i, j};
                    }else{
                        if(i+1<nums.length && nums[i]==nums[i+1]){
                            return new int[]{i,i+1};
                        }
                        if(i-1>0 && nums[i-1]==nums[i]){
                            return new int[]{i-1,i};
                        }else{
                            i--;
                            j++;
                        }
                    }
                }else if(gap>0){
                    i--;
                }else if(gap<0){
                    j++;
                }

            }
            return new int[]{0};
        }
    }
}
