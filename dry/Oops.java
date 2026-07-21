package dry;

public class Oops {
    class BadCode {
        class SubmitButton {
            void onClick() { System.out.println("Form submitted."); }
        }

        // CancelButton class with its own onClick() implementation
        class CancelButton {
            void onClick() { System.out.println("Action canceled."); }
        }

        public class Main {
            public void usage(String[] args) {
                SubmitButton submit = new SubmitButton();
                submit.onClick();  // Output: Form submitted.
                CancelButton cancel = new CancelButton();
                cancel.onClick();  // Output: Action canceled.
            }
        }
    }

    class GoodCode {
        // Base class
        abstract class Button {
            abstract void onClick();
        }

        // Subclass implementing specific behavior
        class SubmitButton extends Button {
            @Override void onClick() {
                System.out.println("Form submitted.");
            }
        }

        // Subclass implementing different behavior
        class CancelButton extends Button {
            @Override void onClick() {
                System.out.println("Action canceled.");
            }
        }

        public class Main {
            public void usage(String[] args) {
                Button submit = new SubmitButton();
                submit.onClick();  // Output: Form submitted.
                Button cancel = new CancelButton();
                cancel.onClick();  // Output: Action canceled.
            }
        }
    }
}
