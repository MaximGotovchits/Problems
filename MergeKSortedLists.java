/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) {
            return null;
        }


        int indToRemove = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                indToRemove = i;
            }
        }
        if (indToRemove == -1) {
            return null;
        }
        ListNode result = new ListNode(lists[indToRemove].val);
        ListNode tempResult = result;

        lists[indToRemove] = lists[indToRemove].next;

        while (true) {
            min = Integer.MAX_VALUE;

            boolean hasElements = false;
            indToRemove = -1;

            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null && lists[i].val < min) {
                    hasElements = true;
                    min = lists[i].val;
                    indToRemove = i;
                }
            }
            if (!hasElements || indToRemove == -1) {
                tempResult = null;
                break;
            }
            tempResult.next = new ListNode();
            tempResult = tempResult.next;
            tempResult.val = lists[indToRemove].val;
            lists[indToRemove] = lists[indToRemove].next;
        }

        return result;
    }
}
