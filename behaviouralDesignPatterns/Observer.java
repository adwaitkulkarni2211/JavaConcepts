package behaviouralDesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class Observer {

    public interface Subscriber {
        void notify(String str);
    }

    static class User implements Subscriber {
        private int userId;
        public User(int userId) {
            this.userId = userId;
        }

        @Override
        public void notify(String str) {
            System.out.println("User " + this.userId + " has been notified");
        }
    }

    static class Group {
        private List<Subscriber> subscribers;
        public Group() {
            this.subscribers = new ArrayList<>();
        }
        public void subscribe(Subscriber user) {
            this.subscribers.add(user);
        }
        public void unsubscribe(Subscriber user) {
            this.subscribers.remove(user);
        }
        public void notify(String str) {
            for(Subscriber user: this.subscribers) {
                user.notify(str);
            }
        }
    }

    public static void main(String[] args) {
        Group group = new Group();

        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);

        group.subscribe(user1);
        group.subscribe(user2);
        group.subscribe(user3);

        group.notify("new msg");

        group.unsubscribe(user1);

        group.notify("new msg 2");
    }
}
