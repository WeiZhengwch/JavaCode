import java.util.Arrays;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

//    ListNode(int[] nums) {
//        for (int i = 0; i < nums.length; ++i) {
//            this.val = nums[i];
//            this.next = new ListNode(this.val, )
//        }
//    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        ListNode root = this;
        while(root != null){
            string.append(root.val);
            string.append(" ");
            root = root.next;
        }
        return string.toString();
    }
}
