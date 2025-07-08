class Solution {
    public String[] solution(String[] strArr) {
        boolean isEven = true;
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = isEven ? strArr[i].toLowerCase() : strArr[i].toUpperCase();
            isEven = !isEven;
        }
        return strArr;
    }
}