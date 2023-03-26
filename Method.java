import java.util.*;

/**
 * @author Wei_Zheng
 */
public class Method {
    public String addStrings(StringBuilder num1, StringBuilder num2) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || ca != 0) {
            int A = i >= 0 ? num1.charAt(i) - '0' : 0;
            int B = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = A + B + ca;
            ca = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            sb.append(sum);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public StringBuilder getReverseNumFromListNode(ListNode l1) {
        ListNode l2 = l1;
        StringBuilder num1 = new StringBuilder();
        while (l2 != null) {
            num1.append(l2.val);
            l2 = l2.next;
        }
        return num1.reverse();
    }

    public ListNode createReverseListNode(String num) {
        System.out.println(num);
        return new ListNode(num.charAt(num.length() - 1) - '0', num.length() >= 2 ? createReverseListNode(num.substring(0, num.length() - 1)) : null);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return createReverseListNode(addStrings(getReverseNumFromListNode(l1), getReverseNumFromListNode(l2)));
    }

    public int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < maxLocal.length; ++i) {
            for (int l = 0; l < maxLocal.length; ++l) {
                int maxnum = 0;
                for (int j = 0; j < 3; ++j) {
                    for (int k = 0; k < 3; ++k) {
                        maxnum = Math.max(maxnum, grid[j + i][k + l]);
                    }
                }
                maxLocal[i][l] = maxnum;
            }
        }
        return maxLocal;
    }

    public boolean checkIfPangram(String sentence) {
        return sentence.length() >= 26 && new HashSet<>(Arrays.asList(sentence.split(""))).size() == 26;
    }

    public int mostWordsFound(String[] sentences) {
        int result = 0;
        for (String str : sentences) {
            result = Math.max(new HashSet<>(Arrays.asList(str.split(" "))).size(), result);
        }
        return result;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        int len = allowed.length();
        Map<Character, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(allowed.charAt(i), i);
        }
        a:
        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                if (!map.containsKey(str.charAt(i))) {
                    continue a;
                }
            }
            ++result;
        }
        return result;
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int num : nums) {
            result = num == result ? result + 1 : result;
        }
        return result;
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        ListNode a = head.next;
        int b = 0;
        while (true) {
            System.out.println(result);
            if (a.val == 0) {
                result = new ListNode(b, result);
            } else {
                b += a.val;
            }
            if (a.next == null) break;
            a = a.next;
        }
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums3 = new int[length];
        int max = Math.max(nums1.length, nums2.length);
        int min = Math.min(nums1.length, nums2.length);
        int[] maxArray = nums1.length > nums2.length ? nums1 : nums2;
        for (int i = 0; i < max; ++i) {
            if (i < min) {
                nums3[2 * i] = nums1[i];
                nums3[2 * i + 1] = nums2[i];
            } else {
                nums3[i + min] = maxArray[i];
            }
        }
        Arrays.sort(nums3);
        System.out.println(Arrays.toString(nums3));
        if (length % 2 == 0) {
            return (nums3[length / 2] + nums3[length / 2 - 1]) / 2.0;
        }
        return nums3[(length + 1) / 2 - 1];
    }

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        return 0;
    }

    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] result = new int[length * 2];
        for (int i = 0; i < length; ++i) {
            result[i] = nums[i];
            result[i + length] = nums[i];
        }
        return result;
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int result = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < garbage.length; ++i) {
            int num1 = garbage[i].length() - garbage[i].replace("M", "").length();
            if (num1 != 0) a = i;
            int num2 = garbage[i].length() - garbage[i].replace("P", "").length();
            if (num2 != 0) b = i;
            int num3 = garbage[i].length() - garbage[i].replace("G", "").length();
            if (num3 != 0) c = i;
            result += num1 + num2 + num3;
        }
        int num = 0;
        for (int j = 0; j < travel.length; ++j) {
            num += travel[j];
            if (a - j == 1) result += num;
            if (b - j == 1) result += num;
            if (c - j == 1) result += num;
        }
        return result;
    }

    public int countAsterisks(String s) {

        //输入：s = "l|*e*et|c**o|*de|"
        //输出：2
        int result = 0;
        String[] strings = s.split("\\|");
        int length = strings.length;
        if (length == 1) return 0;
        System.out.println(Arrays.toString(strings));
        for (int i = 0; i < length; i += 2) {
            String string = strings[i];
            result += string.length() - string.replace("*", "").length();
        }
        return result;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        int length1 = groupSizes.length;
        for (int i = 0; i < length1; ++i) {
            //输入：groupSizes = [3,3,3,3,3,1,3]
            //输出：[[5],[0,1,2],[3,4,6]]
            boolean flag = true;
            System.out.println(result);
            for (int j = result.size() - 1; j >= 0; j--) {
                int num1 = groupSizes[result.get(j).get(0)];
                if (groupSizes[i] == num1 && result.get(j).size() < num1) {
//                    result.get(j).add(i);
                    List<Integer> list = result.get(j);
                    list.add(i);
                    result.set(j, list);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);
                result.add(list1);
            }
        }
        return result;
    }

    public void newQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int pivot = arr[i];
            while (i < j) {
                while (arr[j] >= pivot && i < j) {
                    ++j;
                }
                while (arr[i] <= pivot && i < j) {
                    --i;
                }
                if (i < j) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            arr[left] = arr[i];
            arr[i] = pivot;
            newQuickSort(arr, left, j - 1);
            newQuickSort(arr, j + 1, right);
        }
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public int myAtoi(String s) {
        char[] s1 = s.trim().toCharArray();
        if (s1.length == 0) {
            return 0;
        }
        StringBuilder result = new StringBuilder();
        int a = 0;
        if ("-".equals(String.valueOf(s1[0]))) {
            result.append("-");
            a = 1;
        } else if ("+".equals(String.valueOf(s1[0]))) {
            a = 1;
        }
        for (int i = a; i < s1.length; i++) {
            if (Character.isDigit(s1[i])) {
                result.append(s1[i]);
            } else {
                break;
            }
        }
        if ("".equals(result.toString()) || "-".equals(result.toString())) {
            return 0;
        }
        try {
            Long.parseLong(result.toString());
        } catch (Exception e) {
            if (result.toString().length() > 11) {
                if ("-".equals(String.valueOf(s1[0]))) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        long b = Long.parseLong(result.toString());

        if (b < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (b > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return Integer.parseInt(result.toString());
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 = 0; num1 < nums.length; ++num1) {
            if (map.containsKey(target - nums[num1])) {
                return new int[]{map.get(target - nums[num1]), num1};
            }
            map.put(nums[num1], num1);
        }
        return null;
    }

    public String maximumNumber(String num, int[] change) {
        boolean flag = false;
        char[] chArr = num.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            int tmp = chArr[i] - '0';
            if (flag && tmp > change[tmp]) {
                break;
            }
            if (tmp < change[tmp]) {
                chArr[i] = (char) ('0' + change[tmp]);
                flag = true;
            }
        }

        return new String(chArr);
    }

    public int minOperations(int[] nums, int x) {
        List<Integer> list2 = Arrays.stream(nums).boxed().toList();
        List<Integer> list = new ArrayList<>(list2);
        int a = 0;
        boolean flag1;
        // boolean flag2;
        if ((list.get(0) > x && list.get(list.size() - 1) > x)) {
            return -1;
        }
        while (list.size() != 0 && x > 0) {
            flag1 = false;
            System.out.println(list);
            // flag2 = false;
            if (list.get(0) <= x) {
                if (list.get(list.size() - 1) <= x && list.get(list.size() - 1) > list.get(0)) {
                    x -= list.get(list.size() - 1);
                    a++;
                    list.remove(list.get(list.size() - 1));
                } else {
                    x -= list.get(0);
                    a++;
                    list.remove(list.get(0));
                }
                flag1 = true;
            } else if (list.get(list.size() - 1) <= x) {
                x -= list.get(list.size() - 1);
                a++;
                list.remove(list.get(list.size() - 1));
                flag1 = true;
            }
            if (!flag1) {
                break;
            }
        }
        System.out.println(x);
        return a;
    }

    public int removeElement(int[] nums, int val) {
        int valNum;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                nums[i] = 0;
            }
        }
        return 0;
    }
}
