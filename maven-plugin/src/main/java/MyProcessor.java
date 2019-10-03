import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyProcessor extends AbstractProcessor {

    public static @interface X { String value(); }
    public static  @interface Name { String value(); }

    @X("Hello") public static class Y {

    }
    @X("yes") @Name("test") public static class Z {
        static{
            System.out.println("hello");
        }
    }

    @Override public boolean process(Set<? extends TypeElement> annotations,
                                     RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getRootElements()) {
            X x = element.getAnnotation(X.class);
            if (x != null) System.out.println(x.value());
        }


        return true;
    }

    @Override public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<String>(Arrays.asList(X.class.getCanonicalName()));
    }

    @Override public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_6;
    }

    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        List<String> classes = Arrays.asList(Y.class.getCanonicalName(),Z.class.getCanonicalName());
        List<String> options = Arrays.asList("-processor", MyProcessor.class
                .getCanonicalName());
        JavaCompiler.CompilationTask task = compiler.getTask(null, null, null, null, classes,
                null);
        task.setProcessors(Arrays.asList(new MyProcessor()));
        task.call();
    }
}
