package Math;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.util.Arrays;


public class Vectors implements Serializable {

    private double[] components;

    public Vectors(double[] components) {
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vectors(int n) {
        this.components = new double[n];
    }

    public double getComponent(int i) {
        return components[i];
    }

    public void setComponent(int i, double value) {
        components[i] = value;
    }

    public int getSize() {
        return components.length;
    }

    public static Vectors add(Vectors v1, Vectors v2) {
        if (v1.getSize() != v2.getSize()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        Vectors result = new Vectors(v1.getSize());
        for (int i = 0; i < v1.getSize(); i++) {
            result.setComponent(i, v1.getComponent(i) + v2.getComponent(i));
        }
        return result;
    }

    public static double scalarProduct(Vectors v1, Vectors v2) {
        if (v1.getSize() != v2.getSize()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        double result = 0;
        for (int i = 0; i < v1.getSize(); i++) {
            result += v1.getComponent(i) * v2.getComponent(i);
        }
        return result;
    }

    public static Vectors multiplyByScalar(Vectors v, double scalar) {
        Vectors result = new Vectors(v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            result.setComponent(i, v.getComponent(i) * scalar);
        }
        return result;
    }

    public static void outputVector(Vectors v, OutputStream out) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(v);
    }

    public static Vectors inputVector(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(in);
        Vectors v = (Vectors) ois.readObject();
        return v;
    }

    public static void writeVector(Vectors v, Writer out) throws IOException {
        PrintWriter pw = new PrintWriter(out);
        pw.print(v.getSize() + " ");
        for (int i = 0; i < v.getSize(); i++) {
            pw.print(v.getComponent(i) + " ");
        }
        pw.println();
        pw.flush();
    }

    public static Vectors readVector(Reader in) throws IOException {
        StreamTokenizer st = new StreamTokenizer(in);
        st.nextToken();
        int n = (int) st.nval;
        double[] components = new double[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            components[i] = st.nval;
        }
        return new Vectors(components);
    }

    @Override
    public String toString() {
        return Arrays.toString(components);
    }

}

