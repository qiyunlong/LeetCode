package addtwonum2;

/**
 * Created by q on 2018/4/4.
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int isNeedCarry = 0;
        return addValue(l1, l2, isNeedCarry);

    }

    private ListNode addValue(ListNode l1, ListNode l2, int isNeedCarry) {
        ListNode rtn = null;
        if (l1 == null && l2 != null) {
            return singleCarry(l2, isNeedCarry);
        }
        if (l2 == null && l1 != null) {
            return singleCarry(l1, isNeedCarry);
        }
        if (l1 == null && l2 == null) {
            if (isNeedCarry > 0) {
                return new ListNode(isNeedCarry);
            }
        }
        if (l1 != null && l2 != null) {
            int val;
            val = l1.val + l2.val + isNeedCarry;
            if (val > 9) {
                val = val % 10;
                isNeedCarry = 1;
            } else {
                isNeedCarry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            rtn = new ListNode(val);
            rtn.next = addValue(l1, l2, isNeedCarry);
        }
        return rtn;
    }

    private ListNode singleCarry(ListNode ln, int isNeedCarry) {
//        System.out.println("singleCarry.isNeedCarry:" + isNeedCarry);
        ListNode rtn;
        if (isNeedCarry > 0) {
            int val;
            if (ln == null) {
                val = isNeedCarry;
                rtn = new ListNode(val);
                isNeedCarry = 0;
            } else {
                val = ln.val + isNeedCarry;
                if (val > 9) {
                    val = val % 10;
                    isNeedCarry = 1;
                } else {
                    isNeedCarry = 0;
                }
                ln = ln.next;
                rtn = new ListNode(val);
                rtn.next = singleCarry(ln, isNeedCarry);
            }
        } else {
            isNeedCarry = 0;
            rtn = ln;
        }
        return rtn;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
