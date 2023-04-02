package implementation;

public class ThisCote_4_1 {

    static int N, x, y;

    public static void main(String[] args) {
        N = 5;
        char[] roots = {'R', 'R', 'R', 'U', 'D', 'D'};
        x = 1; y = 1;

        for( char s : roots ) {
            move(s);
        }

        System.out.println( x + " " + y );
    }

    public static void move(char c) {
        int nx = 0;
        int ny = 0;

        switch(c) {
            case 'R': {
                ny = 1;
                if( checkMove(x+nx, y+ny) ) {
                    break;
                }
                y = y+ny;
                break;
            }
            case 'L': {
                ny = -1;
                if( checkMove(x+nx, y+ny)) {
                    break;
                }
                y = y+ny;
                break;
            }
            case 'U': {
                nx = -1;
                if( checkMove(x+nx, y+ny)) {
                    break;
                }
                x = x+nx;
                break;
            }
            case 'D': {
                nx = 1;
                if( checkMove(x+nx, y+ny)) {
                    break;
                }
                x = x+nx;
                break;
            }
        }
    }

    public static boolean checkMove(int xx, int yy) {
        if( xx < 1 || yy > N ) {
            return true;
        }
        return false;
    }

}