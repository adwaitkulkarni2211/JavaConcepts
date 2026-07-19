package solid;

public class OpenClosed {
    // Violation of the Open closed principle
    // Adding a new shape would require modifying this class
    // This approach tightly couples the BadShape class to the specific shapes it supports, reducing its extensibility.
    class BadShape {
        private String type;
        private int length;
        private int height;
        BadShape(String type, int length, int height) {
            this.type = type;
            this.length = length;
            this.height = height;
        }

        public double findArea() {
            if(type.equals("triangle")) {
                return 0.5 * height * length;
            } else if(type.equals("rectangle")) {
                return height * length;
            }
            return -1;
        }
    }

    // Open closed in action
    interface Shape {
        public double findArea();
    }

    class Triangle implements Shape {
        private int length;
        private int height;
        Triangle(int length, int breadth) {
            this.length = length;
            this.height = breadth;
        }

        @Override
        public double findArea() {
            return 0.5 * length * height;
        }
    }

    class Rectangle implements Shape {
        private int length;
        private int height;
        Rectangle(int length, int breadth) {
            this.length = length;
            this.height = breadth;
        }
        @Override
        public double findArea() {
            return length * height;
        }
    }

    class Circle implements Shape {
        private int radius;
        Circle(int radius) {
            this.radius = radius;
        }
        @Override
        public double findArea() {
            return 3.14 * Math.pow(radius, 2);
        }
    }
}
