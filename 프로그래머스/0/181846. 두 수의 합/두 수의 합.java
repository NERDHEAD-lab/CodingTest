class Solution {
    public String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, aCursor = a.length() - 1, bCursor = b.length() - 1;

        while (aCursor >= 0 || bCursor >= 0 || carry > 0) {
            int aNum = (aCursor >= 0) ? a.charAt(aCursor--) - '0' : 0;
            int bNum = (bCursor >= 0) ? b.charAt(bCursor--) - '0' : 0;

            int sum = aNum + bNum + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
