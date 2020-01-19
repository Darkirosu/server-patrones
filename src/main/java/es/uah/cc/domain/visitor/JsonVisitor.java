package es.uah.cc.domain.visitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class JsonVisitor implements Visitor {

    private BufferedWriter bw;

    public void visitor(FileElement fileElement) {
        try{
            String url = "./"+fileElement.getName()+".json";
            File file =new File(url);
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void visitor(BodyElement bodyElement) {
        try{
            System.out.println("generando el body csv");
            ArrayList<Object> objects = bodyElement.getObject();
            String aux="";
            String delimiter=";";
            String classAttribute;

            bw.write("[");
            bw.newLine();
            for (int i = 0; i < objects.size() ; i++) {
                bw.write("{");
                bw.newLine();
                for (int j = 0; j < objects.get(i).getClass().getDeclaredFields().length; j++) {
                    classAttribute = objects.get(i).getClass().getDeclaredFields()[j].getName();
                     aux="\""+classAttribute+"\":";
                     if(objects.get(i).getClass().getFields()[j].getType().getName().equals("java.lang.String")||objects.get(i).getClass().getFields()[j].getType().getName().equals("java.util.Date")){
                         aux=aux+"\"";
                     }
                     aux= aux+objects.get(i).getClass().getDeclaredField(classAttribute).get(objects.get(i));
                    if(objects.get(i).getClass().getFields()[j].getType().getName().equals("java.lang.String")||objects.get(i).getClass().getFields()[j].getType().getName().equals("java.util.Date")){
                        aux=aux+"\"";
                    }
                    if(j+1<objects.get(i).getClass().getDeclaredFields().length){
                        aux=aux+",";
                    }
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
            bw.write("]");
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
