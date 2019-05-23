package sample;

import java.io.FileWriter;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        FileWriter laba = new FileWriter("laba.html");
        String code = "package sample;\n" +
                "\n" +
                "\n" +
                "public class Main{\n" +
                "    public static void main(String[] args){\n" +
                "        PrinterInterface printer = new Decorator1(new Decorator(\"hi\"));\n" +
                "        printer.print();\n" +
                "\n" +
                "\n" +
                "    }\n" +
                "}\n" +
                "interface PrinterInterface{\n" +
                "    void print();\n" +
                "}\n" +
                "\n" +
                "class Decorator implements PrinterInterface{\n" +
                "    String value;\n" +
                "    public Decorator(String value) {this.value = value;}\n" +
                "    public void print(){\n" +
                "        System.out.print(value);\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "class Decorator1 implements PrinterInterface{\n" +
                "    PrinterInterface component;\n" +
                "    public Decorator1(PrinterInterface component) {this.component = component;}\n" +
                "    public void print(){\n" +
                "        System.out.print(\"<em>\");\n" +
                "        component.print();\n" +
                "        System.out.print(\"<\\\\html>\");\n" +
                "    }\n" +
                "}\n";

        PrinterInterface printer = new Printer(new Decorator(code));
        printer.print();
        laba.write(code);
        laba.close();

        /*Pattern pattern = Pattern.compile("void");
        Matcher matcher = pattern.matcher(code);
        while (matcher.find()) {
            System.out.println(code.substring(matcher.start(), matcher.end()));

        }*/

    }
}

interface PrinterInterface {
    void print();
}

class Decorator implements PrinterInterface {
    String value;

    public Decorator(String value) {
        this.value = value;
    }

    public void print() {
        value = value.replaceAll("main", "<font color = \"yellow\">void</font>")
                .replaceAll("\n", "</br>")
                .replaceAll("print", "<font color = \"yellow\">print</font>")
                .replaceAll("out", "<font color = \"purple\">out</font>")
                .replaceAll("component", "<font color = \"purple\">component</font>")
                .replaceAll("value", "<font color = \"purple\">value</font>")
                .replaceAll("public static", "<font color = \"orange\">public static</font>")
                .replaceAll("package", "<font color = \"orange\">package</font>")
                .replaceAll("class", "<font color = \"orange\">class</font>")
                .replaceAll("implements", "<font color = \"orange\">implements</font>")
                .replaceAll("public class", "<font color = \"orange\">public class</font>");
        System.out.print(value);

    }
}


class Printer implements PrinterInterface {
    PrinterInterface component;

    public Printer(PrinterInterface component) {
        this.component = component;
    }

    public void print() {
        System.out.print("");
        component.print();
        System.out.print("");
    }

}


