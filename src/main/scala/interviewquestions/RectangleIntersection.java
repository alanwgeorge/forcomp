package interviewquestions;

public class RectangleIntersection {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2, 7, 4, 5);
        Rectangle r2 = new Rectangle(3, 8, 5, 6);

        System.out.println(r2.intersection(r1));

        Rectangle r3 = new Rectangle(2, 3, 1, 1);
        Rectangle r4 = new Rectangle(4, 5, 1, 1);

        System.out.println(r4.intersection(r3));

        Rectangle r5 = new Rectangle(2, 8, 5, 5);
        Rectangle r6 = new Rectangle(3, 7, 4, 4);

        System.out.println(r6.intersection(r5));
    }

    public static class Rectangle {
        // coordinates of bottom left corner
        Integer leftX;
        Integer bottomY;

        // dimensions
        Integer width;
        Integer height;

        public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public Rectangle() {}

        public Rectangle intersection(Rectangle other) {
            if (other.leftX + other.height < leftX ||
                    other.bottomY - other.width > bottomY) {
                return new Rectangle(0, 0, 0, 0);
            }

            Integer iLeftX;
            Integer iBottemY;
            Integer iWidth;
            Integer iHeight;

            iLeftX = Math.max(other.leftX, leftX);
            iBottemY = Math.min(other.bottomY, bottomY);

            iWidth = Math.abs(other.leftX - leftX) + Math.abs((other.leftX + other.width) - (leftX + width));
            iHeight = Math.min(other.bottomY, bottomY) - Math.max(other.bottomY - other.height, bottomY - height);

            return new Rectangle(iLeftX, iBottemY, iWidth, iHeight);
        }

        public String toString() {
            return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
        }
    }
}
