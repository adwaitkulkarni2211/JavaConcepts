package solid;

public class InterfaceSeggregation {
    // Problematic approach that violates ISP
    interface BadMachine {
        void print();
        void scan();
        void fax();
    }

    class BadAllInOnePrinter implements BadMachine {
        @Override public void print() {
            // Printing functionality
        }
        @Override public void scan() {
            // Scanning functionality
        }
        @Override public void fax() {
            // Fax functionality
        }
    }

    class BadBasicPrinter implements BadMachine {
        @Override public void print() {
            // Printing functionality
        }
        @Override public void scan() {
            // Problem: Basic printer can't scan!
            throw new UnsupportedOperationException("Cannot scan");
        }
        @Override public void fax() {
            // Problem: Basic printer can't fax!
            throw new UnsupportedOperationException("Cannot fax");
        }
    }

    // Better approach following ISP
    interface Printer {
        void print();
    }

    interface Scanner {
        void scan();
    }

    interface FaxMachine {
        void fax();
    }

    class BasicPrinter implements Printer {
        @Override
        public void print() {
            // Printing functionality
        }
    }

    class AllInOnePrinter implements Printer, Scanner, FaxMachine {
        @Override
        public void print() {
            // Printing functionality
        }
        @Override
        public void scan() {
            // Scanning functionality
        }
        @Override
        public void fax() {
            // Fax functionality
        }
    }
}
