public class Finder {

    public static Integer getMaxInt(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0){
            return null;
        }
        int maxInt = array[0];
        for (int i=1; i < array.length; i++) {
            if (array[i] > maxInt) {
                maxInt = array[i];
            }
        }
        return maxInt;
    }

    public static Integer getMinInt(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0){
            return null;
        }
        int minInt = array[0];
        for (int i=1; i < array.length; i++) {
            if (array[i] < minInt) {
                minInt = array[i];
            }
        }
        return minInt;

    }
}
