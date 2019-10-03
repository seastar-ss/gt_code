package com.shawn.ss.gen.plug_in;

import com.shawn.ss.lib.tools.CollectionHelper;
import edu.emory.mathcs.backport.java.util.Collections;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;

public class CompilorTest {
    public static void main(String args[]) throws IOException {
        run1();
    }

    public static void run2(){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        final int supportedOption = compiler.isSupportedOption("-g ");
        System.out.println(supportedOption);
    }

    public static  void run1(){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        out.println("public class HelloWorld {");
        out.println("  public static void main(String args[]) {");
        out.println("    System.out.println(\"This is in another java file\"+com.shawn.ss.lib.tools.CollectionHelper.class);");
        out.println("  }");
        out.println("}");
        out.close();
        JavaFileObject file = new JavaSourceFromString("HelloWorld", writer.toString());

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        List<String> options= CollectionHelper.<String>listBuilder()
                .add("-cp")
                .add("D:\\project\\newProject\\new_code_gen\\new_code_gen\\maven-plugin\\libs\\base-5.7.7.jar")
                .add("-processorpath")
                .add("D:\\project\\newProject\\new_code_gen\\new_code_gen\\maven-plugin\\compilor\\compilor-base-all-1.0.jar")
                .add("-processor")
                .add("com.shawn.ss.gen.GenProcessor")
                .add("-d")
                .add("D:\\project\\newProject\\new_code_gen\\new_code_gen\\maven-plugin\\tmpclass")
                .add("-Aconf.file=D:\\project\\newProject\\new_code_gen\\new_code_gen\\maven-plugin\\project\\")
//                .add("")
                .add("-Asrc.base.fold=D:\\project\\newProject\\new_code_gen\\new_code_gen\\maven-plugin\\src\\main\\java")
//                .add("")
                .add("-Agen.file.pos=com.sunlands.uuid_war.base_service")
//                .add("")
                .getList();
        final StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(diagnostics, null, null);

        JavaFileManager nM= new CustomerJavaFileManager(standardFileManager);

        List<String> processor= Collections.singletonList("com.shawn.ss.gen.GenProcessor");
        CompilationTask task =
                compiler.getTask(new PrintWriter(System.out), nM, diagnostics, options, null, compilationUnits);

        boolean success = task.call();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));

        }
        System.out.println("Success: " + success);

        if (success) {
            try {
                Class.forName("HelloWorld").getDeclaredMethod("main", new Class[] { String[].class })
                        .invoke(null, new Object[] { null });
            } catch (ClassNotFoundException e) {
                System.err.println("Class not found: " + e);
            } catch (NoSuchMethodException e) {
                System.err.println("No such method: " + e);
            } catch (IllegalAccessException e) {
                System.err.println("Illegal access: " + e);
            } catch (InvocationTargetException e) {
                System.err.println("Invocation target: " + e);
            }
        }
    }

}

