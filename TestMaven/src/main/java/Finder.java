public class Finder {

    public static Integer findMax(int[] intArray) {
        if (intArray == null) {
            return null;
        }
        if (intArray.length == 0){
            return null;
        }
        int maxInt = intArray[0];
        for (int i=1; i < intArray.length; i++) {
            if (intArray[i] > maxInt) {
                maxInt = intArray[i];
            }
        }
        return maxInt;
    }

    public static Integer findMin(int[] intArray) {
        if (intArray == null) {
            return null;
        }
        if (intArray.length == 0){
            return null;
        }
        int minInt = intArray[0];
        for (int i=1; i < intArray.length; i++) {
            if (intArray[i] < minInt) {
                minInt = intArray[i];
            }
        }
        return minInt;

    }
}
