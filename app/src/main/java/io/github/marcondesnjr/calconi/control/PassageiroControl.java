package io.github.marcondesnjr.calconi.control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import io.github.marcondesnjr.calconi.entities.Passageiro;
import io.github.marcondesnjr.calconi.xml.PassageiroXML;

/**
 * Created by Junior on 23/03/2016.
 */
public class PassageiroControl {

    public void save(String name, int diasAndados,InputStream is, OutputStream os){
        Passageiro pas = new Passageiro(1,name,diasAndados);

        try {
            new PassageiroXML().save(pas,os);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<Passageiro> recuperarTodos(InputStream is){
        return new PassageiroXML().recuperar(is);
    }

}
