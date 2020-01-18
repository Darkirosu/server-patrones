package es.uah.cc.domain.visitor;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class CsvVisitor implements Visitor {

    private BufferedWriter bw;

    public void visitor(FileElement fileElement) {
        try{
            System.out.println("El csv crea un archivo "+  fileElement.getName());
            String url = "./"+fileElement.getName()+".csv";
            System.out.println(url);
            File file =new File(url);
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void visitor(BodyElement bodyElement) {
        try{
            ArrayList<Object> objects = bodyElement.getObject();
            String aux="";
            String delimiter=";";
            String classAttribute;
            for (int i = 0; i < objects.get(1).getClass().getDeclaredFields().length; i++) {
                aux = aux + objects.get(1).getClass().getDeclaredFields()[i].getName();
                if(i+1 < objects.get(i).getClass().getDeclaredFields().length){
                    aux=aux+delimiter;
                }
            }
            System.out.println(aux);
            bw.write(aux);
            bw.newLine();



            for (int i = 0; i < objects.size() ; i++) {
                aux="";
                for (int j = 0; j < objects.get(i).getClass().getDeclaredFields().length; j++) {
                    classAttribute = objects.get(i).getClass().getDeclaredFields()[j].getName();
                    aux=aux+ objects.get(i).getClass().getDeclaredField(classAttribute).get(objects.get(i));
                    if(j+1 < objects.get(i).getClass().getDeclaredFields().length){
                       aux=aux+delimiter;
                    }

                }
                System.out.println(aux);
                bw.write(aux);
                bw.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
    }


    public void visitor(CloseElement closeelement){
        try{
            bw.close();
        }catch (Exception e){
            e.printStackTrace();;
        }
    }


}
