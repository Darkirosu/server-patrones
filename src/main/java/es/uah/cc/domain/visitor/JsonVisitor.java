package es.uah.cc.domain.visitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class JsonVisitor implements Visitor {

    private BufferedWriter bw;

    public void visitor(FileElement fileElement) {
        try{
            System.out.println("El csv crea un archivo "+  fileElement.getName());
            String url = "./"+fileElement.getName()+".json";
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

            bw.write("{");
            bw.newLine();
            for (int i = 0; i < objects.size() ; i++) {
                bw.write("{");
                bw.newLine();
                for (int j = 0; j < objects.get(i).getClass().getDeclaredFields().length; j++) {
                    classAttribute = objects.get(i).getClass().getDeclaredFields()[j].getName();
                     aux="\""+classAttribute+"\":";
                    System.out.println(objects.get(i).getClass().getFields()[1].getType().getName());
                     if(objects.get(i).getClass().getFields()[1].getType().getName().equals("java.lang.String")){
                         aux=aux+"\"";
                     }
                     aux= aux=objects.get(i).getClass().getDeclaredField(classAttribute).get(objects.get(i))+",";
                    if(objects.get(i).getClass().getFields()[1].getType().getName().equals("java.lang.String")){
                        aux=aux+"\"";
                    }
                    //System.out.println(aux);
                    bw.write(aux);
                    bw.newLine();
                    aux="";
                }
                bw.write("}");

                if(i+1<objects.size()){
                    bw.write(",");
                }
                bw.newLine();
            }
            bw.write("}");
            bw.newLine();

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
