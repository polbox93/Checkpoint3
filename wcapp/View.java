package wcapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class View {

    public void printString (String string) {
        System.out.println(string);
    }

    public void printStringInOneLine (char c, Float flo) {
        System.out.printf("[%c -> %.2f]", c, flo);
    }
}
