package com.fasterxml.jackson.test.misc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.hadoop.shaded.com.nimbusds.jose.util.StandardCharset;
import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.builder.AstBuilder;
import org.codehaus.groovy.ast.expr.DeclarationExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.ReturnStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.control.CompilePhase;
import org.junit.Ignore;

import com.fasterxml.jackson.test.BaseTest;

/*
import groovy.lang.GroovyShell;
import groovy.lang.MetaClass;
import groovy.lang.MetaMethod;
import groovy.lang.MetaProperty;
import groovy.lang.Script;
*/

public class GroovyParseTest extends BaseTest
{
    public void testSimpleExpr() throws Exception
    {
        AstBuilder b = new AstBuilder();
        List<ASTNode> nodes = b.buildFromString("33 * 3");

        /*
        System.out.println("List<ASTNode> ->");
        for (ASTNode node : nodes) {
            System.out.println(" ("+node.getLineNumber()+" / "+node.getClass().getName()
                    +"): "+node.getText());
        }
        */
        assertEquals(1, nodes.size());
    }

    @Ignore
    public void testDeploy() throws Exception
    {
        List<String> lines = readLines("/Users/tatu/deploy.jenkinsfile");
        // First, remove script header
        if (lines.get(0).startsWith("#!/usr/bin/env groovy")) {
            lines.remove(0);
        }

        // and then import statements, if any
        while (!lines.isEmpty()) {
            String line = lines.get(0).trim();
            if (!line.isEmpty()
                    && !line.startsWith("import ")
                    && !line.startsWith("@Library(")
            ) {
                break;
            }
            lines.remove(0);
        }
        
        String source = lines.stream()
//                .collect(Collectors.joining("\n", "{\n", "\n}\n"));
        .collect(Collectors.joining("\n", "", "\n"));
//        source = "{\n"+source+"\n}\n";

//System.out.println("Source = \n"+source);        
        
        List<ASTNode> nodes = new AstBuilder().buildFromString(
                CompilePhase.CONVERSION,
                true, source);
        System.out.println("List<ASTNode> -> [");
        for (ASTNode node : nodes) {
            printNode(node);
        }
        System.out.println("]");
    }

    @Ignore
    public void XXXtestBuildGradle() throws Exception
    {
        List<ASTNode> nodes = new AstBuilder().buildFromString(readFile("/Users/tatu/build.gradle"));

        System.out.println("List<ASTNode> -> [");
        for (ASTNode node : nodes) {
            printNode(node);
        }
        System.out.println("]");
    }
    
    private void printNode(ASTNode node) {
        if (node instanceof BlockStatement)  {
            BlockStatement block = (BlockStatement) node;
            printBlock(block);
        } else {
            System.out.println(" [UNKNOWN] ("+node.getLineNumber()+" / "+node.getClass().getName()
                    +"): "+node.getText());
        }
    }

    private void printBlock(BlockStatement block) {
        final List<Statement> stmts = block.getStatements();
        System.out.println(" BLOCK ("+stmts.size()+", line "+block.getLineNumber()+")"
                +" (labels: "+block.getStatementLabels()+"):");
        for (Statement stmt : stmts) {
            if (stmt instanceof ExpressionStatement) {
                ExpressionStatement expr = (ExpressionStatement) stmt;
                System.out.println("  (ExpressionStatement)("+stmt.getLineNumber()+")"
                        +" (labels: "+block.getStatementLabels()+"):");
                printExpression(expr.getExpression());
            } else if (stmt instanceof ReturnStatement) {
                ReturnStatement ret = (ReturnStatement) stmt;
                System.out.println("  (ReturnStatement)("+stmt.getLineNumber()+")"
                        +" "+ret.getText());
                printExpression(ret.getExpression());
            } else {
                System.out.println("  (UnknownStatement)("+stmt.getLineNumber()+" / "+stmt.getClass().getName());
            }
        }
    }

    private void printExpression(Expression expr) {
        ClassNode type = expr.getType();
        if (expr instanceof MethodCallExpression) {
            MethodCallExpression methodCall = (MethodCallExpression) expr;
            System.out.println("    (MethodCallExpression)"
                    +" returnType='"+type.getName()+"', name = '"+methodCall.getMethodAsString()+"' text: "+expr.getText());
        } else if (expr instanceof DeclarationExpression) {
            DeclarationExpression decl = (DeclarationExpression) expr;
            System.out.println("    (DeclarationExpression)"
                    +" left = "+decl.getLeftExpression().getText()
                    +", op = "+decl.getOperation().getDescription()
                    +", right = "+decl.getRightExpression().getText());
        } else {
            System.out.println("    (Expression/"+expr.getClass().getName()
                    +") returnType='"+type.getName()+"', text: "+expr.getText());
        }
    }

    private final List<String> readLines(String filename) throws IOException
    {
        try (Stream<String> str = Files.lines(Paths.get(filename), StandardCharset.UTF_8)) {
            return str.collect(Collectors.<String>toList());
        }
    }

    private final String readFile(String filename) throws IOException
    {
        return readLines(filename).stream().collect(Collectors.joining("\n", "", "\n"));
    }

    /*
    public void testBuildGradle() throws Exception
    {
        GroovyShell sh = new GroovyShell();
//        Script ast = sh.parse(new File("/Users/tatu/build.gradle"));
        Script ast = sh.parse("33 * 3");
        System.out.println("Script == "+ast);
        MetaClass meta = ast.getMetaClass();
        System.out.println("Meta == "+meta);
        
        System.out.println("Meta.properties ->");
        for (MetaProperty prop : meta.getProperties()) {
            System.out.println(" prop '"+prop.getName()+"'");
        }
        System.out.println("Meta.methods -> ");
        for (MetaMethod method : meta.getMetaMethods() ) {
            System.out.println(" method '"+method.getName()+"' / "+method.getDescriptor());
        }
    }
    */
}
