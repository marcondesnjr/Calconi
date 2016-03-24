package io.github.marcondesnjr.calconi;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import io.github.marcondesnjr.calconi.entities.Passageiro;
import io.github.marcondesnjr.calconi.xml.PassageiroXML;
import junit.framework.*;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @SmallTest
    public static void main(String[] args) {
       // PassageiroXML dao = new PassageiroXML();
        //dao.save(new Passageiro(1, "Eu", 20));
    }
}