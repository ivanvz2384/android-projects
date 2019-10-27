package mx.com.iavazquezs.numershapes.mx.com.iavazquezs.numershapes.util;

public class Util {

        private Integer myNumber;

        public Integer getMyNumber() {
            return myNumber;
        }

        public void setMyNumber(Integer myNumber) {
            this.myNumber = myNumber;
        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < myNumber) {
                x++;
                triangularNumber += x;
            }

            return triangularNumber == myNumber;
        }

        public boolean isSquare() {
            double squareRoot = Math.sqrt(myNumber);
            return squareRoot == Math.floor(squareRoot);
        }

}
