package miscellaneous;

import java.util.Arrays;

/**
 * Created by chace on 6/8/14.
 */
public class CountOnlineUser {

    public static int countOnlineuser(User[] users, int timestamp) {
        if (users == null) {
            throw new NullPointerException();
        }
        Timestamp[] timestamps = new Timestamp[users.length * 2];
        for (int i = 0; i < users.length; i++) {
            Timestamp tsi = new Timestamp(users[i].login, Type.LOGIN);
            Timestamp tso = new Timestamp(users[i].logout, Type.LOGOUT);
            timestamps[i] = tsi;
            timestamps[i+1] = tso;
        }
        Arrays.sort(timestamps);
        int count = 0;
        for (int i = 0; i < timestamps.length; i++) {
            if (timestamps[i].time > timestamp) {
                break;
            }
            if (timestamps[i].type == Type.LOGIN) {
                count++;
            } else if (timestamps[i].type == Type.LOGOUT) {
                count--;
            }
        }
        return count;
    }
}

class User implements Comparable<User> {
    int login;
    int logout;

    public User(int li, int lo) {
        this.login = li;
        this.logout = lo;
    }

    @Override
    public int compareTo(User user) {
        if (this.login == user.login && this.logout == user.logout) {
            return 0;
        } if (this.login > user.logout) {
            return 1;
        } else if (this.logout < user.login) {
            return -1;
        }
        return 0;
    }
}

class Timestamp implements Comparable<Timestamp> {
    int time;
    Type type;

    public Timestamp(int t, Type type) {
        this.time = t;
        this.type = type;
    }


    @Override
    public int compareTo(Timestamp timestamp) {
        return this.time = timestamp.time;
    }
}

enum Type {
    LOGIN, LOGOUT
}