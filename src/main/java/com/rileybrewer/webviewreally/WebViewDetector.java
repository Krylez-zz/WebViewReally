package com.rileybrewer.webviewreally;

import com.android.annotations.NonNull;
import com.android.tools.lint.detector.api.*;
import lombok.ast.*;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WebViewDetector extends ResourceXmlDetector implements Detector.JavaScanner {

    private static final String WEB_VIEW = "WebView";

    public static final Issue ISSUE_1 = Issue.create(
            "WebViewsAreDumb1",
            "WebView? Really? These are performance hogs.",
            "Looks for usages of WebView",
            "WebViews are heavyweight objects. They incur a significant performance penalty that visibly affects the " +
                    "UI. Even worse, they use significantly more memory than an equivalent native UI. You shouldn't " +
                    "use them.",
            Category.PERFORMANCE, 6, Severity.WARNING,
            new Implementation(WebViewDetector.class, Scope.RESOURCE_FILE_SCOPE));

    public static final Issue ISSUE_2 = Issue.create(
            "WebViewsAreDumb2",
            "WebView? Really? These are performance hogs.",
            "Looks for usages of WebView",
            "WebViews are heavyweight objects. They incur a significant performance penalty that visibly affects the " +
                    "UI. Even worse, they use significantly more memory than an equivalent native UI. You shouldn't " +
                    "use them.",
            Category.PERFORMANCE, 6, Severity.WARNING,
            new Implementation(WebViewDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public Collection<String> getApplicableElements() {
        return Collections.singletonList(
                "WebView");
    }

    @Override
    public void visitElement(XmlContext context, Element element) {
        context.report(
                ISSUE_1,
                element,
                context.getLocation(element),
                "WebView? Really? These are performance hogs.",
                null);
    }

    // ---- Implements JavaScanner ----

    @Override
    public boolean appliesTo(@NonNull Context context, @NonNull File file) {
        return true;
    }

    @Override
    public AstVisitor createJavaVisitor(@NonNull JavaContext context) {
        return new WebViewVisitor(context);
    }

    @Override
    public List<Class<? extends Node>> getApplicableNodeTypes() {
        List<Class<? extends Node>> types = new ArrayList<Class<? extends Node>>(1);
        types.add(ConstructorInvocation.class);
        return types;
    }

    private static class WebViewVisitor extends ForwardingAstVisitor {
        JavaContext context;
        public WebViewVisitor(JavaContext context) {
            this.context = context;
        }
        @Override
        public boolean visitConstructorInvocation(ConstructorInvocation node) {
            TypeReference reference = node.astTypeReference();
            String typeName = reference.astParts().last().astIdentifier().astValue();
            if (typeName.equals(WEB_VIEW)) {
                context.report(
                        ISSUE_2,
                        node,
                        context.getLocation(node),
                        "WebView? Really? These are performance hogs.",
                        null);
            }
            return super.visitConstructorInvocation(node);
        }
    }
}