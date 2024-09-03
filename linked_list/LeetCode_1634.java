package linked_list;

import java.util.*;

public class LeetCode_1634 {

    private static class PolyNode {

        private final int coefficient;
        private final int power;
        private PolyNode next = null;

        private PolyNode(int x, int y) {
            this.coefficient = x;
            this.power = y;
        }

        @Override
        public String toString() {
            StringBuilder polyNodeBuilder = new StringBuilder();

            PolyNode head = this;

            while (head != null) {
                polyNodeBuilder
                        .append("Coefficient: ")
                        .append(coefficient)
                        .append(", Power: ")
                        .append(power)
                        .append(", ");

                head = head.next;
            }

            polyNodeBuilder
                    .deleteCharAt(polyNodeBuilder.length() - 1)
                    .deleteCharAt(polyNodeBuilder.length() - 1);

            return polyNodeBuilder.toString();
        }
    }

    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        Map<Integer, Integer> polyMap = new HashMap<>();

        addPolyToMap(polyMap, poly1);
        addPolyToMap(polyMap, poly2);

        List<Integer> sortedKeyList = new ArrayList<>(polyMap.keySet());
        sortedKeyList.sort(Collections.reverseOrder());

        PolyNode polyNode = new PolyNode(0, 0);
        PolyNode pointerNode = polyNode;

        for (Integer power : sortedKeyList) {
            Integer coefficient = polyMap.get(power);

            if (coefficient != 0) {
                pointerNode.next = new PolyNode(coefficient, power);
                pointerNode = pointerNode.next;
            }
        }

        return polyNode.next;
    }

    private void addPolyToMap(Map<Integer, Integer> polyMap, PolyNode polyNode) {
        while (polyNode != null) {
            polyMap.merge(polyNode.power, polyNode.coefficient, Integer::sum);
            polyNode = polyNode.next;
        }
    }

    public static void main(String[] args) {
        // Input
        PolyNode poly1 = new PolyNode(1, 1);
        PolyNode poly2 = new PolyNode(1, 0);
        // Output
        PolyNode resultPolyNode = new LeetCode_1634().addPoly(poly1, poly2);
        System.out.println(resultPolyNode);

        PolyNode expectedPolyNode = new PolyNode(1, 1);
        expectedPolyNode.next = new PolyNode(1, 0);

        assert(expectedPolyNode == resultPolyNode);
    }
}


