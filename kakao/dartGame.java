public class dartGame {
    public static int getPoint(String pointStr) {
        int[] arr = new int[3];
        int curIdx = 0;
        String tempNum = "";
        for (char c : pointStr.toCharArray()) {
            if (Character.isDigit(c)) {
                tempNum = tempNum + c;
            } else {
                if (!"".equals(tempNum)) {
                    arr[curIdx++] = Integer.parseInt(tempNum);
                    tempNum = "";
                }
                switch (c) {
                    case 'S':
                        arr[curIdx - 1] = (int) Math.pow(arr[curIdx - 1], 1);
                        break;
                    case 'D':
                        arr[curIdx - 1] = (int) Math.pow(arr[curIdx - 1], 2);
                        break;
                    case 'T':
                        arr[curIdx - 1] = (int) Math.pow(arr[curIdx - 1], 3);
                        break;
                    case '*':
                        arr[curIdx - 1] = arr[curIdx - 1] * 2;
                        if (curIdx - 2 >= 0) {
                            arr[curIdx - 2] = arr[curIdx - 2] * 2;
                        }
                        break;
                    case '#':
                        arr[curIdx - 1] = arr[curIdx - 1] * -1;
                        break;
                }
            }
        }
        return arr[0] + arr[1] + arr[2];
    }
}
