package tutorial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Equipo 1
 */
public class ManipulaArchivos
{

    public static void guarda(String s, Object o)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(s); //Informacion fisica
            ObjectOutputStream arch = new ObjectOutputStream(fos);//Variable lodica

            arch.writeObject(o);
            arch.close();
        } catch (Exception ex) //Por si la trayectoria no existe
        {
            System.out.println("Hubo un error " + ex.getMessage()); // Puede ser ex.toString
        }
    }

    public static void guarda(String s, int[] o)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(s); //Informacion fisica
            ObjectOutputStream arch = new ObjectOutputStream(fos);//Variable lodica

            arch.writeObject(o);
            arch.close();
        } catch (Exception ex) //Por si la trayectoria no existe
        {
            System.out.println("Hubo un error " + ex.getMessage()); // Puede ser ex.toString
        }
    }
    public static void guarda(String s, int o)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(s); //Informacion fisica
            ObjectOutputStream arch = new ObjectOutputStream(fos);//Variable lodica

            arch.writeObject(o);
            arch.close();
        } catch (Exception ex) //Por si la trayectoria no existe
        {
            System.out.println("Hubo un error " + ex.getMessage()); // Puede ser ex.toString
        }
    }

    public static void guarda(String s, Object[] o) //Va a guardar todas las posiciones del arreglo
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(s); //Informacion fisica
            ObjectOutputStream arch = new ObjectOutputStream(fos);//Variable lodica

            arch.writeObject(o);
            arch.close();
        } catch (Exception ex) //Por si la trayectoria no existe
        {
            System.out.println("Hubo un error " + ex.getMessage()); // Puede ser ex.toString
        }
    }

    public static void guarda(String s, Object[][] o) //Va a guardar todas las posiciones del arreglo
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(s); //Informacion fisica
            ObjectOutputStream arch = new ObjectOutputStream(fos);//Variable lodica

            arch.writeObject(o);
            arch.close();
        } catch (Exception ex) //Por si la trayectoria no existe
        {
            System.out.println("Hubo un error " + ex.getMessage()); // Puede ser ex.toString
        }
    }

    public static Object carga(String s)
    {
        Object o = new Object();
        try
        {
            FileInputStream fis = new FileInputStream(s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            o = arch.readObject();
            arch.close();

        } catch (Exception ex)
        {
            System.out.println("Error... " + ex.toString());
        }
        return o;
    }

    public static int[] carga3(String s)
    {
        int o[] = new int[9];
        try
        {
            FileInputStream fis = new FileInputStream(s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            o = (int[]) arch.readObject();
            arch.close();

        } catch (Exception ex)
        {
            o[0]=0;
            o[1]=0;
            o[2]=0;
            o[3]=0;
            o[4]=0;
            o[5]=0;
            o[6]=0;
            o[7]=0;
            o[8]=0;
            System.out.println("Error... " + ex.toString());
        }
        return o;
    }
    public static int carga4(String s)
    {
        int o = 1;
        try
        {
            FileInputStream fis = new FileInputStream(s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            o = (int) arch.readObject();
            arch.close();

        } catch (Exception ex)
        {           
            System.out.println("Error... " + ex.toString());
        }
        return o;
    }

    public static Object[] carga1(String s)
    {
        Object o[] = null;
        try
        {
            FileInputStream fis = new FileInputStream(s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            o = (Object[]) arch.readObject();
            arch.close();

        } catch (Exception ex)
        {
            System.out.println("Error... " + ex.toString());
        }
        return o;
    }

    public static Object[][] carga2(String s)
    {
        Object o[][] = null;
        try
        {
            FileInputStream fis = new FileInputStream(s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            o = (Object[][]) arch.readObject();
            arch.close();

        } catch (Exception ex)
        {
            System.out.println("Error... " + ex.toString());
        }
        return o;
    }
}
