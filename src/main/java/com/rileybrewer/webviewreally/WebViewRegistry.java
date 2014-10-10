package com.rileybrewer.webviewreally;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;

import java.util.Arrays;
import java.util.List;

public class WebViewRegistry extends IssueRegistry {

    public WebViewRegistry() {}

    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                WebViewDetector.ISSUE_1,
                WebViewDetector.ISSUE_2
        );
    }
}
