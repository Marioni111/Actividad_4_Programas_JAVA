/*
 * Bibliografía
Aguilar, L. J. (2008). Estructura de datos java. Aravaca Madris: MCGRAW-HILL/INTERAMERICANA DE ESPAÑA, S. A. U.
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EntradaGrafo {
	public static void main(String args[])
    {
      BufferedReader entrada = new BufferedReader (
              new InputStreamReader (System.in));
      String v, w;
      try {
        int n;
        System.out.println("Número de nodos: ");
        n = Integer.parseInt(entrada.readLine());
        GrafoMatriz gra = new GrafoMatriz(n);
      
        System.out.println("Lista de " + n + " vertices");
        for (int i = 1; i <= n; i++)
        {
        System.out.println("Ingresa un valor para el grafo: ");
          v = entrada.readLine();
          gra.nuevoVertice(v);
        }
      
        System.out.println
         ("Arcos, pares de vertices separados por un espacio");
        boolean fin = false;
        do {
          StringTokenizer r;
          r = new StringTokenizer(entrada.readLine());
          v = r.nextToken();
          if (! v.equalsIgnoreCase("fin"))
          {
            w = r.nextToken();
            gra.nuevoArco(v, w);
            gra.nuevoArco(w, v);  // al ser grafo no dirigido
          }
          else fin = true;
        } while (!fin);
      
        System.out.println("Vertices del grafo");
        Vertice [] vs = new Vertice[n];
        vs = gra.vertices();
        for (int i = 0; i < n; i++)
          System.out.print(vs[i] + " ");
      
      }
      catch(Exception e)
      {
        System.out.println(" Error en la entrada del grafo ");
      }
    }
  }