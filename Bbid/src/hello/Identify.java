package hello;


import com.mascotcapsule.micro3d.v3.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

class Identify {
    void echo(String[] line) {
        for (int i = 0; i < line.length; i++) {
            System.out.print(line[i]);
            System.out.print(" ");
        }
    }

    void processCommand(String[] line) {
        echo(line);

        if ("Util3D.cos".equals(line[0])) {
            int arg = Integer.parseInt(line[1]);
            System.out.println(Util3D.cos(arg));
        }
        else if ("Util3D.sin".equals(line[0])) {
            int arg = Integer.parseInt(line[1]);
            System.out.println(Util3D.sin(arg));
        }
        else if ("Util3D.sqrt".equals(line[0])) {
            int arg = Integer.parseInt(line[1]);
            System.out.println(Util3D.sqrt(arg));
        }
        else if ("Vector3D.innerProduct".equals(line[0])) {
            Vector3D v1 = new Vector3D(Integer.parseInt(line[1]),
                                       Integer.parseInt(line[2]),
                                       Integer.parseInt(line[3]));
            Vector3D v2 = new Vector3D(Integer.parseInt(line[4]),
                                       Integer.parseInt(line[5]),
                                       Integer.parseInt(line[6]));
            System.out.println(Vector3D.innerProduct(v1, v2));
        }
        else if ("Vector3D.outerProduct".equals(line[0])) {
            Vector3D v1 = new Vector3D(Integer.parseInt(line[1]),
                                       Integer.parseInt(line[2]),
                                       Integer.parseInt(line[3]));
            Vector3D v2 = new Vector3D(Integer.parseInt(line[4]),
                                       Integer.parseInt(line[5]),
                                       Integer.parseInt(line[6]));
            println(Vector3D.outerProduct(v1, v2));
        }
        else if ("Vector3D.unit".equals(line[0])) {
            Vector3D vec = new Vector3D(Integer.parseInt(line[1]),
                                        Integer.parseInt(line[2]),
                                        Integer.parseInt(line[3]));
            vec.unit();
            println(vec);
        }
        else {
            throw new IllegalArgumentException("wtf dude " + line[0]);
        }
    }

    public void processFile(InputStream is) {
        try {
            LineReader lr = new LineReader(new InputStreamReader(is));
            String line;
            while ((line = lr.readLine()) != null) {
                Vector tokens = new Vector();

                for (;;) {
                    int delim = line.indexOf(' ');
                    if (delim < 0) {
                        tokens.addElement(line);
                        break;
                    }
                    tokens.addElement(line.substring(0, delim));
                    line = line.substring(delim + 1);
                }
                
                String[] tokensArray = new String [tokens.size()];
                tokens.copyInto(tokensArray);
                processCommand(tokensArray);
            }
        } catch (IOException ex) {
        }
    }

    private void println(Vector3D vec) {
        System.out.print(vec.x);
        System.out.print(" ");
        System.out.print(vec.y);
        System.out.print(" ");
        System.out.println(vec.z);
    }
}
