import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class MyColor {
        static Color c1 = new Color(181, 36, 48);
        static Color c2 = new Color(237,90,43);
        static Color c3 = new Color(122,12,19);
        static Color c4 = new Color(193,72,14);
        static Color c5 = new Color(210,7,42);
        static Color c6 = new Color(171, 17, 4);
        static Color c7 = new Color(72, 7, 12);
        static Color c8 = new Color(250, 43, 3);
        static Color c9 = new Color(253, 43, 3);
        static Color c10 = new Color(224, 20, 94);
        static Color c11 = new Color(250, 78, 69);
        static Color c12 = new Color(138, 98, 34);
        static Color c13 = new Color(208, 119, 88);
        static Color c14 = new Color(253, 119, 88);
        static Color c15 = new Color(225, 85, 82);
        static Color c16 = new Color(251, 166, 104);
        static Color c17 = new Color(241, 149, 141);
        static Color c18 = new Color(222, 58, 38);
        static Color c19 = new Color(177, 47, 28);
        static Color c20 = new Color(235, 83, 100);
        static Color c21 = new Color(218, 124, 146);
        static Color c22 = new Color(119, 2, 4);
        static Color c23 = new Color(253, 68, 39);
        static Color c24 = new Color(245, 181, 48);
        static Color c25 = new Color(170, 108, 43);
        static Color c26 = new Color(125, 39, 28);
        static Color c27 = new Color(104, 73, 40);
        static Color c28 = new Color(249, 21, 0);
        static Color c29 = new Color(159, 46, 32);

        public static Color colorMapper(String c) {
        Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("c1", c1);
        colorMap.put("c2", c2);
        colorMap.put("c3", c3);
        colorMap.put("c4", c4);
        colorMap.put("c5", c5);
        colorMap.put("c6", c6);
        colorMap.put("c7", c7);
        colorMap.put("c8", c8);
        colorMap.put("c9", c9);
        colorMap.put("c10", c10);
        colorMap.put("c11", c11);
        colorMap.put("c12", c12);
        colorMap.put("c13", c13);
        colorMap.put("c14", c14);
        colorMap.put("c15", c15);
        colorMap.put("c16", c16);
        colorMap.put("c17", c17);
        colorMap.put("c18", c18);
        colorMap.put("c19", c19);
        colorMap.put("c20", c20);
        colorMap.put("c21", c21);
        colorMap.put("c22", c22);
        colorMap.put("c23", c23);
        colorMap.put("c24", c24);
        colorMap.put("c25", c25);
        colorMap.put("c26", c26);
        colorMap.put("c27", c27);

        return colorMap.getOrDefault(c, Color.BLACK);
    }
}