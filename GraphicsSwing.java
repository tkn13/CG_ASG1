import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class GraphicsSwing extends JPanel {

    final int SCREEN_WIDTH = 600;
    final int SCREEN_HEIGHT = 600;

    final int PEN_SIZE_S = 1;
    final int PEN_SIZE_M = 2;
    final int PEN_SIZE_L = 4;

    final String COLOR_FILE_NAME = "dragonColor.csv";
    final String TITLE = "Happy New Year 2024";

    final Color DRAGON_BASE_SKIN_COLOR = new Color(200, 0, 0);
    final Color DETAIL_LINE_COLOR = new Color(0, 0, 0);
    final Color DRAGON_LINE_COLOR = new Color(0, 0, 0);

    GraphicTools gt = new GraphicTools();

    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();
        JFrame f = new JFrame(m.TITLE);
        f.add(m);
        f.setSize(m.SCREEN_WIDTH, m.SCREEN_HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        g2.setStroke(new BasicStroke(PEN_SIZE_M));
        g2.setColor(Color.pink);
        gt.plot(g2, 224, 426, 1);

        background(g);

        gt.line(g, -1, -1, SCREEN_WIDTH+1, -1, PEN_SIZE_S);
        gt.line(g, -1, -1, -1, SCREEN_HEIGHT+1, PEN_SIZE_S);
        gt.line(g,  SCREEN_WIDTH+1, SCREEN_HEIGHT+1, -1, SCREEN_HEIGHT+1, PEN_SIZE_S);
        gt.line(g, SCREEN_WIDTH+1, SCREEN_HEIGHT+1, SCREEN_WIDTH+1, -1, PEN_SIZE_S);

        dragonScales(g2);
        dragonHead(g2);
        dragonHorn(g2);
        dragonNeck(g2);
        dragonFrontLeg(g2);
        dragonFrontNailFrontLeg(g2);
        dragonBackNailFrontLeg(g2);
        dragonBody(g2);
        dragonBackLeg(g2);
        dragonThigh(g2);
        dragonNailBackLeg(g2);
        dragonTail(g2);

        g2.setColor(DETAIL_LINE_COLOR);
        dragonHeadLittleDetail(g2);
        dragonNeckLittleDetail(g2);
        dragonFrontLegLittleDetail(g2);
        dragonBodyLittleDetail(g2);
        dragonThighLittleDetail(g2);
        dragonTailLittleDetail(g2);
        dragonHornLittleDetail(g2);
        dragonBackLegLittleDetail(g2);

        dragonHeadDetail(g2);
        dragonFaceDetail(g2);
        dragonNeckDetail(g2);
        dragonFrontLegDetail(g2);
        dragonFrontNailFrontLegDetail(g2);
        dragonBackNailFrontLegDetail(g2);
        dragonBodyDetail(g2);
        dragonBackLegDetail(g2);
        dragonNailBackLegDetail(g2);
        dragonTailDetail(g2);

        gt.fillColor(buffer, COLOR_FILE_NAME);

        g.drawImage(buffer, 0, 0, null);

    }

    public void background(Graphics g) {

        gt.line(g, -1, -1, SCREEN_WIDTH+1, -1, PEN_SIZE_S);
        gt.line(g, -1, -1, -1, SCREEN_HEIGHT+1, PEN_SIZE_S);
        gt.line(g,  SCREEN_WIDTH+1, SCREEN_HEIGHT+1, -1, SCREEN_HEIGHT+1, PEN_SIZE_S);
        gt.line(g, SCREEN_WIDTH+1, SCREEN_HEIGHT+1, SCREEN_WIDTH+1, -1, PEN_SIZE_S);

        int red = 0;
        int green = 5;
        int blue = 5;
        int redShiftSpeedFast = 50;
        int redShiftSpeedSlow = 5;
        int blueShift = 50;
        int greenShift = 50;
        for (int i = 0; i <= SCREEN_WIDTH*2; i++) {
            if (i < SCREEN_WIDTH) {
                if (i % redShiftSpeedFast == 0) {
                    red++;
                }
                if (i % blueShift == 0) {
                    blue++;
                }
                if (i % greenShift == 0) {
                    green++;
                }
                g.setColor(new Color(red, green, blue));
                gt.line(g, 0, i, i, 0, PEN_SIZE_S);
            } else {
                if (i % redShiftSpeedSlow == 0) {
                    red++;
                }
                if (i % blueShift == 0) {
                    blue++;
                }
                if (i % greenShift == 0) {
                    green++;
                }
                g.setColor(new Color(red, green, blue));
                gt.line(g, i - SCREEN_WIDTH, SCREEN_HEIGHT, SCREEN_WIDTH, i - SCREEN_HEIGHT, PEN_SIZE_S);
            }

        }

        // int k = 5;
        // for (int i = 0; i <= 600; i++) {
        // if (i % k == 0) {
        // b++;
        // }

        // if (i % 20 == 0) {
        // r++;
        // }
        // g.setColor(new Color(r % 255, 0, b % 255));
        // gt.line(g, 0, i, i, 0, 1);
        // gt.line(g, 600, 600 - i, 600 - i, 600, 1);
        // }

        // // for(int i = 550; i <= 600; i++){
        // // g.setColor(new Color(100, 100, 100));
        // // gt.line(g, 0, i, i, 0, 1);
        // // gt.line(g, 600, 600 - i, 600 - i, 600, 1);
        // // }

        // g.setColor(Color.white);

        // for (int i = 0; i < 1000; i++) {
        // int x = (int) (Math.random() * 600);
        // int y = (int) (Math.random() * 600);

        // // Plot the point using your plotting function (replace with your actual
        // // function)
        // gt.plot(g, x, y, 1);
        // }

        dragonRadius(g, 300, 300, 280, PEN_SIZE_M);

    }

    public void earth(Graphics g) {

    }

    public void dragonHead(Graphics g) {
        int xPloy[] = { 280, 314, 278, 288, 274, 337, 348, 386, 450, 459, 465, 463, 432, 419, 417, 375, 356, 357, 324,
                350, 312, 314 };
        int yPoly[] = { 40, 84, 71, 82, 114, 160, 176, 180, 202, 198, 200, 178, 145, 140, 122, 94, 52, 77, 30, 90, 52,
                69 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonHeadDetail(Graphics g) {
        gt.line(g, 288, 82, 325, 98, PEN_SIZE_M);
        gt.line(g, 325, 98, 374, 113, PEN_SIZE_M);
        gt.line(g, 374, 113, 380, 107, PEN_SIZE_M);
        gt.line(g, 380, 107, 375, 94, PEN_SIZE_M);
    }

    public void dragonHeadLittleDetail(Graphics g) {
        gt.drawTriangle(g, 325, 98, 340, 125, 352, 105, PEN_SIZE_S);
        gt.drawTriangle(g, 340, 125, 332, 129, 374, 113, PEN_SIZE_S);
        gt.drawTriangle(g, 334, 139, 349, 144, 352, 120, PEN_SIZE_S);

        gt.drawTriangle(g, 351, 166, 365, 130, 380, 177, PEN_SIZE_S);
        gt.drawTriangle(g, 380, 177, 395, 166, 373, 154, PEN_SIZE_S);
        gt.drawTriangle(g, 373, 154, 395, 142, 365, 130, PEN_SIZE_S);
        gt.drawTriangle(g, 395, 142, 395, 182, 409, 175, PEN_SIZE_S);

        gt.line(g, 348, 174, 361, 169, PEN_SIZE_S);

        gt.drawTriangle(g, 384, 116, 397, 109, 409, 130, PEN_SIZE_S);
        gt.line(g, 384, 116, 409, 130, PEN_SIZE_S);

        gt.line(g, 431, 145, 465, 199, PEN_SIZE_S);
        gt.line(g, 432, 187, 458, 186, PEN_SIZE_S);

        gt.line(g, 411, 161, 434, 144, PEN_SIZE_S);
        gt.drawTriangle(g, 422, 155, 421, 169, 434, 169, PEN_SIZE_S);

        gt.drawTriangle(g, 282, 95, 303, 105, 287, 81, PEN_SIZE_S);

        gt.drawTriangle(g, 274, 114, 313, 125, 325, 98, PEN_SIZE_S);
        gt.drawTriangle(g, 291, 125, 313, 125, 336, 159, PEN_SIZE_S);
        gt.line(g, 313, 125, 330, 125, PEN_SIZE_S);

    }

    public void dragonHorn(Graphics g) {
        gt.line(g, 357, 77, 380, 107, PEN_SIZE_M);
        gt.line(g, 350, 90, 361, 109, PEN_SIZE_M);
        gt.line(g, 314, 69, 361, 109, PEN_SIZE_M);
        gt.line(g, 314, 84, 325, 98, PEN_SIZE_M);
    }

    public void dragonHornLittleDetail(Graphics g) {
        gt.drawTriangle(g, 344, 72, 358, 81, 361, 105, PEN_SIZE_S);
        gt.line(g, 323, 76, 347, 87, PEN_SIZE_S);

        gt.drawTriangle(g, 319, 74, 319, 87, 354, 104, PEN_SIZE_S);
        gt.line(g, 211, 82, 213, 76, PEN_SIZE_S);
        gt.line(g, 173, 88, 180, 94, PEN_SIZE_S);
        gt.line(g, 140, 117, 140, 125, PEN_SIZE_S);

        gt.drawTriangle(g, 122, 151, 97, 165, 113, 165, PEN_SIZE_S);
        gt.drawTriangle(g, 76, 243, 88, 212, 97, 227, PEN_SIZE_S);

        gt.drawTriangle(g, 107, 272, 98, 297, 104, 316, PEN_SIZE_S);
        gt.drawTriangle(g, 98, 260, 116, 287, 98, 297, PEN_SIZE_S);

        gt.drawTriangle(g, 171, 358, 157, 354, 172, 324, PEN_SIZE_S);
        gt.drawTriangle(g, 142, 304, 138, 317, 167, 337, PEN_SIZE_S);

        gt.drawTriangle(g, 187, 340, 208, 341, 204, 363, PEN_SIZE_S);
        gt.drawTriangle(g, 204, 363, 226, 361, 234, 406, PEN_SIZE_S);
        gt.line(g, 226, 361, 245, 360, PEN_SIZE_S);

        gt.drawTriangle(g, 310, 436, 286, 411, 319, 419, PEN_SIZE_S);
        gt.line(g, 294, 436, 310, 436, PEN_SIZE_S);

        gt.drawTriangle(g, 306, 456, 314, 481, 289, 482, PEN_SIZE_S);

        gt.drawTriangle(g, 259, 504, 269, 511, 278, 500, PEN_SIZE_S);

        gt.line(g, 201, 512, 218, 523, PEN_SIZE_S);

        gt.line(g, 320, 467, 339, 499, PEN_SIZE_S);

        gt.drawTriangle(g, 259, 517, 284, 527, 284, 509, PEN_SIZE_S);
    }

    public void dragonFaceDetail(Graphics g) {
        gt.line(g, 274, 114, 325, 98, PEN_SIZE_M);
        gt.line(g, 325, 98, 337, 160, PEN_SIZE_M);
        gt.line(g, 337, 160, 374, 113, PEN_SIZE_M);
        gt.line(g, 337, 160, 386, 180, PEN_SIZE_M);
        gt.line(g, 380, 107, 412, 189, PEN_SIZE_M);
        gt.line(g, 394, 143, 419, 140, PEN_SIZE_M);
        gt.line(g, 394, 145, 417, 122, PEN_SIZE_M);
        gt.line(g, 394, 145, 432, 145, PEN_SIZE_M);
        gt.line(g, 432, 145, 432, 187, PEN_SIZE_M);
        gt.line(g, 394, 145, 432, 187, PEN_SIZE_M);
        gt.line(g, 412, 189, 432, 187, PEN_SIZE_M);
        gt.line(g, 459, 198, 432, 187, PEN_SIZE_M);
    }

    public void dragonNeck(Graphics g) {
        int xPloy[] = { 288, 241, 209, 181, 143, 113, 157, 180, 189, 206, 213, 246, 297, 274, 288 };
        int yPoly[] = { 82, 77, 85, 95, 125, 168, 180, 202, 155, 171, 153, 140, 130, 114, 82 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonNeckDetail(Graphics g) {
        gt.line(g, 233, 113, 274, 114, PEN_SIZE_M);

        gt.drawTriangle(g, 241, 77, 233, 113, 246, 140, PEN_SIZE_M);
        gt.drawTriangle(g, 209, 85, 233, 113, 189, 155, PEN_SIZE_M);
        gt.drawTriangle(g, 181, 95, 180, 125, 212, 136, PEN_SIZE_M);
        gt.drawTriangle(g, 143, 125, 180, 125, 189, 155, PEN_SIZE_M);

    }

    public void dragonNeckLittleDetail(Graphics g) {
        gt.line(g, 294, 130, 233, 113, PEN_SIZE_S);

        gt.drawTriangle(g, 233, 113, 276, 105, 239, 93, PEN_SIZE_S);
        gt.drawTriangle(g, 265, 79, 251, 97, 241, 77, PEN_SIZE_S);

        gt.drawTriangle(g, 220, 100, 229, 78, 233, 113, PEN_SIZE_S);
        gt.drawTriangle(g, 213, 136, 230, 146, 233, 113, PEN_SIZE_S);
        gt.line(g, 213, 153, 213, 136, PEN_SIZE_S);

        gt.line(g, 180, 125, 157, 180, PEN_SIZE_M);
        gt.line(g, 189, 155, 213, 153, PEN_SIZE_M);

        gt.drawTriangle(g, 180, 97, 200, 107, 180, 123, PEN_SIZE_S);
        gt.drawTriangle(g, 206, 88, 197, 122, 180, 123, PEN_SIZE_S);
        gt.line(g, 197, 122, 233, 113, PEN_SIZE_S);

        gt.drawTriangle(g, 196, 149, 196, 131, 206, 140, PEN_SIZE_S);

        gt.drawTriangle(g, 181, 125, 163, 108, 169, 125, PEN_SIZE_S);
        gt.drawTriangle(g, 163, 108, 180, 107, 172, 116, PEN_SIZE_S);

        gt.drawTriangle(g, 113, 168, 147, 147, 140, 127, PEN_SIZE_S);
        gt.drawTriangle(g, 130, 142, 147, 147, 181, 125, PEN_SIZE_S);
        gt.drawTriangle(g, 143, 176, 157, 141, 157, 180, PEN_SIZE_S);

        gt.drawTriangle(g, 179, 127, 185, 177, 157, 180, PEN_SIZE_S);
        gt.drawTriangle(g, 169, 154, 178, 166, 157, 180, PEN_SIZE_S);
        gt.drawTriangle(g, 162, 168, 178, 166, 186, 177, PEN_SIZE_S);

    }

    public void dragonFrontLeg(Graphics g) {
        int xPloy[] = { 189, 222, 254, 290, 260, 249, 187, 180 };
        int yPoly[] = { 155, 185, 171, 235, 224, 203, 251, 202 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonFrontLegDetail(Graphics g) {

        gt.line(g, 180, 202, 222, 185, PEN_SIZE_M);
        gt.line(g, 254, 171, 249, 203, PEN_SIZE_M);

    }

    public void dragonFrontLegLittleDetail(Graphics g) {
        gt.drawTriangle(g, 180, 202, 206, 171, 206, 191, PEN_SIZE_S);
        gt.drawTriangle(g, 181, 202, 226, 221, 235, 179, PEN_SIZE_S);

        gt.drawTriangle(g, 187, 251, 200, 210, 200, 240, PEN_SIZE_S);
        gt.drawTriangle(g, 231, 197, 248, 203, 235, 179, PEN_SIZE_S);

        gt.drawTriangle(g, 267, 194, 248, 203, 275, 210, PEN_SIZE_S);
        gt.line(g, 251, 189, 267, 194, PEN_SIZE_S);

    }

    public void dragonFrontNailFrontLeg(Graphics g) {
        int xPloy[] = { 282, 293, 302, 310, 316, 305, 305, 290 };
        int yPoly[] = { 222, 212, 223, 223, 253, 240, 249, 235 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonFrontNailFrontLegDetail(Graphics g) {
        gt.line(g, 285, 227, 293, 212, PEN_SIZE_M);
        gt.line(g, 285, 227, 302, 223, PEN_SIZE_M);
        gt.line(g, 289, 234, 302, 223, PEN_SIZE_M);
        gt.line(g, 289, 234, 312, 234, PEN_SIZE_M);
        gt.line(g, 305, 240, 298, 234, PEN_SIZE_M);
    }

    public void dragonBackNailFrontLeg(Graphics g) {
        int xPloy[] = { 260, 253, 230, 246, 238, 290 };
        int yPoly[] = { 224, 235, 242, 245, 256, 235 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonBackNailFrontLegDetail(Graphics g) {
        gt.line(g, 246, 245, 253, 235, PEN_SIZE_M);
        gt.line(g, 257, 248, 260, 222, PEN_SIZE_S);
        gt.drawTriangle(g, 267, 243, 258, 236, 289, 234, PEN_SIZE_S);
    }

    public void dragonBody(Graphics g) {
        int xPloy[] = { 97, 119, 173, 193, 250, 187, 180, 157, 113 };
        int yPoly[] = { 229, 285, 323, 299, 295, 251, 202, 180, 168 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonBodyDetail(Graphics g) {
        gt.drawTriangle(g, 97, 229, 157, 180, 145, 235, PEN_SIZE_M);
        gt.drawTriangle(g, 119, 285, 145, 235, 193, 299, PEN_SIZE_M);
        gt.line(g, 164, 260, 187, 251, PEN_SIZE_M);
    }

    public void dragonBodyLittleDetail(Graphics g) {
        gt.drawTriangle(g, 102, 210, 114, 214, 114, 169, PEN_SIZE_S);
        gt.drawTriangle(g, 115, 169, 138, 194, 138, 175, PEN_SIZE_S);

        gt.drawTriangle(g, 97, 230, 145, 235, 131, 201, PEN_SIZE_S);

        gt.line(g, 97, 230, 142, 243, PEN_SIZE_S);
        gt.drawTriangle(g, 108, 259, 125, 238, 118, 285, PEN_SIZE_S);

        gt.drawTriangle(g, 145, 235, 151, 282, 121, 286, PEN_SIZE_S);
        gt.drawTriangle(g, 131, 262, 151, 282, 129, 293, PEN_SIZE_S);
        gt.drawTriangle(g, 144, 300, 151, 282, 173, 272, PEN_SIZE_S);

        gt.line(g, 144, 298, 192, 298, PEN_SIZE_S);
        gt.line(g, 172, 298, 172, 323, PEN_SIZE_S);

        gt.line(g, 157, 180, 187, 251, PEN_SIZE_S);
        gt.drawTriangle(g, 167, 208, 145, 235, 187, 251, PEN_SIZE_S);

        gt.line(g, 163, 260, 249, 294, PEN_SIZE_S);
        gt.drawTriangle(g, 192, 299, 203, 276, 225, 296, PEN_SIZE_S);
    }

    public void dragonBackLeg(Graphics g) {
        int xPloy[] = { 173, 193, 250, 280, 340, 274, 284, 246, 195, 246, 246 };
        int yPoly[] = { 323, 299, 295, 290, 333, 372, 410, 461, 432, 432, 360 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonThigh(Graphics g) {
        gt.line(g, 173, 323, 340, 333, PEN_SIZE_M);
        gt.line(g, 193, 299, 340, 333, PEN_SIZE_M);
        gt.line(g, 247, 360, 340, 333, PEN_SIZE_M);
    }

    public void dragonThighLittleDetail(Graphics g) {
        gt.drawTriangle(g, 231, 308, 247, 294, 295, 322, PEN_SIZE_S);
        gt.line(g, 280, 290, 295, 322, PEN_SIZE_S);

        gt.drawTriangle(g, 214, 304, 221, 317, 264, 314, PEN_SIZE_S);
        gt.drawTriangle(g, 225, 325, 221, 317, 262, 327, PEN_SIZE_S);
        gt.line(g, 192, 323, 214, 304, PEN_SIZE_S);
        gt.line(g, 264, 314, 262, 327, PEN_SIZE_S);
        gt.line(g, 284, 321, 296, 330, PEN_SIZE_S);

        gt.drawTriangle(g, 233, 327, 243, 341, 267, 353, PEN_SIZE_S);
        gt.drawTriangle(g, 267, 353, 278, 330, 304, 342, PEN_SIZE_S);
        gt.line(g, 218, 326, 218, 345, PEN_SIZE_S);
        gt.line(g, 243, 341, 249, 360, PEN_SIZE_S);

        gt.line(g, 274, 372, 294, 345, PEN_SIZE_S);
    }

    public void dragonBackLegDetail(Graphics g) {
        gt.line(g, 247, 360, 274, 372, PEN_SIZE_M);
        gt.line(g, 246, 460, 246, 431, PEN_SIZE_M);
        gt.drawTriangle(g, 246, 405, 274, 422, 274, 372, PEN_SIZE_M);
    }

    public void dragonBackLegLittleDetail(Graphics g) {
        gt.drawTriangle(g, 273, 381, 247, 381, 263, 413, PEN_SIZE_S);
        gt.drawTriangle(g, 247, 381, 274, 402, 263, 413, PEN_SIZE_S);

        gt.drawTriangle(g, 248, 432, 267, 432, 247, 405, PEN_SIZE_S);

        gt.drawTriangle(g, 219, 432, 225, 448, 247, 432, PEN_SIZE_S);
        gt.line(g, 236, 439, 247, 461, PEN_SIZE_S);
    }

    public void dragonNailBackLeg(Graphics g) {
        int xPloy[] = { 195, 205, 205, 216, 233, 216, 216 };
        int yPoly[] = { 432, 410, 432, 402, 424, 416, 432 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonNailBackLegDetail(Graphics g) {
        gt.line(g, 216, 402, 216, 416, PEN_SIZE_M);
        gt.line(g, 217, 431, 224, 419, PEN_SIZE_M);
        gt.line(g, 230, 431, 224, 419, PEN_SIZE_M);
        gt.line(g, 205, 410, 213, 414, PEN_SIZE_M);
    }

    public void dragonTail(Graphics g) {
        int xPloy[] = { 322, 362, 373, 373, 358, 314, 263, 215, 178, 150, 144, 130, 76, 72, 45, 35, 63, 123, 145, 198,
                199, 256, 237, 294, 281, 324, 298, 284, 274 };
        int yPoly[] = { 343, 388, 435, 466, 517, 557, 570, 566, 552, 532, 534, 518, 487, 478, 448, 396, 444, 485, 490,
                521, 511, 517, 507, 496, 494, 424, 453, 410, 372 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);
    }

    public void dragonTailDetail(Graphics g) {
        gt.drawTriangle(g, 274, 372, 324, 423, 314, 498, PEN_SIZE_M);
        gt.drawTriangle(g, 294, 496, 314, 498, 256, 517, PEN_SIZE_M);
        gt.drawTriangle(g, 178, 552, 197, 527, 256, 517, PEN_SIZE_M);
        gt.line(g, 198, 521, 197, 527, PEN_SIZE_M);

        gt.drawTriangle(g, 324, 424, 335, 390, 362, 388, PEN_SIZE_M);
        gt.drawTriangle(g, 295, 359, 335, 390, 373, 466, PEN_SIZE_M);
        gt.drawTriangle(g, 373, 466, 324, 424, 358, 517, PEN_SIZE_M);

        gt.drawTriangle(g, 324, 424, 339, 502, 314, 557, PEN_SIZE_M);
        gt.drawTriangle(g, 314, 498, 339, 502, 358, 517, PEN_SIZE_M);
        gt.drawTriangle(g, 263, 570, 314, 498, 314, 557, PEN_SIZE_M);

        gt.drawTriangle(g, 314, 498, 268, 543, 215, 566, PEN_SIZE_M);
        gt.drawTriangle(g, 256, 517, 268, 543, 263, 570, PEN_SIZE_M);

        gt.drawTriangle(g, 178, 552, 256, 517, 215, 566, PEN_SIZE_M);

        gt.drawTriangle(g, 130, 518, 198, 521, 150, 532, PEN_SIZE_M);
        gt.drawTriangle(g, 123, 485, 146, 506, 198, 521, PEN_SIZE_M);
        gt.drawTriangle(g, 123, 485, 130, 518, 146, 506, PEN_SIZE_M);
        gt.drawTriangle(g, 45, 448, 63, 444, 76, 487, PEN_SIZE_M);
        gt.drawTriangle(g, 99, 467, 124, 501, 76, 487, PEN_SIZE_M);

    }

    public void dragonTailLittleDetail(Graphics g) {
        gt.drawTriangle(g, 348, 372, 274, 372, 335, 390, PEN_SIZE_S);
        gt.line(g, 305, 402, 313, 384, PEN_SIZE_S);
        gt.line(g, 313, 372, 334, 354, PEN_SIZE_S);

        gt.drawTriangle(g, 362, 388, 351, 425, 373, 435, PEN_SIZE_S);
        gt.line(g, 336, 433, 351, 425, PEN_SIZE_S);

        gt.drawTriangle(g, 335, 447, 373, 466, 345, 479, PEN_SIZE_S);
        gt.line(g, 356, 474, 365, 494, PEN_SIZE_S);
        gt.line(g, 339, 489, 350, 494, PEN_SIZE_S);

        gt.drawTriangle(g, 335, 538, 330, 520, 358, 517, PEN_SIZE_S);
        gt.line(g, 314, 498, 330, 520, PEN_SIZE_S);

        gt.line(g, 282, 543, 291, 562, PEN_SIZE_S);
        gt.drawTriangle(g, 314, 527, 298, 541, 314, 557, PEN_SIZE_S);
        gt.line(g, 291, 534, 298, 541, PEN_SIZE_S);
        gt.drawTriangle(g, 242, 567, 251, 551, 263, 569, PEN_SIZE_S);

        gt.drawTriangle(g, 233, 543, 251, 549, 255, 516, PEN_SIZE_S);
        gt.drawTriangle(g, 197, 543, 215, 565, 222, 534, PEN_SIZE_S);
        gt.line(g, 174, 528, 178, 551, PEN_SIZE_S);

        gt.line(g, 76, 487, 99, 467, PEN_SIZE_S);
        gt.line(g, 45, 447, 52, 429, PEN_SIZE_S);
    }

    public void dragonScales(Graphics g) {
        int[] xPloy = { 288, 225, 241, 197, 209, 159, 181, 112, 143, 75, 113, 59, 97, 96, 119, 173, 173, 235, 246, 251,
                116 };
        int[] yPoly = { 82, 68, 77, 77, 85, 87, 95, 130, 125, 185, 168, 260, 229, 340, 285, 388, 323, 408, 360, 323,
                197 };
        gt.drawPolygon(g, xPloy, yPoly, DRAGON_LINE_COLOR, DRAGON_BASE_SKIN_COLOR);

    }

    public void dragonRadius(Graphics g, int kx, int ky, int r, int size) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y) {

            g.setColor(MyColor.c28);
            gt.plotIfOutsideRange(g, x + kx, 414, 518, x + kx, y + ky, size);
            gt.plotIfOutsideRange(g, y + kx, 414, 518, y + kx, x + ky, size);
            gt.plotIfOutsideRange(g, y + kx, 437, 521, y + kx, -x + ky, size);

            g.setColor(MyColor.c29);
            gt.plotIfOutsideRange(g, x + kx, 437, 521, x + kx, -y + ky, size);
            gt.plotIfOutsideRange(g, x + ky, 361, Integer.MAX_VALUE, -y + kx, x + ky, size);
            gt.plot(g, -y + kx, -x + ky, size);
            gt.plot(g, -x + kx, -y + ky, size);


            x++;
            Dx += 2;
            D += Dx + 1;
            if (D >= 0) {
                y--;
                Dy -= 2;
                D -= Dy;
            }
        }
    }
}