    package io.github.marcondesnjr.calconi.xml;

    import android.app.Activity;
    import android.content.Context;
    import android.os.Environment;

    import io.github.marcondesnjr.calconi.entities.Passageiro;
    import javax.xml.*;
    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.transform.OutputKeys;
    import javax.xml.transform.Transformer;
    import javax.xml.transform.TransformerFactory;
    import javax.xml.transform.dom.DOMSource;
    import javax.xml.transform.stream.StreamResult;

    import org.w3c.dom.*;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.OutputStream;
    import java.io.PrintStream;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Scanner;

    /**
     * Created by Junior on 22/03/2016.
     */
    public class PassageiroXML {

        public void save(List<Passageiro> pass, OutputStream os) throws IOException {
            PrintStream ps = null;
            List<String> strList = new ArrayList<>();
            try {
                for (Passageiro pas: pass) {
                    StringBuilder sb = new StringBuilder("id=");
                    sb.append(pas.getId()).append("&nome=").append(pas.getNome()).append("&diasAnd=").append(pas.getNumDiasAndados());
                    strList.add(sb.toString());
                }
                ps = new PrintStream(os);
                for(String line: strList){
                    ps.println(line);
                }
            }finally {
                ps.close();
            }
        }

        public void save(Passageiro pas, OutputStream os) throws IOException {
            PrintStream ps = new PrintStream(os);
            try {
                StringBuilder sb = new StringBuilder("id=");
                sb.append(pas.getId()).append("&nome=").append(pas.getNome()).append("&diasAnd=").append(pas.getNumDiasAndados());
                ps.println(sb.toString());
            }finally {
                ps.close();
            }
        }

        public List<Passageiro> recuperar(InputStream is){
            List<Passageiro> list = new ArrayList<>();
            Scanner scan = new Scanner(is);
            while(scan.hasNext()){
                String line = scan.nextLine();
                HashMap<String,String> hash = Util.StringToHash(line);
                Passageiro pass = new Passageiro(Integer.parseInt((String) hash.get("id")), (String) hash.get("nome"),
                        Integer.parseInt((String) hash.get("diasAnd")));
                list.add(pass);
            }
            return list;
        }

       /* public void save(Passageiro pass){
            DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder icBuilder;
            try {
                icBuilder = icFactory.newDocumentBuilder();
                Document doc = icBuilder.newDocument();
                Element mainRootElement = doc.createElementNS("http://crunchify.com/CrunchifyCreateXMLDOM", "Passageiros");
                doc.appendChild(mainRootElement);

                // append child elements to root element
                mainRootElement.appendChild(convertToXML(doc, pass.getId() + "", pass.getNome(), pass.getNumDiasAndados() + ""));

                // output DOM XML to console
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                File root = Environment.getExternalStorageDirectory();
                File fl = new File(root, "xml/passageiros.xml");
                StreamResult console = new StreamResult(fl);
                transformer.transform(source, console);

                System.out.println("\nXML DOM Created Successfully..");
                System.out.println(fl.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } */

        private static Node convertToXML(Document doc, String id, String name, String dias) {
            Element passageiro = doc.createElement("Passageiro");
            passageiro.setAttribute("id", id);
            passageiro.appendChild(putAttr(doc, passageiro, "Nome", name));
            passageiro.appendChild(putAttr(doc, passageiro, "QTDias", dias));
            return passageiro;
        }

        private static Node putAttr(Document doc, Element el, String name, String value){
            Element node = doc.createElement("name");
            node.appendChild(doc.createTextNode(value));
            el.appendChild(node);
            return node;
        }

    }
