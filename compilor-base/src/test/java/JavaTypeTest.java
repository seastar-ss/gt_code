import com.shawn.ss.gen.model.class_structure.ModelParamEntry;

import javax.lang.model.element.ExecutableElement;

/**
 * Created by ss on 2018/7/7.
 */
public class JavaTypeTest {
    public <T extends ModelParamEntry> T getTest(T a){
        return null;
    }

//    public ModelParamEntry  getdTest(<? extends ModelParamEntry> t){
//        return null;
//    }

    public void testJavaExecuteElement() throws ClassNotFoundException {
        Class<?> javaTypeTest = Class.forName("JavaTypeTest");

    }
}
