import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] sizes) {
        List<BusinessCard> businessCards = new ArrayList<>();
        for (int[] size : sizes) {
            businessCards.add(new BusinessCard(size[0], size[1]));
        }

        return minArea(businessCards);
    }

    //회전 포함 최소 넓이
    private int minArea(List<BusinessCard> businessCards) {
        int maxWidth = 0;
        int maxHeight = 0;
        for (BusinessCard businessCard : businessCards) {
            maxWidth = Math.max(maxWidth, Math.max(businessCard.getWidth(), businessCard.getHeight()));
            maxHeight = Math.max(maxHeight, Math.min(businessCard.getWidth(), businessCard.getHeight()));
        }
        return maxWidth * maxHeight;
    }


    static class BusinessCard {
        private final int width;
        private final int height;

        public BusinessCard(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}