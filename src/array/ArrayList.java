package array;

import java.util.Arrays;

/**
 * Created by chace on 6/4/14.
 */
public class ArrayList {

    private Object[] objects;
    private int actSize = 0;

    public ArrayList() {
        objects = new Object[10];
    }

    public Object get(int index) {
        if (index < actSize) {
            return objects[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object obj) {
        if (objects.length - actSize <= 5) {
            increaseListSize();
        }
        objects[actSize++] = obj;
    }

    public void increaseListSize() {
        objects = Arrays.copyOf(objects, objects.length * 2);
    }

    public Object remove(int index) {
        if (index < actSize) {
            Object obj = objects[index];
            int tmp = index;
            while (tmp < actSize) {
                objects[tmp] = objects[tmp+1];
                objects[tmp+1] = null;
                tmp++;
            }
            actSize--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return actSize;
    }
}
