package com.shawn.ss.gen.plug_in;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.http.GenericDownloadRequest;
import com.shawn.ss.lib.tools.http.HttpManager;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.plugins.annotations.ResolutionScope;
import javax.annotation.PostConstruct;
import javax.tools.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.List;



//@Mojo(name = "clean",
//        requiresDependencyResolution = ResolutionScope.TEST,
//        defaultPhase = LifecyclePhase.CLEAN,
//        threadSafe = true)
@Mojo(
        name = "pre-compile",
        requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME,
        defaultPhase = LifecyclePhase.GENERATE_RESOURCES
)
public class CodeGener extends AbstractMojo {

    @Parameter
    String hostServerUrl;

    @Parameter
    String secret;

    @Parameter
    String appId;

    @Parameter(defaultValue = "${project.artifactId}")
    String basePack;

    @Parameter(defaultValue = "docs")
    String docPos;

    @Parameter(defaultValue = "compilor")
    String compilorPos;

    @Parameter(defaultValue = "${project.build.outputDirectory}/tmpClass")
    String clzTmpPos;

    @Parameter(defaultValue = "https://sfs-public.shangdejigou.cn/knBase_online/transfer/compilor-base-all-2.0.jar")
    String compilorDownloadUrl;

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    private List projectRuntimeClasspathElements;
    private File basedir;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("start analyze project:" + project.getName());
        try {
            projectRuntimeClasspathElements = project.getRuntimeClasspathElements();
//            getLog().info(projectCompileClasspathElements.toString());
            getLog().info(projectRuntimeClasspathElements.toString());
//            getLog().info(project.getTestClasspathElements().toString());
        } catch (DependencyResolutionRequiredException e) {
            e.printStackTrace();
        }

        basedir = project.getBasedir();
        final File outputFile = new File(clzTmpPos);
        if (!outputFile.exists() && !outputFile.mkdirs()) {
            throw new IllegalStateException("can't create class-tmp folder");
        }
        final File compilorFile = new File(basedir, compilorPos);
        String cpjar = getCompilor(compilorFile);
        compileSourceCode(cpjar, outputFile);
    }

    private void compileSourceCode(String cpjar, File outputFile) {
        final Log logger = getLog();
        List<String> roots = project.getCompileSourceRoots();
        logger.info("get maven src:" + roots.toString());
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        List<File> allSrcFile = CollectionHelper.newList();
        putAllSrcFile(roots, allSrcFile);
        File confFile=new File(basedir,"project");
        String clzPath = asListStr(projectRuntimeClasspathElements);
        logger.info("class path:"+clzPath);
        List<String> options = CollectionHelper.<String>listBuilder()
                .add("-cp")
                .add(clzPath)
                .add("-processorpath")
                .add(cpjar)
                .add("-processor")
                .add("com.shawn.ss.gen.GenProcessor")
                .add("-d")
                .add(outputFile.getAbsolutePath())
                .add("-Aconf.file="+confFile.getAbsolutePath())
//                .add("")
                .add("-Asrc.base.fold="+roots.get(0))
//                .add("")
                .add("-Agen.file.pos="+basePack)
                .add("-Areport.url="+hostServerUrl)
//                .add("")
                .getList();
        final StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(diagnostics, null, null);

        CustomerJavaFileManager nM = new CustomerJavaFileManager(standardFileManager);
        int size = allSrcFile.size();
        File[] srcFiles = allSrcFile.toArray(new File[size]);
        logger.info("compile file count:"+size);
        Iterable<? extends JavaFileObject> compilationUnits = nM.getJavaFileObjects(srcFiles);

//        List<String> processor= Collections.singletonList("com.shawn.ss.gen.GenProcessor");
        JavaCompiler.CompilationTask task =
                compiler.getTask(new PrintWriter(System.out), nM, diagnostics, options, null, compilationUnits);

        boolean success = task.call();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            logger.debug(String.valueOf(diagnostic.getCode()));
            logger.debug(String.valueOf(diagnostic.getKind()));
            logger.debug(String.valueOf(diagnostic.getPosition()));
            logger.debug(String.valueOf(diagnostic.getStartPosition()));
            logger.debug(String.valueOf(diagnostic.getEndPosition()));
            logger.debug(String.valueOf(diagnostic.getSource()));
            logger.debug(String.valueOf(diagnostic.getMessage(null)));
        }
        getLog().info("run compilor succ :"+success);
//        compiler.run(null,null,null,)
//        JavaFileObject file = new JavaSourceFromString("HelloWorld", writer.toString());
//
//        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList();
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, null, null);
//        JavaFileManager fileManager = new ForwardingJavaFileManager(stdFileManager) {
//            public void flush() {
//                logger.info(StandardJavaFileManager.class.getName(), "flush");
//                super.flush();
//                logger.exiting(StandardJavaFileManager.class.getName(), "flush");
//            }
//        };
//        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
    }

    private String asListStr(List projectRuntimeClasspathElements) {
        StringBuilder ret=new StringBuilder();
        boolean first=true;
        for(Object o:projectRuntimeClasspathElements){
            if(o!=null ){
                ret.append(first?"":",").append(o);
                first=false;
            }
        }
        return ret.toString();
    }

    private void putAllSrcFile(List<String> roots, List<File> allSrcFile) {
        if (!CollectionHelper.isCollectionEmpty(roots)) {
            for (String root : roots) {
                if (!StringHelper.isEmpty(root)) {
                    getLog().info("add source file from :"+root);
                    addAllFileToList(new File(root), allSrcFile);
                }
            }
        }
    }

    private void addAllFileToList(File src, List<File> allSrcFile) {
        if (src == null) {
            return;
        }
//        File src=new File(root);
        if (src.exists()) {
            if (src.isDirectory()) {
                File[] files = src.listFiles();
                if (files != null && files.length > 0)
                    for (File af : files) {
                        addAllFileToList(af, allSrcFile);
                    }
            } else if (src.canRead() && src.getName().endsWith(".java")) {
                allSrcFile.add(src);
            }
        }
    }

    private String getCompilor(File compilorFolder) {
        if (!compilorFolder.exists() && !compilorFolder.mkdirs()) {
            throw new IllegalStateException("can't create compilor folder");
        }
        File cp = new File(compilorFolder, "cp.jar");
        final String path = cp.getAbsolutePath();
        if (cp.exists()) {

        } else {
            getLog().info("download annotation processor ~~~");
            HttpManager.getHelper().download(new GenericDownloadRequest(path) {
                @Override
                public byte[] getBody() {
                    return new byte[0];
                }

                @Override
                public String getUrl() {
                    return compilorDownloadUrl;
                }
            });
        }
        return path;
    }
}
