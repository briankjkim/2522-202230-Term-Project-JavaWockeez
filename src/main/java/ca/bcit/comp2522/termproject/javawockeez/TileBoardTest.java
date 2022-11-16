package ca.bcit.comp2522.termproject.javawockeez;

public enum TileBoardTest {
    // May need adjustments, start location with 3 tile blocks ex. (0, 0), (0, 1), (0, 2)
    // And a Goal/Next Location with 3 tile blocks ex. (0, 0), (0, 1), (0, 2)
    //    Below is a visualization:

    //    (0, 0)(0, 1)(0, 2)    START LOCATION
    //    (1, 0)(1, 1)(1, 2)    A1, A2, A3
    //    (2, 0)(2, 1)(2, 2)    B1, B2, B3
    //    (3, 0)(3, 1)(3, 2)    C1, C2, C3
    //    (4, 0)(4, 1)(4, 2)    GOAL/NEXT

    Start1(0, 0), Start2(0, 1), Start3(0, 2),
    A1(1, 0), A2(1, 1), A3(1, 2),
    B1(2, 0), B2(2, 1), B3(2, 2),
    C1(3, 0), C2(3, 1), C3(3, 2),
    Goal1(4, 0), Goal2(4, 1), Goal3(4, 2);

    private final int x;
    private final int y;

    TileBoardTest(int cx, int cy) {
        x = cx;
        y = cy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Currently moveBy doesn't exist
    public static TileBoardTest moveBy(int x, int y) {
        TileBoardTest rsl = null;
        for (TileBoardTest tileBoardTest : values()) {
            if (tileBoardTest.x == x && tileBoardTest.y == y) {
                rsl = tileBoardTest;
                break;
            }
        }
        return rsl;
    }
}
